package treasures_hunt.model.map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import treasures_hunt.exception.EmptyLinesInstructionsException;
import treasures_hunt.exception.GenerateMapException;
import treasures_hunt.model.Position;
import treasures_hunt.service.TreasureMapService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreasureMapTest {

    private TreasureMap tMap;
    private List<String> instructions;

    @BeforeEach
    void setUp() throws EmptyLinesInstructionsException, GenerateMapException {
        instructions = new ArrayList<>();
        instructions.add("C - 12 - 6");
        Tile[][] tilesMap = TreasureMapService.generateMapTiles(instructions);
        tMap = new TreasureMap(tilesMap);
    }

    @AfterEach
    void tearDown() {
        tMap=null;
        instructions=null;
    }


    @Test
    void positionIsOutOfBounds() {
        assertTrue(tMap.positionIsOutOfBounds(new Position(16,24)));
    }

    @Test
    void positionIsInMap() {
        assertFalse(tMap.positionIsOutOfBounds(new Position(1,1)));
    }

    @Test
    void getMapLimitCorner() {
        assertEquals(tMap.getMapLimitCorner().getX(),11);
        assertEquals(tMap.getMapLimitCorner().getY(),5);
    }

}
