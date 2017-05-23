public class BatallaNaval
{
    public static void main(String[] args)
    {
        BNGame BNGame = new BNGame();
        do {
            printIntro();
            BNGame.printBoard();
        } while (BNGame.wannaPlayAgain());
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
    
    public void printIntro()
    {
        System.out.println("Welcome to Battle Navale!!!");
        // TODO
    }
}