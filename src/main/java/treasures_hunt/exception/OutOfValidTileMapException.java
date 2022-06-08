package treasures_hunt.exception;

public class OutOfValidTileMapException extends Exception {
    public OutOfValidTileMapException(){
        super();
    }

    public OutOfValidTileMapException(String message){
        super(message);
    }
}
