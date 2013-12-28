import com.robot.*;
import com.robot.enumeration.Direction;
import com.robot.enumeration.Instruction;
import com.robot.enumeration.Land;
import com.robot.exception.InsufficientChargeException;
import com.robot.exception.UndefinedRoadbookException;
import com.robot.exception.UnlandedRobotException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * User: Jean
 * Date: 27/12/2013
 */
public class RobotUnitTest {

    Robot r;
    LandSensor ls;
    Random rand;

    @Before
    public void init(){
        r = new Robot(0.0,new Battery());
        rand = Mockito.mock(Random.class);
        Mockito.when(rand.nextInt(Land.CountLand())).thenReturn(0);
        ls = new LandSensor(rand);
    }

    @Test (expected = UnlandedRobotException.class)
    public void testGetXposition1() throws Exception {
        r.getXposition();
    }

    @Test (expected = UnlandedRobotException.class)
    public void testGetYposition1() throws Exception {
        r.getYposition();
    }

    @Test
    public void testGetPositions() throws Exception {
        r.land(new Coordinates(0, 0), new LandSensor(new Random()));
        Assert.assertEquals(0, r.getXposition());
        Assert.assertEquals(0, r.getYposition());
    }

    @Test (expected = UnlandedRobotException.class)
    public void tesGetDirection1() throws Exception {
        r.getDirection();
    }

    @Test
    public void tesGetDirection2() throws Exception {
        r.land(new Coordinates(0,0),new LandSensor(new Random()));
        Assert.assertEquals(Direction.NORTH,r.getDirection());
    }

    @Test (expected = UnlandedRobotException.class)
    public void testMoveForward1() throws Exception {
        r.moveForward();
    }

    @Test
    public void testMoveForward2() throws Exception {
        r.land(new Coordinates(0,0),ls);
        r.moveForward();
        Assert.assertEquals(0,r.getXposition());
        Assert.assertEquals(1,r.getYposition());
    }

    @Test (expected = InsufficientChargeException.class)
    public void testMoveTo() throws Exception {
        Robot r = new Robot(70.0,new Battery());
        r.land(new Coordinates(0,0),ls);
        r.moveForward();
        r.moveForward();
        Assert.assertEquals(0,r.getXposition());
        Assert.assertEquals(1,r.getYposition());
    }

    @Test (expected = UnlandedRobotException.class)
    public void testMoveBackward1() throws Exception {
        r.moveBackward();
    }

    @Test
    public void testMoveBackward2() throws Exception {
        r.land(new Coordinates(0,0),ls);
        r.moveBackward();
        Assert.assertEquals(0,r.getXposition());
        Assert.assertEquals(-1,r.getYposition());
    }

    @Test (expected = UnlandedRobotException.class)
    public void testTurnLeft1() throws Exception{
        r.turnLeft();
    }

    @Test
    public void testTurnLeft2() throws Exception {
        r.land(new Coordinates(0,0),new LandSensor(new Random()));
        Assert.assertEquals(Direction.NORTH,r.getDirection());
        r.turnLeft();
        Assert.assertEquals(Direction.WEST,r.getDirection());
        r.turnLeft();
        Assert.assertEquals(Direction.SOUTH,r.getDirection());
        r.turnLeft();
        Assert.assertEquals(Direction.EAST,r.getDirection());
        r.turnLeft();
        Assert.assertEquals(Direction.NORTH,r.getDirection());
    }

    @Test (expected = UnlandedRobotException.class)
    public void testTurnRight1() throws Exception {
        r.turnRight();
    }

    @Test
    public void testTurnRight2() throws Exception {
        r.land(new Coordinates(0,0),new LandSensor(new Random()));
        Assert.assertEquals(Direction.NORTH, r.getDirection());
        r.turnRight();
        Assert.assertEquals(Direction.EAST, r.getDirection());
        r.turnRight();
        Assert.assertEquals(Direction.SOUTH, r.getDirection());
        r.turnRight();
        Assert.assertEquals(Direction.WEST, r.getDirection());
        r.turnRight();
        Assert.assertEquals(Direction.NORTH,r.getDirection());
    }

    @Test (expected = UndefinedRoadbookException.class)
    public void testLetsGo1() throws Exception {
        r.letsGo();
    }

    @Test
    public void testLetsGo2() throws Exception {
        r.land(new Coordinates(0,0),ls);
        r.setRoadBook(RoadBookCalculator.calculateRoadBook(Direction.NORTH, new Coordinates(0,0), new Coordinates(0,1), new ArrayList<Instruction>()));
        r.letsGo();
        Assert.assertEquals(0,r.getXposition());
        Assert.assertEquals(1,r.getYposition());
    }

    /**
     *  Instructions:  ↓ ↓ ← ↓ → ↓ ↓ ↓ ← ↑ →
     */
    @Test
    public void testLetsGo3() throws Exception {
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        instructions.add(Instruction.BACKWARD);
        instructions.add(Instruction.BACKWARD);
        instructions.add(Instruction.TURNLEFT);
        instructions.add(Instruction.FORWARD);
        instructions.add(Instruction.TURNLEFT);
        instructions.add(Instruction.FORWARD);
        instructions.add(Instruction.TURNLEFT);
        instructions.add(Instruction.FORWARD);
        instructions.add(Instruction.TURNRIGHT);
        instructions.add(Instruction.FORWARD);
        instructions.add(Instruction.FORWARD);
        instructions.add(Instruction.FORWARD);
        instructions.add(Instruction.TURNRIGHT);
        instructions.add(Instruction.FORWARD);
        instructions.add(Instruction.TURNRIGHT);
        instructions.add(Instruction.FORWARD);
        instructions.add(Instruction.TURNRIGHT);
        instructions.add(Instruction.FORWARD);
        r.land(new Coordinates(0,0),ls);
        r.setRoadBook(new RoadBook(instructions));
        r.letsGo();
        Assert.assertEquals(0,r.getXposition());
        Assert.assertEquals(-5,r.getYposition());
        Assert.assertEquals(Direction.EAST,r.getDirection());
    }

    @Test
    public void testLetsGo4() throws Exception {
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        instructions.add(Instruction.FORWARD);
        instructions.add(null);
        instructions.add(Instruction.FORWARD);
        r.land(new Coordinates(0, 0), ls);
        r.setRoadBook(new RoadBook(instructions));
        r.letsGo();
        Assert.assertEquals(0,r.getXposition());
        Assert.assertEquals(2,r.getYposition());
        Assert.assertEquals(Direction.NORTH,r.getDirection());
    }

    @Test (expected = UnlandedRobotException.class)
    public void testComputedTo1() throws Exception {
        r.computeRoadTo(new Coordinates(0,0));
    }

    @Test
    public void testComputedTo2() throws Exception {
        r.land(new Coordinates(0,0),ls);
        r.computeRoadTo(new Coordinates(2,2));
        r.letsGo();
        Assert.assertEquals(2,r.getXposition());
        Assert.assertEquals(2,r.getYposition());
    }

}