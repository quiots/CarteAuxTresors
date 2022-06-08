package treasures_hunt.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import treasures_hunt.model.treasurehunter.Movement;
import treasures_hunt.model.treasurehunter.Orientation;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class UtilEnumTest {

    private String instruction;
    private char char_instruction;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        instruction = null;
    }

    @Test
    void getStackMovementWithCorrectInstruction() {
        instruction = "DAGA";
        Stack<Movement> mov = UtilEnum.getStackMovement(instruction);
        assertEquals(Movement.RIGHT_ROTATION,mov.pop());
    }

    @Test
    void getStackMovementWithInvalidInstruction() {
        instruction = "DFXS";
        Stack<Movement> mov = UtilEnum.getStackMovement(instruction);
        assertEquals(null,mov.get(1));
    }

    @Test
    void getMovementWithCorrectInstruction() {
        char_instruction = 'D';
        Movement m = UtilEnum.getMovement(char_instruction);
        assertEquals(Movement.RIGHT_ROTATION,m);
    }

    @Test
    void getMovementWithInvalidInstruction() {
        char_instruction = 'X';
        Movement m = UtilEnum.getMovement(char_instruction);
        assertEquals(null,m);
    }

    @Test
    void getOrientationWithCorrectInstruction() {
        instruction = "N";
        Orientation o = UtilEnum.getOrientation(instruction);
        assertEquals(Orientation.N,o);
    }

    @Test
    void getOrientationWithInvalidInstruction(){
        instruction = "X";
        Orientation o = UtilEnum.getOrientation(instruction);
        assertEquals(null,o);
    }
}
