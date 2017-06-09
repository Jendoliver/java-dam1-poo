import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

/**
 * Created by the Focking Jendoliver on 22/05/2017.
 *  GitHub: github.com/Jendoliver
 */
public class Board 
{
    // Attributes
    private static int width;
    private static int height;
    private static Cell[][] board;
    private static ArrayList<Boat> boats = new ArrayList();

    // Constructors
    public Board(GameProperties gp) {
        this.width = gp.width;
        this.height = gp.height;
        initializeBoard();
        placeBoats(gp.boats);
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        initializeBoard();
    }

    // Getters
    public static int getWidth() { return width; }
    public static int getHeight() { return height; }
    public static Cell[][] getBoard() { return board; }
    public static ArrayList<Boat> getBoats() { return boats; }

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

    /**
     * Loop that calls checkBoatPosition and addBoat if the first returns true
     * for the number of boats to be positioned.
     */
    private void placeBoats(int[] boats)
    {
        int boatsplaced = 0;
        while (boatsplaced < boats.length)
        {
            Boat boat = new Boat(boats[boatsplaced]);
            if(checkBoatPosition(boat)) {
                boatsplaced++;
                addBoat(boat);
            }
        }
    }

    /**
     * @param boat = boat to check, given that it always fits in the board
     *             (row+boatsize or col+boatsize can never be > width / row respectively)
     * @return true if boat can be positioned
     *          Checks the position of the boat and its neighbours to make sure they aren't
     *          occupied, thus if they are it can't be positioned
     */
    private boolean checkBoatPosition(Boat boat)
    {
        int row = boat.getRow(), col = boat.getCol(), boatsize = boat.getBoatsize();
        if(boat.getOrientation() == Orientations.H)
        {
            for(int i = (row == 0) ? row : row-1; i <= (row+1 == height ? row : row+1); i++)
            {
                for (int j = (col == 0) ? col : col-1; j <= col+boatsize; j++) {
                    if (board[i][j].getContent() == BoardCells.BOAT)
                        return false;
                }
            }
        }
        else
        {
            for(int i = (row == 0) ? row : row-1; i <= row+boatsize; i++)
            {
                for (int j = (col == 0) ? col : col-1; j <= (col+1 == width ? col : col+1); j++) {
                    if (board[i][j].getContent() == BoardCells.BOAT)
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * @param boat = boat to add, which has a correct origin position
     *          Adds a boat to the board
     *             and saves the instance of the boad added on each cell it occupies,
     *             so it can be accessed when a shot is made to process if the boat has been destroyed
     */
    public static void addBoat(Boat boat)
    {
        boats.add(boat);
        int row = boat.getRow(), col = boat.getCol(), boatsize = boat.getBoatsize();
        if(boat.getOrientation() == Orientations.H)
        {
            for(int j = col; j < col+boatsize; j++) {
                board[row][j].setContent(BoardCells.BOAT);
                board[row][j].setBoat(boat);
            }
        }
        else
        {
            for(int i = row; i < row+boatsize; i++) {
                board[i][col].setContent(BoardCells.BOAT);
                board[i][col].setBoat(boat);
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
