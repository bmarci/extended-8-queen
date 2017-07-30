import java.util.ArrayList;

/**
 * Created by Marci Blum on 2017.07.16..
 */
public class Logic {
    private static int PENALTY = -1000;
    private static int REWARD = 1;

    private ChessTableState state;
    private int goal;

    /**
     *
     * @param goal How many piece to put on the table.
     */
    public Logic(int goal){
        this.goal = goal;
    }

    public void init(){
        state = new ChessTableState();
        state.init();
    }

    /**
     * Decide whether the current table is solved. If not it offers possible next moves.
     * @param chessTable The current chess table we analyse.
     * @return The state of the table. It can be solved or it can contains the possible next move.
     */
    public ChessTableState evaluate(ChessTable chessTable){
        state.init();
        boolean solved = isSolved(chessTable);
        state.setSolved(solved);

        if(!solved){
            ArrayList<Coords> possibleGoodMoves;
            possibleGoodMoves = findPossibleGoodMoves(chessTable);
            state.setPossibleGoodMoves(possibleGoodMoves);
        }
        return state;
    }

    private boolean isSolved(ChessTable chessTable){
        return chessTable.getPieceNr() == goal;
    }

    /**
     * Fill a list that contains the fields which can be chosen to take.
     * @param chessTable The chess table we use.
     * @return The list of fields you can take as coords.
     */
    private ArrayList<Coords> findPossibleGoodMoves(ChessTable chessTable){
        ArrayList<Coords> possibleGoodMoves = new ArrayList<>();
        int rows = chessTable.getRows();
        int cols = chessTable.getCols();
        int bestValue = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                ChessTableField fieldToCalculate = chessTable.getField(i, j);
                if(fieldToCalculate.isFree()){
                    int currentFieldValue = calculateFieldValue(chessTable, i, j);
                    if(currentFieldValue > bestValue){
                        possibleGoodMoves.clear();
                        possibleGoodMoves.add(new Coords(i, j));
                        bestValue = currentFieldValue;
                    }
                    else if(currentFieldValue == bestValue){
                        possibleGoodMoves.add(new Coords(i, j));
                    }
                }
            }
        }
        return possibleGoodMoves;
    }

    /**
     * A helper function to calculate the proper fields value at the current state of the chess table.
     * The greater value is the better.
     * @param chessTable The current chess table we use.
     * @param selectedRow The row number of the field we calculate value for.
     * @param selectedCol The column number of the field we calculate value for.
     * @return The value of the field.
     */
    private int calculateFieldValue(ChessTable chessTable, int selectedRow, int selectedCol){
        int calculatedValue = 0;
        ArrayList<ChessTableField> neighbours;
        neighbours = chessTable.getNeighbours(selectedRow, selectedCol);
        for (ChessTableField field : neighbours) {
            if(field.isFree()){
                calculatedValue += PENALTY;
            }
            else if (field.isCrossed()){
                int crossedValue = chessTable.getTimesCrossed(field.row, field.col);
                calculatedValue += (REWARD + crossedValue);
            }
            else{
                return Integer.MIN_VALUE;
            }
        }
        return calculatedValue;
    }
}
