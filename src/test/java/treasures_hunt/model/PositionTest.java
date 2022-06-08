package treasures_hunt.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    private Position pos;

    @BeforeEach
    void setUp() {
        pos = new Position(1,5);
    }

    @AfterEach
    void tearDown() {
        pos = null;
    }

    @Test
    void getX() {
        assertEquals(1,pos.getX());
    }

    @Test
    void getY() {
        assertEquals(5,pos.getY());
    }

    @Test
    void setX() {
        pos.setX(8);
        assertEquals(8,pos.getX());
    }

    @Test
    void setY() {
        pos.setY(4);
        assertEquals(4,pos.getY());
    }

    @Test
    void translate() {
        pos.translate(12,-3);
        assertEquals(13,pos.getX());
        assertEquals(2,pos.getY());
    }
}
