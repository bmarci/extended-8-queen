import java.util.ArrayList;

/**
 * Created by Marci Blum on 2017.07.16..
 */
public interface PieceType {
    /** It provides the possible directions a piece can move.
     * @return An ArrayList of directions.
     */
    ArrayList<Coords> getMoveDirections();
}
