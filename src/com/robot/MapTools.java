package com.robot;

import com.robot.enumeration.Direction;

//import static com.robot.enumeration.Direction.*;

public class MapTools {

    static Coordinates nextForwardPosition(Coordinates position, Direction direction) {
        if (direction == Direction.NORTH)
            return new Coordinates(position.getX(), position.getY() + 1);
        if (direction == Direction.SOUTH)
            return new Coordinates(position.getX(), position.getY() - 1);
        if (direction == Direction.EAST)
            return new Coordinates(position.getX() + 1, position.getY());
        return new Coordinates(position.getX() - 1, position.getY());
    }

    static Coordinates nextBackwardPosition(Coordinates position, Direction direction) {
        if (direction == Direction.NORTH)
            return new Coordinates(position.getX(), position.getY() - 1);
        if (direction == Direction.SOUTH)
            return new Coordinates(position.getX(), position.getY() + 1);
        if (direction == Direction.EAST)
            return new Coordinates(position.getX() - 1, position.getY());
        return new Coordinates(position.getX() + 1, position.getY());
    }

    static Direction counterclockwise(Direction direction) {
        if (direction == Direction.NORTH) return Direction.WEST;
        if (direction == Direction.WEST) return Direction.SOUTH;
        if (direction == Direction.SOUTH) return Direction.EAST;
        return Direction.NORTH;
    }

    static Direction clockwise(Direction direction) {
        if (direction == Direction.NORTH) return Direction.EAST;
        if (direction == Direction.EAST) return Direction.SOUTH;
        if (direction == Direction.SOUTH) return Direction.WEST;
        return Direction.NORTH;
    }
}