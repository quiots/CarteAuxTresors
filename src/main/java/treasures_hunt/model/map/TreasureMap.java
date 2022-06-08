package treasures_hunt.model.map;

import treasures_hunt.exception.OutOfValidTileMapException;
import treasures_hunt.model.Position;

/**
 * It's a class that represents a treasure map
 */
public class TreasureMap {

    private Tile[][] mapTiles;
    private final Position mapLimitCorner;

    public TreasureMap(Tile[][] mapTiles){
        this.mapTiles=mapTiles;
        this.mapLimitCorner=new Position(mapTiles.length-1, mapTiles[0].length-1);
    }


    public Tile[][] getMapTiles() {
        return mapTiles;
    }

    public void setMapTiles(Tile[][] mapTiles) {
        this.mapTiles = mapTiles;
    }

    public Tile getTile(Position pos){
        return mapTiles[pos.getX()][pos.getY()];
    }

    /**
     * If the position is out of bounds, throw an OutOfMapException, otherwise set the tile.
     * @param tile The tile to be set
     */
    public void setTile(Tile tile) throws OutOfValidTileMapException {
        if(positionIsOutOfBounds(tile.getPosition())){
            throw new OutOfValidTileMapException();
        }
        mapTiles[tile.getPosition().getX()][tile.getPosition().getY()]=tile;
    }

    /**
     * If the position is out of bounds, return true, else return false.
     *
     * @param pos The position to be verified
     * @return A boolean value.
     */
    public boolean positionIsOutOfBounds(Position pos){
        return pos.getX() < 0 || pos.getY() < 0
                || pos.getX() > mapLimitCorner.getX()
                || pos.getY() > mapLimitCorner.getY();
    }

    public Position getMapLimitCorner() {
        return mapLimitCorner;
    }

    public String toString(){
        return "C - " + getMapTiles().length + " - " + getMapTiles()[0].length;
    }

    /**
     * This function returns a string containing the coordinates of all the mountain tiles in the map.
     *
     * @return A string of all the mountain tiles.
     */
    public String stateOfMountains() {
        StringBuilder sb = new StringBuilder();
        for (Tile[] tLine : mapTiles) {
            for(Tile t : tLine){
                if(t.isMountain())
                    sb.append(t.toString() + "\n");
            }
        }
        return sb.toString();
    }

    /**
     * For each tile in the map, if it has treasures, add it to the string.
     *
     * @return A string representation of the map.
     */
    public String stateOfTreasures() {
        StringBuilder sb = new StringBuilder();
        for (Tile[] tLine : mapTiles) {
            for(Tile t : tLine){
                if(t.hasTreasures())
                    sb.append(t.toString() + "\n");
            }
        }
        return sb.toString();
    }
}
