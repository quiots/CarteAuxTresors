package treasures_hunt.service;

import treasures_hunt.exception.EmptyLinesInstructionsException;
import treasures_hunt.exception.GenerateMapException;
import treasures_hunt.model.Position;
import treasures_hunt.model.map.*;

import java.util.List;

public abstract class TreasureMapService {

    // A private constructor, which means that the class cannot be instantiated.
    private TreasureMapService(){
        throw new IllegalStateException();
    }


    /**
     * It takes a list of strings, each string representing a line of instructions, and returns a 2D array of tiles
     *
     * @param lines The list of lines from the file.
     * @return A 2D array of tiles which corresponds to the map.
     */
    public static Tile[][] generateMapTiles(List<String> lines) throws EmptyLinesInstructionsException,GenerateMapException {
        Tile[][] mapTiles;
        if(lines.isEmpty()){
            throw new EmptyLinesInstructionsException("Fichier d'instructions vide ou non trouvé.");
        }
        String[] mapInfoLine = lines.get(0).split(" - ");
        if(mapInfoLine.length == 3 && mapInfoLine[0].equals("C")){
            mapTiles = new Tile[Integer.parseInt(mapInfoLine[1])][Integer.parseInt(mapInfoLine[2])];
            for(int i=0;i<mapTiles.length;i++){
                for(int j=0;j<mapTiles[i].length;j++){
                    mapTiles[i][j]= new TilePlain(new Position(i,j));
                }
            }
        }else{
            throw new GenerateMapException("Size or type of instructions for map is not valid.");
        }
        return mapTiles;
    }
}
