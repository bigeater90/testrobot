package com.robot;

import com.robot.Execept.InsufficientChargeException;

import java.util.Timer;
import java.util.TimerTask;

public class Battery {

    private final long CHARGE_TOP = 1000;
    private final long CHARGE_STEP = 10;
    private float chargeLevel;

    public Battery() {
        chargeLevel = 100;
    }

    public void charge() {
        chargeLevel += CHARGE_STEP;
    }

    public void setUp() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                charge();
            }
        }, 0, CHARGE_TOP);
    }

    public float getChargeLevel(){
        return chargeLevel;
    }

    public void use(double energy) throws InsufficientChargeException {
        if (chargeLevel < energy) throw new InsufficientChargeException();
        chargeLevel -= energy;
    }

    public long timeToSufficientCharge(double neededEnergy) {
        int clock = 0;
        float charge = chargeLevel;
        while (charge<neededEnergy) {
            charge += CHARGE_STEP;
            clock++;
        }
        return clock*CHARGE_TOP;
    }

    public boolean canDeliver(double neededEnergy) {
        return (chargeLevel >= neededEnergy);
    }
}
