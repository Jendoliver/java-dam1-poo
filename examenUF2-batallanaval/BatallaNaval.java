public class BatallaNaval
{
    // APP CONSTANTS
    int WIDTH = 10, HEIGHT = 10, BOATS = 4, MAXSIZE = 3;
    char[] ORIENTATIONS = {'V','H'};
    char[][] board = new char[WIDTH][HEIGHT];
    
    public static void main(String[] args)
    {
        // GameLoop
            // inicializeBoard (implies...)
                // placeBoat(5, randomOrientation)
                // placeBoat(4, randomOrientation)
                // placeBoat(3, randomOrientation)
                // placeBoat(2, randomOrientation)
            // while (areBoatsToDiscover || areTurnsLeft)
                // playGame (implies...)
                    // parseInput
                    // printBoard
        inicializeBoard();
        for(int i=0; i<BOATS; i++) // It's not my fault if java's random method is that messy
            placeBoat((int)((Math.random()*(MAXSIZE-1))+1),ORIENTATIONS[(int)(Math.random()*(ORIENTATIONS.length-1))]);
        
    }
    
    public void inicializeBoard()
    {
        for(int i=0; i<WIDTH; i++)
        {
            for(int j=0; j<HEIGHT; j++)
                board[i][j] = '~';
        }
    }
    
    public void placeBoat(int npos, char orientation)
    {
        
    }
}