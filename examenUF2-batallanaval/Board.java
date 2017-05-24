import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

/**
 * Created by the Focking Jendoliver on 22/05/2017.
 *  GitHub: github.com/Jendoliver
 */
public class Board 
{
    // Attributes
    private static final int width = 10;
    private static final int height = 10;
    private static Cell[][] board;
    private ArrayList<Boat> boats = new ArrayList();

    // Constructors
    public Board() {
        initializeBoard();
        placeBoats();
    }

    // Getters
    @Contract(pure = true)
    public static int getWidth() { return width; }
    @Contract(pure = true)
    public static int getHeight() { return height; }
    public Cell[][] getBoard() { return board; }

    // Methods
    private void initializeBoard()
    {
        board = new Cell[width][height];
        for(int i=0; i<width; i++)
        {
            for(int j=0; j<height; j++)
                board[i][j] = new Cell();
        }
    }

    private void placeBoats()
    {
        int boatsplaced = 0;
        int numboats = 4;
        while (boatsplaced < numboats)
        {
            Boat boat = new Boat();
            if(checkBoatPosition(boat)) {
                boatsplaced++;
                addBoat(boat);
            }
        }
    }

    /**
     * @param boat = boat to check
     * @return true if boat can be positioned
     */
    private boolean checkBoatPosition(Boat boat)
    {
        int row = boat.getRow(), col = boat.getCol(), boatsize = boat.getBoatsize();
        if(boat.getOrientation() == Orientations.H)
        {
            for(int i = (row == 0) ? row : row-1; i < (row == height ? row : row+1); i++)
            {
                for (int j = (col == 0) ? col : col-1; j < ((col+boatsize <= width) ? col+boatsize : col+boatsize-1); j++) {
                    if (board[i][j].getContent() == BoardCells.BOAT)
                        return false;
                }
            }
        }
        else
        {
            for(int i = (row == 0) ? row : row-1; i < ((row+boatsize <= height) ? row+boatsize : row+boatsize-1); i++)
            {
                for (int j = (col == 0) ? col : col-1; j < (col+1 > width ? col : col+1); j++) {
                    if (board[i][j].getContent() == BoardCells.BOAT)
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * @param boat = boat to add
     *          Adds a boat to the board
     *             and the cells corresponding to the boat to its instance
     */
    private void addBoat(Boat boat)
    {
        boats.add(boat);
        int row = boat.getRow(), col = boat.getCol(), boatsize = boat.getBoatsize();
        if(boat.getOrientation() == Orientations.H)
        {
            for(int j = col; j < col+boatsize; j++) {
                board[row][j].setContent(BoardCells.BOAT);
            }
        }
        else
        {
            for(int i = row; i < row+boatsize; i++) {
                board[i][col].setContent(BoardCells.BOAT);
            }
        }
    }

    public int getEmptyCells()
    {
        return (Board.height * Board.width) - getOccupiedCells();
    }

    public int getOccupiedCells()
    {
        int cont = 0;
        for(Boat boat : boats)
        {
            cont += boat.getBoatsize();
        }
        return cont;
    }
}
