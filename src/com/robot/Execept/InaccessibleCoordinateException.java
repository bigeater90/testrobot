package com.robot.Execept;

import com.robot.Coordinates;

/**
 * Created with IntelliJ IDEA.
 * User: fabrice
 * Date: 26/11/13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class InaccessibleCoordinateException extends Exception {
    private Coordinates coordinate;

    public InaccessibleCoordinateException(Coordinates coordinate) {
        this.coordinate = coordinate;
    }
}
