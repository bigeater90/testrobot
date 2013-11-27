package com.robot.Execept;


public class UnlandedRobotException extends Exception {

    public UnlandedRobotException() {
        super("Le robot doit être posé avant tout déplacement");
    }
}
