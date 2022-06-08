package treasures_hunt.service;

import treasures_hunt.exception.GenerateMapException;
import treasures_hunt.exception.GenerateTreasureHunterException;
import treasures_hunt.model.Position;
import treasures_hunt.model.treasurehunter.Movement;
import treasures_hunt.model.treasurehunter.Orientation;
import treasures_hunt.model.treasurehunter.TreasureHunter;
import treasures_hunt.util.UtilEnum;

import java.util.Stack;

public abstract class TreasureHunterService {

    private static final String WRONG_SIZE_INSTRUCTION = "Size of instruction is not valid.";

    // A private constructor, which means that the class cannot be instantiated.
    private TreasureHunterService(){
        throw new IllegalStateException();
    }

    /**
     * This function is used to create a treasure hunter object
     *
     * @param instructionLine The line of the file that contains the instructions for the creation of the treasure hunter.
     * @return A TreasureHunter object
     */
    public static TreasureHunter createTreasureHunter(String[] instructionLine) throws GenerateTreasureHunterException {
        if(instructionLine.length == 6){
            String name = instructionLine[1];
            Position posA = new Position(Integer.parseInt(instructionLine[2]),Integer.parseInt(instructionLine[3]));
            Orientation orientation = UtilEnum.getOrientation(instructionLine[4]);
            Stack<Movement> movements = UtilEnum.getStackMovement(instructionLine[5]);
            return new TreasureHunter(name,posA,orientation, movements);
        }else{
            throw new GenerateTreasureHunterException(WRONG_SIZE_INSTRUCTION);
        }
    }
}
