import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by Marci Blum on 2017.07.16..
 */
public class Main {

    // The dimensions of the chess table
    private static final int COLS = 8;
    private static final int ROWS = 8;

    // How many pieces we want to put on the chess table.
    private static final int GOAL = 8;

    // To avoid infinite loop
    private static final int MAX_TAKES = 5000;

    public static void main(String[] args) {
        Date startDate = new Date();
        PieceType pieceType = new Queen();
        ChessTable chessTable = new ChessTable(ROWS, COLS, pieceType);
        Logic logic = new Logic(GOAL);
        ChessTableState chessTableState;

        chessTable.init();
        logic.init();
        chessTableState = new ChessTableState();
        int take = 0;
        int n;
        Coords possibleGoodMove;
        Coords lastChosenMove;
        while (!chessTableState.isSolved() && take < MAX_TAKES){
            chessTable.init();
            logic.init();
            lastChosenMove = null;
            for (int i = 0; i <= GOAL; i++) {
                chessTableState = logic.evaluate(chessTable);
                ArrayList<Coords> possibleGoodMoves = chessTableState.getPossibleGoodMoves();
                if (chessTableState.isSolved() || possibleGoodMoves.isEmpty()) {
                    break;
                }
                if(lastChosenMove == null) {
                    Random rand = new Random();
                    n = rand.nextInt(possibleGoodMoves.size());
                    possibleGoodMove = possibleGoodMoves.get(n);
                }
                else{
                    possibleGoodMove = Coords.getMinDistance(lastChosenMove, possibleGoodMoves);
                }
                chessTable.takeField(possibleGoodMove.getRow(), possibleGoodMove.getCol());
                lastChosenMove = possibleGoodMove;
            }
            take++;
        }
        Date endDate = new Date();
        long runtime = endDate.getTime() - startDate.getTime();
        if(take < MAX_TAKES){
            System.out.println(chessTable.toString());
            System.out.println("Solved by " + take + " take.");
        }
        else {
            System.out.println("Failed to solve");
        }
        System.out.println("Run time: " + runtime + "ms");
    }
}
