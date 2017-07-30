import java.util.ArrayList;

/**
 * Created by Marci Blum on 2017.07.16..
 */
public class Queen implements PieceType{
    ArrayList<Coords> directions;

    public Queen(){
        directions = new ArrayList<>();
        directions.add(Directions.UP);
        directions.add(Directions.UP_LEFT);
        directions.add(Directions.UP_RIGHT);
        directions.add(Directions.DOWN);
        directions.add(Directions.DOWN_LEFT);
        directions.add(Directions.DOWN_RIGHT);
        directions.add(Directions.LEFT);
        directions.add(Directions.RIGHT);
    }

    @Override
    public ArrayList<Coords> getMoveDirections() {
        return directions;
    }
}
