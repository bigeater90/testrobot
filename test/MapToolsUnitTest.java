import com.robot.Coordinates;
import com.robot.MapTools;
import com.robot.enumeration.Direction;
import junit.framework.Assert;
import org.junit.Test;



/**
 * User: Jean
 * Date: 07/12/2013
 */
public class MapToolsUnitTest {

    @Test
    public void testNextForwardPosition1() {
        Coordinates ini = new Coordinates(0, 0);
        Coordinates position = MapTools.nextForwardPosition(ini, Direction.NORTH);
        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(1, position.getY());
    }

    @Test
    public void testNextForwardPosition2() {
        Coordinates ini = new Coordinates(0, 0);
        Coordinates position = MapTools.nextForwardPosition(ini,Direction.SOUTH);
        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(-1, position.getY());
    }

    @Test
    public void testNextForwardPosition3() {
        Coordinates ini = new Coordinates(0, 0);
        Coordinates position = MapTools.nextForwardPosition(ini,Direction.EAST);
        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(0, position.getY());
    }

    @Test
    public void testNextForwardPosition4() {
        Coordinates ini = new Coordinates(0, 0);
        Coordinates position = MapTools.nextForwardPosition(ini,Direction.WEST);
        Assert.assertEquals(-1, position.getX());
        Assert.assertEquals(0, position.getY());
    }

}
