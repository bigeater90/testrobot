package com.robot;

import com.robot.Execept.InaccessibleCoordinateException;
import com.robot.Execept.LandSensorDefaillance;
import com.robot.Execept.UnlandedRobotException;

import java.util.Random;

public class Main {

    static Robot R = new Robot();
    static LandSensor land = new LandSensor(new Random());

    public static void main(String[] args) {
        Coordinates cord1 = new Coordinates(1,1);
        Coordinates cord2 = new Coordinates(2,2);
        try {
            System.out.println(land.getPointToPointEnergyCoefficient(cord1,cord2));
        }
        catch (LandSensorDefaillance lsd){
            System.err.println("lsd: " + lsd.getMessage());
        }
        catch (InaccessibleCoordinateException ice){
            System.err.println("ice: " + ice.getMessage());
        }
        try {
            R.land(cord1,land);
            //System.out.println("coucou");
            R.computeRoadTo(cord2);
        }
        catch (UnlandedRobotException ure){
            System.err.println("ure: " + ure.getMessage());
        }
    }
}
