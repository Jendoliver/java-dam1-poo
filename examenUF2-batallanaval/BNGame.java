/**
 * Created by the Focking Jendoliver on 22/05/2017.
 *  GitHub: github.com/Jendoliver
 */
public class BNGame 
{
    private Board board;
    private int tries;
    private boolean playagain = false;

    BNGame() {
        resetGame();
    }

    private void resetGame()
    {
        this.board = new Board();
        this.tries = (int)(this.board.getEmptyCells() / 2);
    }

    public boolean wannaPlayAgain()
    {
        return this.playagain;
    }
}