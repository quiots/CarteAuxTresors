package treasures_hunt.exception;

public class EmptyLinesInstructionsException extends Exception {
    public EmptyLinesInstructionsException(){
        super();
    }

    public EmptyLinesInstructionsException(String message){
        super(message);
    }
}
