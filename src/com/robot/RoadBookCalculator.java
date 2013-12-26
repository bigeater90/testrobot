package com.robot;

import com.robot.enumeration.Direction;
import com.robot.enumeration.Instruction;

import java.util.ArrayList;
import java.util.List;

public class RoadBookCalculator {

    // la methode n'était pas public
    public static RoadBook calculateRoadBook(Direction direction, Coordinates position, Coordinates destination, ArrayList<Instruction> instructions) {
        List<Direction> directionList = new ArrayList<Direction>();
        if (destination.getX() < position.getX()) directionList.add(Direction.WEST);
        if (destination.getX() > position.getX()) directionList.add(Direction.EAST);
        if (destination.getY() < position.getY()) directionList.add(Direction.SOUTH);
        if (destination.getY() > position.getY()) directionList.add(Direction.NORTH);
        if (directionList.isEmpty()) return new RoadBook(instructions);
        if (directionList.contains(direction)) {
            instructions.add(Instruction.FORWARD);
            return calculateRoadBook(direction, MapTools.nextForwardPosition(position, direction), destination, instructions);
        } else {
            instructions.add(Instruction.TURNRIGHT);
            return calculateRoadBook(MapTools.clockwise(direction), position, destination, instructions);
        }
    }
}