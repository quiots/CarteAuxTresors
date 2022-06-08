package treasures_hunt.model;

import treasures_hunt.model.map.TreasureMap;
import treasures_hunt.model.treasurehunter.Movement;
import treasures_hunt.model.treasurehunter.TreasureHunter;

import java.util.List;

/**
 * It's a class that represents a game of treasure hunt
 */
public class GameTreasureHunt {

    private TreasureMap tMap;
    private List<TreasureHunter> hunters;
    private boolean gameIsFinished;

    public GameTreasureHunt(TreasureMap tMap,List<TreasureHunter> hunters){
        this.tMap = tMap;
        this.hunters = hunters;
        this.gameIsFinished=false;
    }

    public List<TreasureHunter> getHunters() {
        return hunters;
    }

    public void setHunters(List<TreasureHunter> hunters) {
        this.hunters = hunters;
    }

    public TreasureMap getMap() {
        return tMap;
    }

    public void setMap(TreasureMap tMap) {
        this.tMap = tMap;
    }

    /**
     * > This function returns true if any of the hunters has movements left
     *
     * @return A boolean value.
     */
    public boolean huntersHasMovements(){
        for (TreasureHunter hunter : hunters){
            if(!hunter.isMovementsEmpty()){
                return true;
            }
        }
        return false;
    }

    /**
     * The function runs the instructions of the hunters, until they have no more movements to do
     */
    public void huntersRunInstructions(){
        while (huntersHasMovements()) {
            for (TreasureHunter hunter : hunters) {
                if (!hunter.isMovementsEmpty()) {
                    if (hunter.getMovements().peek() == Movement.MOVE_FORWARD) {
                        if (tMap.positionIsOutOfBounds(hunter.nextForwardPosition())
                                || tMap.getTile(hunter.nextForwardPosition()).isUnreachable()) {
                            hunter.getMovements().pop(); // Impossible movement, so ignored.
                        } else { // Possible movement
                            getMap().getTile(hunter.getPosition()).setHunterNull();
                            hunter.move();
                            getMap().getTile(hunter.getPosition()).setHunterPresent(hunter);
                        }
                    } else { // Rotations
                        hunter.move();
                    }
                }
            }
        }
        gameIsFinished=true;
    }

    /**
     * This function returns a string that contains the state of all the treasure hunters
     *
     * @return The state of the hunters.
     */
    public String stateOfHunters() {
        StringBuilder sb = new StringBuilder();
        for (TreasureHunter h : hunters) {
            sb.append(h.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * Final results of the game
     * @return A string containing the state of the map, the state of the mountains,
     * the state of the treasures,
     * and the state of the hunters.
     */
    public String results(){
        StringBuilder sb = new StringBuilder();
        sb.append(tMap.toString() + "\n");
        sb.append(tMap.stateOfMountains());
        sb.append(tMap.stateOfTreasures());
        sb.append(stateOfHunters());
        return sb.toString();
    }

    public boolean isGameIsFinished() {
        return gameIsFinished;
    }

    public void setGameIsFinished(boolean gameIsFinished) {
        this.gameIsFinished = gameIsFinished;
    }
}
