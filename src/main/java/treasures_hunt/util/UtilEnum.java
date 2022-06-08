package treasures_hunt.util;

import treasures_hunt.model.treasurehunter.Movement;
import treasures_hunt.model.treasurehunter.Orientation;

import java.util.Stack;

public class UtilEnum {

    // A private constructor, which means that the class cannot be instantiated.
    private UtilEnum(){
        throw new IllegalStateException();
    }

    /**
     * It takes a string of instructions and returns a stack of movements
     *
     * @param instruction The instruction to be parsed.
     * @return A stack of movements.
     */
    public static Stack<Movement> getStackMovement(String instruction){
        Stack<Movement> movStack = new Stack<>();
        StringBuilder strb = new StringBuilder(instruction);
        String revInstruction = strb.reverse().toString();
        for(char c : revInstruction.toCharArray()){
            Movement m = getMovement(c);
            movStack.push(m);
        }
        return movStack;
    }

    /**
     * Given a character, return the corresponding Movement.
     *
     * @param instruction The instruction to be executed.
     * @return A Movement enum.
     */
    public static Movement getMovement(char instruction){
        switch(instruction){
            case 'A':
                return Movement.MOVE_FORWARD;
            case 'D':
                return Movement.RIGHT_ROTATION;
            case 'G':
                return Movement.LEFT_ROTATION;
            default:
                return null;
        }
    }

    /**
     * It takes a string and returns an Orientation enum
     *
     * @param instruction The instruction to be parsed.
     * @return The orientation of the element.
     */
    public static Orientation getOrientation(String instruction){
        switch(instruction){
            case "N":
                return Orientation.N;
            case "E":
                return Orientation.E;
            case "S":
                return Orientation.S;
            case "W":
                return Orientation.W;
            default:
                return null;
        }
    }
}
