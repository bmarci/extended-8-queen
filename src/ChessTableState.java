import java.util.ArrayList;

/**
 * Created by Marci Blum on 2017.07.16..
 */
public class ChessTableState {
    private boolean solved;
    private ArrayList<Coords> possibleGoodMoves;

    public void init(){
        solved = false;
        possibleGoodMoves = new ArrayList<>();
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public void setPossibleGoodMoves(ArrayList<Coords> possibleGoodMoves){
       this.possibleGoodMoves = possibleGoodMoves;
    }

    public ArrayList<Coords> getPossibleGoodMoves(){
        return possibleGoodMoves;
    }
}
