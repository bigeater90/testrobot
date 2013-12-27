import com.robot.Battery;
import com.robot.Coordinates;
import com.robot.LandSensor;
import com.robot.Robot;
import com.robot.enumeration.Direction;
import com.robot.enumeration.Land;
import com.robot.exception.InsufficientChargeException;
import com.robot.exception.UnlandedRobotException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

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

    @Ignore
    @Test (expected = InsufficientChargeException.class)
    public void testMoveForward2() throws Exception {
        r.land(new Coordinates(0,0),ls);
        r.moveForward();
        Assert.assertEquals(0,r.getXposition());
        Assert.assertEquals(1,r.getYposition());
    }

    @Test
    public void testMoveForward3() throws Exception {
        r.land(new Coordinates(0,0),ls);
        r.moveForward();
        Assert.assertEquals(0,r.getXposition());
        Assert.assertEquals(1,r.getYposition());
    }

}