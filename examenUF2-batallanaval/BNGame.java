import java.util.ArrayList;

/**
 * Created by the Focking Jendoliver on 22/05/2017.
 *  GitHub: github.com/Jendoliver
 */
public class BNGame 
{
    private Board board;
    private int maxtries;
    private int tries;
    private int occupiedcells;
    private int touches;
    private ArrayList<int[]> shots;
    private boolean playagain = false;

    public BNGame(GameProperties gp)
    {
        this.touches = 0;
        this.board = new Board(gp);
        // this.tries = this.board.getEmptyCells() / 2; DEPRECATED
        this.maxtries = gp.tries;
        this.tries = gp.tries;
        this.shots = new ArrayList();
        this.occupiedcells = this.board.getOccupiedCells();
    }
    public BNGame(int maxtries, int width, int height) // LOAD GAME CONSTRUCTOR
    {
        this.touches = 0;
        this.board = new Board(width, height);
        this.maxtries = maxtries;
        this.tries = maxtries;
        this.shots = new ArrayList();
        this.occupiedcells = this.board.getOccupiedCells();
    }

    // Getters
    public int getMaxTries() { return this.maxtries; }
    public int getTries() { return this.tries; }
    public ArrayList<int[]> getShots() { return this.shots; };
    public boolean areBoatsDiscovered() { return this.occupiedcells == this.touches; }
    public boolean areTriesLeft() { return this.tries > 0; }
    public boolean isGameFinished() { return areBoatsDiscovered() || !areTriesLeft(); }
    public boolean wannaPlayAgain() { return this.playagain; }

    // Setters
    public void setPlayagain(boolean playagain) { this.playagain = playagain; }
    public void useTry() { this.tries--; }
    public void addTouche() { this.touches++; }
    public void addShot(int x, int y) { int[] shot = {x, y}; this.shots.add(shot); }

    // Methods
    public InputChecks checkPosition(int x, int y)
    {
        if(x < 0 || x > Board.getHeight())
            return InputChecks.INVALID_ROW;
        else if(y < 0 || y > Board.getWidth())
            return InputChecks.INVALID_COL;
        else if( board.getBoard()[x][y].isDiscovered() )
            return InputChecks.DISCOVERED;
        else if(board.getBoard()[x][y].getContent() == BoardCells.WATER)
            return InputChecks.WATER;
        else if(board.getBoard()[x][y].getContent() == BoardCells.BOAT)
        {
            Boat boat = board.getBoard()[x][y].getBoat();
            if(boat.getHits() + 1 == boat.getBoatsize())
                return InputChecks.MURRI;
            else
                return InputChecks.TOUCHE;
        }
        return InputChecks.UNDEFINED;
    }

    public void processPosition(InputChecks check, int x, int y)
    {
        if(check != InputChecks.DISCOVERED && check != InputChecks.INVALID_ROW && check != InputChecks.INVALID_COL && check != InputChecks.UNDEFINED) {
            board.getBoard()[x][y].setDiscovered(true);
            addShot(x, y);
            useTry();
            if(check == InputChecks.TOUCHE || check == InputChecks.MURRI) {
                addTouche();
                board.getBoard()[x][y].getBoat().addHit();
            }
        }
    }

    public void printBoard()
    {
        int rowcount = 0;
        for(Cell[] cellrow : board.getBoard()) // Iterates through each row of cells
        {
            // Depending on rowcount lenght we print different prefix to avoid matrix unbalancing
            System.out.print((rowcount > 9) ? rowcount+" - " : rowcount+"  - ");
            for(Cell cell : cellrow)
            {
                if(cell.isDiscovered()) // Iterates through each cell
                {
                    if (cell.getContent() == BoardCells.WATER)
                        System.out.print(" ~ ");
                    else if (cell.getContent() == BoardCells.BOAT)
                        System.out.print(" O ");
                }
                else
                    System.out.print(" * ");
            }
            System.out.print("\n\n");
            rowcount++;
        }
        // This prints spaces enough to balance the column indexes with the matrix
        System.out.print((rowcount > 9) ? "     " : "    ");
        // Print of the columns indexes
        for(int i = 0; i< Board.getWidth(); i++)
            System.out.print((i > 9) ? " "+i : " "+i+" ");
        System.out.println();
    }

    public String summariseGame()
    {
        String summary = "";
        if(areBoatsDiscovered())
        {
            summary += " ----- CONGRATULATIONS!!! -----\n";
            summary += "You won with " + getTries() + " tries left.\n";
        }
        else
        {
            summary += "It's all there... black and white... CLEAR AS CRYSTAL!\n";
            summary += "You get NOTHING! You LOSE!\n";
            summary += "GOOD DAY SIR!\n";
        }
        return summary;
    }
}