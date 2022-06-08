package treasures_hunt.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import treasures_hunt.exception.EmptyLinesInstructionsException;
import treasures_hunt.exception.GenerateMapException;
import treasures_hunt.exception.GenerateTreasureHunterException;
import treasures_hunt.model.Position;
import treasures_hunt.model.treasurehunter.Orientation;
import treasures_hunt.model.treasurehunter.TreasureHunter;
import treasures_hunt.util.UtilEnum;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreasureHunterServiceTest {

    private TreasureHunter hunter;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        hunter = null;
    }

    @Test
    void createTreasureHunterWithCorrectInstruction() throws GenerateTreasureHunterException {
        String[] instruction = {"A","Indiana","1","1","S","DGAD"};
        hunter = TreasureHunterService.createTreasureHunter(instruction);
        assertEquals("Indiana",hunter.getName());
        assertEquals(new Position(1,1).toString(),hunter.getPosition().toString());
        assertEquals(Orientation.S,hunter.getOrientation());
        assertEquals(UtilEnum.getStackMovement("DGAD"),hunter.getMovements());
    }

    @Test
    void createTreasureHunterWithWrongSizeInstruction() {
        assertThrows(GenerateTreasureHunterException.class,
                ()->{
                    String[] instruction = {"A","Indiana","1","1","S","DGAD","G","6"};
                    hunter = TreasureHunterService.createTreasureHunter(instruction);
                });
    }

}
