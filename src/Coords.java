import java.util.ArrayList;

/**
 * Created by Marci Blum on 2017.07.16..
 */
public class Coords {
    private int row;
    private int col;

    public Coords(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public static Coords getMinDistance(Coords lastChosen, ArrayList<Coords> possibleBestMoves){
        int minDistance = Integer.MAX_VALUE;
        Coords optimal = null;
        for (Coords coord: possibleBestMoves) {
            int sum = Math.abs(lastChosen.getRow() - coord.getRow() + lastChosen.getCol() - coord.getCol());
            if( sum < minDistance){
                minDistance = sum;
                optimal = coord;
            }
        }
        return optimal;
    }

    @Override
    public String toString() {
        return "( " + getRow() + ", " + getCol() + " )";
    }
}
