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
    private static BoardCells[][] board = new BoardCells[width][height];
    private ArrayList boats = new ArrayList();

    // Constructors
    public Board() {
        initializeBoard();
        placeBoats();
    }

    // Getters
    public static int getWidth() { return width; }
    public static int getHeight() { return height; }
    public ArrayList<Boat> getBoats() { return boats; }

    // Methods
    private void initializeBoard()
    {
        for(int i=0; i<width; i++)
        {
            for(int j=0; j<height; j++)
                board[i][j] = BoardCells.WATER;
        }
    }

    public void addBoat(Boat b)
    {
        boats.add(b);
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

    private boolean checkBoatPosition(Boat boat)
    {
        return true;
    }
}
