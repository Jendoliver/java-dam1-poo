/**
 * Created by the Focking Jendoliver on 22/05/2017.
 *  GitHub: github.com/Jendoliver
 */
public class BNGame 
{
    private Board board;
    private int tries;
    private int occupiedcells;
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
        this.occupiedcells = this.board.getOccupiedCells();
    }

    // Getters
    public int getTries() { return this.tries; }
    public boolean areBoatsDiscovered() { return this.occupiedcells == this.touches; }
    public boolean areTriesLeft() { return this.tries > 0; }
    public boolean wannaPlayAgain()
    {
        return this.playagain;
    }

    // Setters
    public void setPlayagain(boolean playagain) { this.playagain = playagain; }
    public void useTry() { this.tries--; }

    // Methods
    public InputChecks checkPosition(int x, int y)
    {
        if(x < 0 || x > Board.getWidth() || y < 0 || x > Board.getHeight())
            return InputChecks.INVALID;
        else if( board.getBoard()[x][y].isDiscovered() )
            return InputChecks.DISCOVERED;
        else if(board.getBoard()[x][y].getContent() == BoardCells.WATER)
            return InputChecks.WATER;
        else if(board.getBoard()[x][y].getContent() == BoardCells.BOAT)
        {
            // TODO
            // if not murri
            return InputChecks.TOUCHE;
            // else
            //return InputChecks.MURRI;
        }
        return InputChecks.UNDEFINED;
    }

    public void processPosition(InputChecks check, int x, int y)
    {
        if(check != InputChecks.DISCOVERED && check != InputChecks.INVALID && check != InputChecks.UNDEFINED) {
            board.getBoard()[x][y].setDiscovered(true);
            useTry();
        }
    }

    public void printBoard()
    {
        int rowcount = 0;
        for(Cell[] cellrow : board.getBoard()) // Iterates through each row of cells
        {
            // Depending on rowcount lenght we print different prefix to avoid matrix unbalancing
            System.out.print((rowcount > 9) ? rowcount+" -" : rowcount+"  -");
            for(Cell cell : cellrow)
            {
                /*if(cell.isDiscovered()) // Iterates through each cell
                {*/
                    if(cell.getContent() == BoardCells.WATER)
                        System.out.print(" ~ ");
                    else if(cell.getContent() == BoardCells.BOAT)
                        System.out.print(" ^ ");
                /*}*/
                /*else
                    System.out.print(" * ");*/
            }
            System.out.print("\n\n");
            rowcount++;
        }
        // This prints spaces enough to balance the column indexes with the matrix
        System.out.print((rowcount > 9) ? "    " : "   ");
        // Print of the columns indexes
        for(int i = 0; i< Board.getWidth(); i++)
            System.out.print((i > 9) ? " "+i+" " : " "+i);
        System.out.println();
    }
}