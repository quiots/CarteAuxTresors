package treasures_hunt.model.map;

import treasures_hunt.model.Position;

public class TilePlain extends Tile{

    public TilePlain(Position pos){
        super(pos);
    }

    @Override
    public String getType() {
        return "P";
    }

    @Override
    public String toString() {
        return (hasTreasures()) ? "T - " + getPosition().getX() + " - " + getPosition().getY()
                + " - " + getTreasures() : "";
    }
}
