package treasures_hunt.model.map;

import treasures_hunt.model.Position;

public class TileMountain extends Tile{

    public TileMountain(Position pos){
        super(pos);
    }

    @Override
    public String getType() {
        return "M";
    }

    @Override
    public String toString() {
        return getType() + " - " + getPosition().getX()
                + " - " + getPosition().getY();
    }


}
