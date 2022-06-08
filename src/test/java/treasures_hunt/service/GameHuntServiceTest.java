package treasures_hunt.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import treasures_hunt.exception.EmptyLinesInstructionsException;
import treasures_hunt.exception.GenerateMapException;
import treasures_hunt.exception.GenerateTreasureHunterException;
import treasures_hunt.exception.OutOfValidTileMapException;
import treasures_hunt.model.GameTreasureHunt;
import treasures_hunt.model.Position;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameHuntServiceTest {

    private GameTreasureHunt game;
    private List<String> instructions;

    @BeforeEach
    void setUp() {
        instructions = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        game = null;
        instructions = null;
    }

    @Test
    void initGameTreasureHuntWithCorrectInstructions() throws OutOfValidTileMapException, GenerateTreasureHunterException, GenerateMapException, EmptyLinesInstructionsException {
        instructions.add("C - 4 - 3");
        instructions.add("M - 1 - 1");
        instructions.add("T - 2 - 2 - 3");
        instructions.add("A - Tom - 1 - 2 - E - ADA");
        game = GameHuntService.initGameTreasureHunt(instructions);

        assertEquals(game.getMap().getMapLimitCorner().getX(),3);
        assertEquals(game.getMap().getMapLimitCorner().getY(),2);
        assertEquals(game.getMap().getTile(new Position(1,1)).getType(),"M");
        assertTrue(game.getMap().getTile(new Position(2,2)).hasTreasures());
        assertEquals(game.getMap().getTile(new Position(1,2)).getHunterPresent().getName(),"Tom");
    }

    @Test
    void initGameTreasureHuntWithWrongHunterPosition() throws OutOfValidTileMapException, GenerateTreasureHunterException, GenerateMapException, EmptyLinesInstructionsException {
        instructions.add("C - 4 - 3");
        instructions.add("A - Tom - 1 - 8 - E - ADA");
        assertThrows(OutOfValidTileMapException.class,
                ()->{
                    game = GameHuntService.initGameTreasureHunt(instructions);
                });

    }

    @Test
    void initGameTreasureHuntWithNoInstruction() throws OutOfValidTileMapException, GenerateTreasureHunterException, GenerateMapException, EmptyLinesInstructionsException {
        assertThrows(EmptyLinesInstructionsException.class,
                ()->{
                    game = GameHuntService.initGameTreasureHunt(instructions);
                });

    }

}
