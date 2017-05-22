import org.jetbrains.annotations.Contract;

/**
 * Created by the Focking Jendoliver on 22/05/2017.
 * GitHub: github.com/Jendoliver
 */
public class Cell
{
    // Attributes
    private BoardCells content;
    private boolean discovered;

    // Constructor
    public Cell()
    {
        content = BoardCells.WATER;
        discovered = false;
    }

    // Getters
    public BoardCells getContent() { return content; }
    public boolean isDiscovered() { return discovered; }

    // Setters
    public void setContent(BoardCells cont) { this.content = cont; }
    public void setDiscovered(boolean disc) { this.discovered = disc; }
}
