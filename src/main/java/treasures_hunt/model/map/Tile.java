package treasures_hunt.model.map;


import treasures_hunt.model.Position;
import treasures_hunt.model.treasurehunter.TreasureHunter;

/**
 * A Tile is a class that represents a tile on the map
 */
public abstract class Tile {

    private Position pos;
    private TreasureHunter hunterPresent;
    private int treasures;

    protected Tile(){
    }

    protected Tile(Position pos){
        this.pos=pos;
        this.treasures=0;
        this.hunterPresent=null;
    }

    public Position getPosition() {
        return pos;
    }

    public void setPosition(Position pos) {
        this.pos = pos;
    }

    public abstract String getType();

    public TreasureHunter getHunterPresent() {
        return hunterPresent;
    }

    /**
     * If a treasure hunter is present in a tile, and there are treasures in the tile, the treasure hunter will pick up the
     * treasures
     * @param hunterPresent The TreasureHunter that is currently in the tile.
     */
    public void setHunterPresent(TreasureHunter hunterPresent) {
        this.hunterPresent = hunterPresent;
        if(hasTreasures()){
            hunterPresent.incrementTreasures();
            this.decrementTreasures();
        }
    }

    public void setHunterNull(){
        hunterPresent=null;
    }

    public boolean hunterIsPresent(){
        return hunterPresent!=null;
    }

    public boolean isMountain(){
        return getType().equals("M");
    }

    public abstract String toString();

    public int getTreasures() {
        return treasures;
    }

    public boolean hasTreasures() { return treasures>0; }

    public boolean isUnreachable() { return hunterIsPresent() || isMountain();}

    /**
     * If the number of treasures is negative, throw an exception.
     *
     * @param treasures The number of treasures in the room.
     */
    public void setTreasures(int treasures) {
        if (treasures < 0) {
            throw new IllegalArgumentException("Treasures quantity is negative : " + treasures);
        }
        this.treasures = treasures;
    }

    public void decrementTreasures(){
        if(treasures>0) treasures--;
    }
}
