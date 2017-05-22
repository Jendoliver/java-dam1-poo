/**
 * Created by the Focking Jendoliver on 22/05/2017.
 *  GitHub: github.com/Jendoliver
 */
public class Boat 
{
    // Attributes
    private int boatsize;
    private Orientations orientation;
    int row;
    int col;

    // Constructors
    public Boat()
    {
        int MAXSIZE = 3;
        boatsize = (int) ((Math.random() * (MAXSIZE - 1)) + 1);
        if ((int) (Math.random() * Orientations.getSize()) == 1) {
            orientation = Orientations.H;
        } else { orientation = Orientations.V; }
        row = (int) (Math.random() * Board.getWidth());
        col = (int) (Math.random() * Board.getHeight());
    }

    // Getters
    public int getBoatsize() { return boatsize; }
    public Orientations getOrientation() { return orientation; }

    // Setters
    
    // Methods
}
