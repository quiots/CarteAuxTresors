package treasures_hunt.model.treasurehunter;

import treasures_hunt.model.Position;

import java.util.Stack;

public class TreasureHunter {

    private final String name;
    private int treasures;
    private Position pos;
    private Orientation orientation;
    private Stack<Movement> movements;

    public TreasureHunter(String name,Position pos,Orientation orientation,Stack<Movement> movements){
        this.name = name;
        this.treasures=0;
        this.pos = pos;
        this.orientation = orientation;
        this.movements = movements;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return pos;
    }

    public void setPosition(Position pos) {
        this.pos = pos;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getTreasures() {
        return treasures;
    }

    public void setTreasures(int treasures) {
        if (treasures < 0) {
            throw new IllegalArgumentException("Treasures quantity is negative : " + treasures);
        }
        this.treasures = treasures;    }

    public void incrementTreasures(){
        this.treasures++;
    }

    public Stack<Movement> getMovements() {
        return movements;
    }

    public void setMovements(Stack<Movement> movements) {
        this.movements = movements;
    }

    public boolean isMovementsEmpty(){
        return movements.empty();
    }

    public String toString(){
        return "A - " + getName() + " - " + pos.getX() + " - "
                + pos.getY() + " - " + getOrientation().toString()
                + " - " + getTreasures();
    }

    /**
     * Given the current position and orientation, return the position of the next tile
     * in the direction the hunter is facing.
     * @return The potential next position of the hunter.
     */
    public Position nextForwardPosition(){
        Position nextPos = new Position(getPosition().getX(),getPosition().getY());
        switch (orientation){
            case N:
                nextPos.translate(0,-1);
                break;
            case E:
                nextPos.translate(1,0);
                break;
            case S:
                nextPos.translate(0,1);
                break;
            case W:
                nextPos.translate(-1,0);
                break;
            default:
                break;
        }
        return nextPos;
    }

    /**
     * It rotates the treasure hunter 90 degrees clockwise.
     */
    public void right() {
        setOrientation(Orientation.values()[(orientation.ordinal() + 1) % 4]);
    }

    /**
     * It rotates the treasure hunter 90 degrees counterclockwise.
     */
    public void left() {
         setOrientation(Orientation.values()[(orientation.ordinal() - 1 + 4) % 4]);
    }


    /**
     * Move the hunter forward one space.
     */
    public void moveForward(){
        setPosition(nextForwardPosition());
    }

    /**
     * If there are movements in the stack, pop the top movement and execute it
     */
    public void move(){
        if(!movements.empty()){
            Movement m = movements.pop();
            switch (m){
                case RIGHT_ROTATION:
                    this.right();
                    break;
                case LEFT_ROTATION:
                    this.left();
                    break;
                case MOVE_FORWARD:
                    this.moveForward();
                    break;
                default: // If not recognized, we ignore it.
                    break;
            }
        }
    }
}
