package treasures_hunt.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import treasures_hunt.exception.EmptyLinesInstructionsException;
import treasures_hunt.exception.GenerateMapException;
import treasures_hunt.model.Position;
import treasures_hunt.model.map.Tile;
import treasures_hunt.model.map.TreasureMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreasureMapServiceTest {

    private Tile[][] tilesMap;

    @AfterEach
    void tearDown() {
        tilesMap = null;
    }

    @Test
    void initCorrectMap() throws EmptyLinesInstructionsException, GenerateMapException {
        List<String> lines = new ArrayList<>();
        lines.add("C - 5 - 7");
        tilesMap = TreasureMapService.generateMapTiles(lines);
        assertEquals(5,tilesMap.length);
        assertEquals(7,tilesMap[0].length);
    }

    @Test
    void initMapWithEmptyLines() {
        List<String> lines = new ArrayList<>();
        assertThrows(EmptyLinesInstructionsException.class,
                ()->{
                    tilesMap = TreasureMapService.generateMapTiles(lines);
                });
    }

    @Test
    void initMapWithWrongInstruction() {
        List<String> lines = new ArrayList<>();
        lines.add("E - 4 - 6");
        assertThrows(GenerateMapException.class,
                ()->{
                    tilesMap = TreasureMapService.generateMapTiles(lines);
                });
    }

    @Test
    void initMapWithWrongSizeInstruction() {
        List<String> lines = new ArrayList<>();
        lines.add("C - 4 - 6 - 7");
        assertThrows(GenerateMapException.class,
                ()->{
                    tilesMap = TreasureMapService.generateMapTiles(lines);
                });
    }

}
