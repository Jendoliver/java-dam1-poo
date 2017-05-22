import org.jetbrains.annotations.Contract;

/**
 * Created by the Focking Jendoliver on 22/05/2017.
 * GitHub: github.com/Jendoliver
 */
public enum BoardCells
{
    UNDISCOVERED,
    WATER,
    BOAT;

    private static final int size = BoardCells.values().length;
    public static int getSize() { return size; }
}
