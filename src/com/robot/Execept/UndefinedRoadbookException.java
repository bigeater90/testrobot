package com.robot.Execept;

public class UndefinedRoadbookException extends Exception {
    public UndefinedRoadbookException() {
        super("Aucun road book défini");
    }
}
