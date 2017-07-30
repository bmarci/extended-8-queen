import java.util.ArrayList;

/**
 * Created by Marci Blum on 2017.07.16..
 */
public class Bishop implements PieceType{
    ArrayList<Coords> directions;

    public Bishop(){
        directions = new ArrayList<>();
        directions.add(Directions.UP_LEFT);
        directions.add(Directions.UP_RIGHT);
        directions.add(Directions.DOWN_LEFT);
        directions.add(Directions.DOWN_RIGHT);
    }

    @Override
    public ArrayList<Coords> getMoveDirections() {
        return directions;
    }
}
