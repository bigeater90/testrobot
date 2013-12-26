import com.robot.RoadBook;
import com.robot.enumeration.Instruction;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Iterator;
import java.util.List;

/**
 * User: Jean
 * Date: 26/12/2013
 */

public class RoadBookUnitTest {

    List<Instruction> instructions;
    RoadBook rb;

    @Before
    public void init(){
        instructions = Mockito.mock(List.class);
        Mockito.when(instructions.iterator()).thenReturn(new Iterator() {
            int test = 0;
            @Override
            public boolean hasNext() {
                test++;
                if (test<3){
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                test++;
                if (test<3){
                    return Instruction.FORWARD;
                }
                return null;
            }

            @Override
            public void remove() {}
        });
        rb = new RoadBook(instructions);
    }

    @Test
    public void testHasInstruction(){
        Assert.assertTrue(rb.hasInstruction());
        Assert.assertTrue(rb.hasInstruction());
        Assert.assertFalse(rb.hasInstruction());
    }

    @Test
    public void testNext(){
        Assert.assertEquals(Instruction.FORWARD,rb.next());
        Assert.assertEquals(Instruction.FORWARD,rb.next());
        Assert.assertEquals(null,rb.next());
    }

}