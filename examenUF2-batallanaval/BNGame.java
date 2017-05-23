/**
 * Created by the Focking Jendoliver on 22/05/2017.
 *  GitHub: github.com/Jendoliver
 */
public class BNGame 
{
    private Board board;
    private int tries;
    private int boatpositions;
    private int touches;
    private boolean playagain = false;

    BNGame() {
        resetGame();
    }

    private void resetGame()
    {
        this.touches = 0;
        this.board = new Board();
        this.tries = this.board.getEmptyCells() / 2;
        this.boatpositions = this.board.getOccupiedCells();
    }

    public InputChecks checkPosition(int x, int y)
    {
        if(x < 0 || x > board.getWidth() || y < 0 || x > board.getHeight())
            return InputChecks.INVALID;
        else if( false ) // discovered
            return InputChecks.DISCOVERED;
        else if(board.getBoard()[x][y].getContent() == BoardCells.WATER)
            return InputChecks.WATER;
        else if(board.getBoard()[x][y].getContent() == BoardCells.BOAT)
        {
            // TODO
            // if not murri
            return InputChecks.TOUCHE;
            // else
            return InputChecks.MURRI;
        }
    }

    public void printBoard()
    {

    }

    public void setPlayagain(boolean playagain) { this.playagain = playagain; }
    public boolean areBoatsDiscovered() { return this.boatpositions == this.touches; }
    public boolean wannaPlayAgain()
    {
        return this.playagain;
    }
}