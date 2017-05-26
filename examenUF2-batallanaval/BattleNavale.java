import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class BattleNavale
{
    // TODO: Implement game modes
    public static void main(String[] args) throws IOException
    {
        BNGame BNGame;
        GameModes mode = decodeArgs(args);
        prepareGameMode(mode);
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
            } while ( ! BNGame.isGameFinished());
            System.out.println(BNGame.summariseGame());
            BNGame.setPlayagain(askToPlayAgain());
        } while (BNGame.wannaPlayAgain());
    }

    private static GameModes decodeArgs(String[] args)
    {
        if(args.length != 0)
        {
            switch (args[0])
            {
                case "help":case "man":case "-h":case "-m":
                    return GameModes.DOCUMENTATION;
                case "easy":case "1":
                    return GameModes.EASY;
                case "medium":case "2":
                    return GameModes.MEDIUM;
                case "hard":case "3":
                    return GameModes.HARD;
                case "classic":
                    return GameModes.CLASSIC;
                case "custom":
                    return GameModes.CUSTOM;
            }
        }
        return GameModes.CLASSIC;
    }

    private static void prepareGameMode(GameModes mode)
    {
        switch(mode)
        {
            case DOCUMENTATION:
                printDocumentation(); break;
            case EASY:
                break;
            case MEDIUM:
                break;
            case HARD:
                break;
            case CUSTOM:
                break;
            case CLASSIC:
                break;
        }

    }

    private static void printDocumentation()
    {
        // TODO
    }
    
    private static void printIntro()
    {
        System.out.println("Welcome to Battle Navale!!!");
        // TODO: Extend with boats info (size of each, etc)
    }

    private static int askForInput(String message)
    {
        int input = -1;
        System.out.print(message);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid format: Please enter an integer");
        } catch (IOException e) {
            e.printStackTrace();
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
                System.out.println("Murri!!! You destroyed a boat!"); break;
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
                System.err.println("Invalid format");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (! Objects.equals(input.toLowerCase(), "y") && ! Objects.equals(input.toLowerCase(), "n"));
        return Objects.equals(input.toLowerCase(), "y");
    }
}