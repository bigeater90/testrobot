import com.robot.Coordinates;
import com.robot.RoadBook;
import com.robot.RoadBookCalculator;
import com.robot.enumeration.Direction;
import com.robot.enumeration.Instruction;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

/**
 * User: Jean
 * Date: 26/12/2013
 */

public class RoadBookCalculatorUnitTest {

    @Test
    public void testCalculateRoadBook1(){
        RoadBook test = RoadBookCalculator.calculateRoadBook(Direction.NORTH, new Coordinates(1,1), new Coordinates(1,1), new ArrayList<Instruction>());
        Assert.assertEquals(false,test.hasInstruction());
    }

    @Test
    public void testCalculateRoadBook2(){
        RoadBook test = RoadBookCalculator.calculateRoadBook(Direction.NORTH, new Coordinates(0,0), new Coordinates(2,2), new ArrayList<Instruction>());
        Assert.assertEquals(true,test.hasInstruction());
        Assert.assertEquals(Instruction.FORWARD,test.next());
        Assert.assertEquals(Instruction.FORWARD,test.next());
        Assert.assertEquals(Instruction.TURNRIGHT,test.next());
        Assert.assertEquals(Instruction.FORWARD,test.next());
        Assert.assertEquals(Instruction.FORWARD,test.next());
        Assert.assertEquals(false,test.hasInstruction());
    }

    @Test
    public void testCalculateRoadBook3(){
        RoadBook test = RoadBookCalculator.calculateRoadBook(Direction.NORTH,new Coordinates(0,0),new Coordinates(-5,-1),new ArrayList<Instruction>());
        Assert.assertEquals(true,test.hasInstruction());
        Assert.assertEquals(Instruction.TURNRIGHT,test.next());
        Assert.assertEquals(Instruction.TURNRIGHT,test.next());
        Assert.assertEquals(Instruction.FORWARD,test.next());
        Assert.assertEquals(Instruction.TURNRIGHT,test.next());
        for (int i=0;i<5;i++){
            Assert.assertEquals(Instruction.FORWARD,test.next());
        }
        Assert.assertEquals(false,test.hasInstruction());
    }

}
