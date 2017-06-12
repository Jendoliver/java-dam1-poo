/**
 * Created by Jendoliver on 22/05/2017.
 *  GitHub: github.com/Jendoliver
 */
public class Boat 
{
    // Attributes
    private int boatsize;
    private Orientations orientation;
    int hits;
    int row;
    int col;

    // Constructors
    public Boat(int boatsize)
    {
        this.boatsize = boatsize;
        // Generate a random orientation
        if ((int) (Math.random() * Orientations.getSize()) == 1) {
            orientation = Orientations.H;
        } else { orientation = Orientations.V; }

        // Generate a random position avoiding stack overflow
        if (orientation == Orientations.H)
        {
            // row = [0, BoardHeight]
            row = (int) (Math.random() * Board.getHeight());
            // col = [0, (BoardWidth - boatsize)]
            col = (int) (Math.random() * (Board.getWidth() - boatsize));
        }
        else
        {
            // row = [0, (BoardHeight - boatsize)]
            row = (int) (Math.random() * (Board.getHeight() - boatsize));
            // col = [0, BoardWidth]
            col = (int) ((Math.random() * Board.getWidth()));
        }
    }

    public Boat(int boatsize, Orientations orientation, int row, int col) // LOAD GAME
    {
        this.boatsize = boatsize;
        this.orientation = orientation;
        this.row = row;
        this.col = col;
    }

    // Getters
    public int getBoatsize() { return boatsize; }
    public Orientations getOrientation() { return orientation; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getHits() { return hits; }

    // Setters
    public void addHit() { this.hits++; }
}
