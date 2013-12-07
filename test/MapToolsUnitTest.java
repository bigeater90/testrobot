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


    @Test
    public void testNextBackwardPosition1() {
        Coordinates ini = new Coordinates(0, 0);
        Coordinates position = MapTools.nextBackwardPosition(ini, Direction.NORTH);
        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(-1, position.getY());
    }

    @Test
    public void testNextBackwardPosition2() {
        Coordinates ini = new Coordinates(0, 0);
        Coordinates position = MapTools.nextBackwardPosition(ini, Direction.SOUTH);
        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(1, position.getY());
    }

    @Test
    public void testNextBackwardPosition3() {
        Coordinates ini = new Coordinates(0, 0);
        Coordinates position = MapTools.nextBackwardPosition(ini, Direction.WEST);
        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(0, position.getY());
    }

    @Test
    public void testNextBackwardPosition4() {
        Coordinates ini = new Coordinates(0, 0);
        Coordinates position = MapTools.nextBackwardPosition(ini, Direction.EAST);
        Assert.assertEquals(-1, position.getX());
        Assert.assertEquals(0, position.getY());
    }

    @Test
    public void counterclockwise1(){
        Assert.assertEquals(Direction.WEST,MapTools.counterclockwise(Direction.NORTH));
    }

    @Test
    public void counterclockwise2(){
        Assert.assertEquals(Direction.SOUTH,MapTools.counterclockwise(Direction.WEST));
    }

    @Test
    public void counterclockwise3(){
        Assert.assertEquals(Direction.EAST,MapTools.counterclockwise(Direction.SOUTH));
    }

    @Test
    public void counterclockwise4(){
        Assert.assertEquals(Direction.NORTH,MapTools.counterclockwise(Direction.EAST));
    }

    @Test
    public void clockwise1(){
        Assert.assertEquals(Direction.EAST,MapTools.clockwise(Direction.NORTH));
    }

    @Test
    public void clockwise2(){
        Assert.assertEquals(Direction.SOUTH,MapTools.clockwise(Direction.EAST));
    }

    @Test
    public void clockwise3(){
        Assert.assertEquals(Direction.WEST,MapTools.clockwise(Direction.SOUTH));
    }

    @Test
    public void clockwise4(){
        Assert.assertEquals(Direction.NORTH,MapTools.clockwise(Direction.WEST));
    }
}
