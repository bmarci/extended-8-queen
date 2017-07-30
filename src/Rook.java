import java.util.ArrayList;

/**
 * Created by Marci Blum on 2017.07.16..
 */
public class Rook implements PieceType{
    ArrayList<Coords> directions;

    public Rook(){
        directions = new ArrayList<>();
        directions.add(Directions.UP);
        directions.add(Directions.DOWN);
        directions.add(Directions.LEFT);
        directions.add(Directions.RIGHT);
    }

    @Override
    public ArrayList<Coords> getMoveDirections() {
        return directions;
    }
}