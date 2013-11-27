package robot;

import robot.Enum.Direction;
import robot.Enum.Instruction;

import java.util.ArrayList;
import java.util.List;

import static robot.Enum.Direction.*;
import static robot.Enum.Instruction.*;

public class RoadBookCalculator {

    static RoadBook calculateRoadBook(Direction direction, Coordinates position, Coordinates destination, ArrayList<Instruction> instructions) {
        List<Direction> directionList = new ArrayList<Direction>();
        if (destination.getX() < position.getX()) directionList.add(WEST);
        if (destination.getX() > position.getX()) directionList.add(Direction.EAST);
        if (destination.getY() < position.getY()) directionList.add(Direction.SOUTH);
        if (destination.getY() > position.getY()) directionList.add(Direction.NORTH);
        if (directionList.isEmpty()) return new RoadBook(instructions);
        if (directionList.contains(direction)) {
            instructions.add(FORWARD);
            return calculateRoadBook(direction, MapTools.nextForwardPosition(position, direction), destination, instructions);
        } else {
            instructions.add(TURNRIGHT);
            return calculateRoadBook(MapTools.clockwise(direction), position, destination, instructions);
        }
    }
}