/**
 * Created by Marci Blum on 2017.07.16..
 */
public class ChessTableField {
    FieldStatus status;
    int row;
    int col;

    public ChessTableField(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void init(){
        status = FieldStatus.FREE;
    }

    public boolean isFree(){
        return status == FieldStatus.FREE;
    }

    public boolean isCrossed(){
        return status == FieldStatus.CROSSED;
    }

    public boolean isTaken(){
        return status == FieldStatus.TAKEN;
    }

    public void takeField(){
        status = FieldStatus.TAKEN;
    }

    public void crossField(){
        if(status != FieldStatus.TAKEN) {
            status = FieldStatus.CROSSED;
        }
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    @Override
    public String toString() {
        return " " + (isTaken() ? "1" : (isCrossed() ? "-" :"0")) + " |";
    }
}
