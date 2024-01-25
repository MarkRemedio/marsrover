import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverTest {

    @Test
    void testNegativeXAxis() {
        Rover rover = new Rover();
        String result = rover.processInstructions("MMLM");
        assertEquals("0,2,W", result);
    }

    @Test
    void testNegativeYAxis() {
        Rover rover = new Rover();
        String result = rover.processInstructions("RMRM");
        assertEquals("1,0,S", result);
    }

    @Test
    void testSampleInput() {
        Rover rover = new Rover();
        String result = rover.processInstructions("LMLMLMLMLM");
        assertEquals("0,1,W", result);
    }

    @Test
    void testLRMovement() {
        Rover rover = new Rover();
        String result = rover.processInstructions("RMMMLMMM");
        assertEquals("3,3,N", result);
    }

    @Test
    void testROnlyMovement() {
        Rover rover = new Rover();
        String result = rover.processInstructions("RMMMMMM");
        assertEquals("6,0,E", result);
    }

    @Test
    void testLOnlyMovement() {
        Rover rover = new Rover();
        String result = rover.processInstructions("LMMMMMM");
        assertEquals("0,0,W", result);
    }

    @Test
    void testNoMovement() {
        Rover rover = new Rover();
        String result = rover.processInstructions("RRLL");
        assertEquals("0,0,N", result);
    }

    @Test
    void testWrongInput() {
        Rover rover = new Rover();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rover.processInstructions("LWMM");
        });
        assertEquals("Invalid instruction:W", exception.getMessage());
    }
}
