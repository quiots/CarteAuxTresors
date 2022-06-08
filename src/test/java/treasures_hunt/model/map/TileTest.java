package treasures_hunt.model.map;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import treasures_hunt.model.Position;
import treasures_hunt.model.treasurehunter.Orientation;
import treasures_hunt.model.treasurehunter.TreasureHunter;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    private Tile tile;

    /**
     * > This function sets up the test environment for the test cases
     */
    @BeforeEach
    protected void setUp() throws Exception{
        tile = new TilePlain(new Position(1,2));
        tile.setTreasures(3);
    }

    /**
     * > This function is called after each test case
     */
    @AfterEach
    protected void tearDown() throws Exception {
        tile = null;
    }

    @Test
    void correctPosition() {
        assertEquals(new Position(1,2).toString(),tile.getPosition().toString());
    }

    @Test
    void wrongPosition() {
        assertNotEquals(new Position(1,3).toString(),tile.getPosition().toString());
    }

    @Test
    void setPosition() {
        tile.setPosition(new Position(4,2));
        assertEquals(4,tile.getPosition().getX());
        assertEquals(2,tile.getPosition().getY());
    }

    @Test
    void correctType() {
        assertEquals("P",tile.getType());
    }

    @Test
    void getHunterPresent() {
        assertEquals(null,tile.getHunterPresent());
    }

    @Test
    void setHunterPresent() {
        TreasureHunter hunter = new TreasureHunter("Indiana",tile.getPosition(), Orientation.N,null);
        tile.setHunterPresent(hunter);
        assertEquals("Indiana",tile.getHunterPresent().getName());
    }

    @Test
    @DisplayName("3 trésors attendus.")
    void getTreasures() {
        assertEquals(3,tile.getTreasures());
    }

    @Test
    @DisplayName("5 trésors attribués.")
    void setTreasures() {
        tile.setTreasures(5);
        assertEquals(5,tile.getTreasures());
    }

    /**
     * If the value is negative, an exception is thrown.
     */
    @Test
    @DisplayName("Value not possible.")
    void setNegativeQuantityTreasures() {
        assertThrows(IllegalArgumentException.class,
                ()->{
                    tile.setTreasures(-3);
                });
    }

    @Test
    void decrementQuantityTreasures() {
        tile.decrementTreasures();
        assertEquals(2,tile.getTreasures());
    }

    @Test
    void decrementWhenQuantityTreasuresIsZero() {
        tile.setTreasures(0);
        tile.decrementTreasures();
        assertEquals(0,tile.getTreasures());
    }
}
