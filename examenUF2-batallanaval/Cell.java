/**
 * Created by the Focking Jendoliver on 22/05/2017.
 * GitHub: github.com/Jendoliver
 */
public class Cell
{
    // Attributes
    private BoardCells content;
    private boolean discovered;
    private Boat boat;

    // Constructor
    public Cell()
    {
        content = BoardCells.WATER;
        discovered = false;
    }

    // Getters
    public BoardCells getContent() { return content; }
    public boolean isDiscovered() { return discovered; }
    public Boat getBoat() { return boat; }

    // Setters
    public void setContent(BoardCells cont) { this.content = cont; }
    public void setDiscovered(boolean disc) { this.discovered = disc; }
    public void setBoat(Boat boat) { this.boat = boat; }
}
