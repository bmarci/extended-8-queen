/**
 * Created by Marci Blum on 2017.07.16..
 */
public class Directions {
    /**
     * The representation of the possible moves.
     */
    public static final Coords UP = new Coords(1,0);
    public static final Coords UP_LEFT = new Coords(1,-1);
    public static final Coords UP_RIGHT = new Coords(1,1);
    public static final Coords DOWN = new Coords(-1,0);
    public static final Coords DOWN_LEFT = new Coords(-1,-1);
    public static final Coords DOWN_RIGHT = new Coords(-1,1);
    public static final Coords LEFT = new Coords(0,-1);
    public static final Coords RIGHT = new Coords(0,1);
}
