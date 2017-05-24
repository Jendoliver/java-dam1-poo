import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class BattleNavale
{
    public static void main(String[] args) throws IOException
    {
        BNGame BNGame;
        do {
            BNGame = new BNGame();
            printIntro();
            BNGame.printBoard();
            do {
                System.out.println("Shots left: "+ BNGame.getTries());
                int x = askForInput("Input the row to attack: ");
                int y = askForInput("Input the column to attack: ");
                InputChecks check = BNGame.checkPosition(x, y);
                BNGame.processPosition(check, x, y);
                BNGame.printBoard();
                printInputCheck(check);
            } while (!BNGame.areBoatsDiscovered() && BNGame.areTriesLeft());
            BNGame.setPlayagain(askToPlayAgain());
        } while (BNGame.wannaPlayAgain());
    }
    
    private static void printIntro()
    {
        System.out.println("Welcome to Battle Navale!!!");
        // TODO
    }

    private static int askForInput(String message)
    {
        int input = -1;
        System.out.print(message);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ( input < 0) {
            try {
                input = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Formato no válido");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        return input;
    }

    private static void printInputCheck(InputChecks check)
    {
        switch(check)
        {
            case WATER:
                System.out.println("Water..."); break;
            case TOUCHE:
                System.out.println("Touche!"); break;
            case MURRI:
                System.out.println("Murri!!!"); break;
            case DISCOVERED:
                System.out.println("You have already discovered that position..."); break;
            case INVALID:
                System.out.println("Introduce un rango de filas entre 0 y "+Board.getHeight()+", y un rango de columnas entre 0 y "+ Board.getWidth()); break;
            case UNDEFINED:
                System.out.println("UNDEFINED"); break;
        }
    }

    private static boolean askToPlayAgain()
    {
        String input = "not valid";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Wanna play again? (y/n): ");
        do {
            try {
                input = br.readLine();
            } catch (NumberFormatException nfe) {
                System.err.println("Formato no válido");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (! Objects.equals(input.toLowerCase(), "y") && ! Objects.equals(input.toLowerCase(), "n"));
        return Objects.equals(input.toLowerCase(), "y");
    }
}