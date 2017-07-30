import java.util.ArrayList;

/**
 * Created by Marci Blum on 2017.07.16..
 */
public class ChessTable {
    private ArrayList<ArrayList<ChessTableField>> fields;
    private PieceType piece;
    private int rows;
    private int cols;
    private int pieceNr;

    public ChessTable(int rows, int cols, PieceType piece){
        fields = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            ArrayList<ChessTableField> row = new ArrayList<>();
            for(int j = 0; j < cols; j++){
                ChessTableField field = new ChessTableField(i, j);
                row.add(field);
            }
            fields.add(row);
        }
        this.rows = rows;
        this.cols = cols;
        this.piece = piece;
    }

    public void init(){
        pieceNr = 0;
        for (ArrayList<ChessTableField> row: fields) {
            for (ChessTableField field: row) {
                field.init();
            }
        }
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public ChessTableField getField(int row, int col){
        return fields.get(row).get(col);
    }

    public int getPieceNr() {
        return pieceNr;
    }

    public ArrayList<ChessTableField> getNeighbours(int takenRow, int takenCol){
        ArrayList<Coords> directions = piece.getMoveDirections();
        ArrayList<ChessTableField> neighbours = new ArrayList<>();
        int i;
        int j;
        for (Coords direction : directions) {
            i = takenRow + direction.getRow();
            j = takenCol + direction.getCol();
            while(!isEndOfTable(i, j)) {
                ChessTableField neighbour = getField(i, j);
                neighbours.add(neighbour);
                i += direction.getRow();
                j += direction.getCol();
            }
        }
        return neighbours;
    }

    public boolean takeField(int row, int col){
        ChessTableField field = fields.get(row).get(col);
        //Can not take the field
        if(!field.isFree()) {
            return false;
        }
        pieceNr++;
        fields.get(row).get(col).takeField();
        refreshTable(row, col);
        return true;
    }

    public int getTimesCrossed(int row, int col){
        int timesCrossed = 0;
        ArrayList<ChessTableField> neighbours = getNeighbours(row, col);
        for (ChessTableField field : neighbours) {
            if(!field.isFree()){
                timesCrossed++;
            }
        }
        return timesCrossed;
    }

    @Override
    public String toString() {
        String board = "";
        for (ArrayList<ChessTableField> row : fields) {
            board += "|";
            for (ChessTableField field : row) {
                board += field.toString();
            }
            board += "\n";
        }
        return board;
    }

    private void refreshTable(int takenRow, int takenCol){
        ArrayList<ChessTableField> neighbours = getNeighbours(takenRow, takenCol);
        for (ChessTableField neighbour : neighbours) {
            neighbour.crossField();
        }
    }

    private boolean isEndOfTable(int row, int col){
        return (row < 0 || row >= this.rows) || (col < 0 || col >= this.cols);
    }

}
