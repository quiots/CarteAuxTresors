package treasures_hunt.model.treasurehunter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import treasures_hunt.model.Position;
import treasures_hunt.util.UtilEnum;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class TreasureHunterTest {

    private TreasureHunter hunter;

    @BeforeEach
    void setUp() {
        Stack<Movement> mov = UtilEnum.getStackMovement("DAGA");
        hunter = new TreasureHunter("Indiana",new Position(1,3),Orientation.S,mov);
    }

    @AfterEach
    void tearDown() {
        hunter=null;
    }

    @Test
    void getName() {
        assertEquals("Indiana",hunter.getName());
    }

    @Test
    void getPosition() {
        assertEquals(1,hunter.getPosition().getX());
        assertEquals(3,hunter.getPosition().getY());
    }

    @Test
    void setPosition() {
        hunter.setPosition(new Position(3,1));
        assertEquals(3,hunter.getPosition().getX());
        assertEquals(1,hunter.getPosition().getY());
    }

    @Test
    void getOrientation() {
        assertEquals(Orientation.S,hunter.getOrientation());
    }

    @Test
    void setOrientation() {
        hunter.setOrientation(Orientation.E);
        assertEquals(Orientation.E,hunter.getOrientation());
    }

    @Test
    void getTreasures() {
        assertEquals(0,hunter.getTreasures());
    }

    @Test
    void setNegativeQuantityTreasures() {
        assertThrows(IllegalArgumentException.class,
                ()->{
                    hunter.setTreasures(-6);
                });
    }

    @Test
    void isMovementsEmpty() {
        assertFalse(hunter.isMovementsEmpty());
    }

    @Test
    void right() {
        hunter.right();
        assertEquals(Orientation.W,hunter.getOrientation());
    }

    @Test
    void left() {
        hunter.left();
        assertEquals(Orientation.E,hunter.getOrientation());
    }

    @Test
    void moveForward() {
        hunter.moveForward();
        assertEquals(1,hunter.getPosition().getX());
        assertEquals(4,hunter.getPosition().getY());
    }

    @Test
    void move() {
        hunter.move();
        assertEquals(Orientation.W,hunter.getOrientation());
        hunter.move();
        assertEquals(0,hunter.getPosition().getX());
        assertEquals(3,hunter.getPosition().getY());
        hunter.move();
        assertEquals(Orientation.S,hunter.getOrientation());
        hunter.move();
        assertEquals(0,hunter.getPosition().getX());
        assertEquals(4,hunter.getPosition().getY());

    }
}
