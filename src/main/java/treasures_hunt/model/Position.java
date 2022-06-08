package treasures_hunt.model;

/**
 * It's a class that represents a position in a 2D space
 */
public class Position {

    private int x;
    private int y;

    public Position(){
    }
    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void translate(int x, int y){
        setX(getX()+x);
        setY(getY()+y);
    }

    public String toString(){
        return "Position : (" + getX() + ";" + getY() + ")";
    }
}
