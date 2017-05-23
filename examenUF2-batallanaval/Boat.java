/**
 * Created by the Focking Jendoliver on 22/05/2017.
 *  GitHub: github.com/Jendoliver
 */
public class Boat 
{
    // Attributes
    private int boatsize;
    private Orientations orientation;
    private int hits;
    int row;
    int col;

    // Constructors
    public Boat()
    {
        // Generate a random size
        int MAXSIZE = 3;
        boatsize = (int) ((Math.random() * (MAXSIZE - 1)) + 1);

        // Generate a random orientation
        if ((int) (Math.random() * Orientations.getSize()) == 1) {
            orientation = Orientations.H;
        } else { orientation = Orientations.V; }

        // Generate a random position avoiding stack overflow
        if (orientation == Orientations.H)
        {
            // row = [0, BoardHeight]
            row = (int) Math.random() * Board.getHeight();
            // col = [0, (BoardWidth - boatsize)]
            col = (int) Math.random() * (Board.getWidth() - boatsize);
        }
        else
        {
            // row = [0, (BoardHeight - boatsize)]
            row = (int) Math.random() * (Board.getHeight() - boatsize);
            // col = [0, BoardWidth]
            col = (int) (Math.random() * Board.getWidth());
        }
    }

    // Getters
    public int getBoatsize() { return boatsize; }
    public Orientations getOrientation() { return orientation; }
    public int getRow() { return row; }
    public int getCol() { return col; }

    // Setters
    
    // Methods
}
