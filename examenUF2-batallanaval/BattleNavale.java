import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class BattleNavale
{
    public static void main(String[] args) throws IOException
    {
        BNGame BNGame;
        GameModes mode = decodeArgs(args);
        GameProperties gp = prepareGameMode(mode);
        if(mode == GameModes.DOCUMENTATION) return; // Exits game if documentation is printed
        do {
            BNGame = new BNGame(gp);
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

    private static GameProperties prepareGameMode(GameModes mode)
    {
        GameProperties gp = new GameProperties();
        switch(mode)
        {
            case DOCUMENTATION:
            {
                printDocumentation();
                break;
            }
            case EASY: // 5x5, 3 boats, 3 3 2, 15 tries
            {
                int[] boatsarray = {3, 3, 2};
                gp.width = 5;
                gp.height = 5;
                gp.tries = 15;
                gp.boats = boatsarray;
                break;
            }
            case MEDIUM: // 10x10, 4 boats, 5 4 3 2, 50 tries
            {
                int[] boatsarray = {5, 4, 3, 2};
                gp.width = 10;
                gp.height = 10;
                gp.tries = 50;
                gp.boats = boatsarray;
                break;
            }
            case HARD: // 20x20, 10 boats, 7 7 6 6 5 4 3 2 1 1
            {
                int[] boatsarray = {7, 7, 6, 6, 5, 4, 3, 2, 1, 1, 5, 5, 5, 5, 5};
                gp.width = 20;
                gp.height = 20;
                gp.tries = 180;
                gp.boats = boatsarray;
                break;
            }
            case CLASSIC: // 10x10, 5 boats, 5 4 3 3 2
            {
                int[] boatsarray = {5, 4, 3, 3, 2};
                gp.width = 10;
                gp.height = 10;
                gp.tries = 50;
                gp.boats = boatsarray;
                break;
            }
            case CUSTOM: // Maxlength: min side of the board - 2, TODO: implement custom
            {
                gp = askProperties();
                break;
            }
        }
        return gp;
    }

    private static void printDocumentation()
    {
        System.out.println("\n\n--- BATTLE NAVALE: Documentation ---\n");
        System.out.println("Syntax: java BattleNavale <mode> where");
        System.out.println("<mode> is one of the following:\n");
        System.out.println("    -m | -h | help | man --- Prints this documentation");
        System.out.println("    easy | 1 --- Plays the game on easy mode");
        System.out.println("    medium | 2 --- Plays the game on medium mode");
        System.out.println("    hard | 3 --- Plays the game on hard mode");
        System.out.println("    classic --- Plays the game on classic mode");
        System.out.println("    custom --- Plays the game with custom board size, number of boats and max boat length (they will be asked on start)");
    }
    
    private static void printIntro()
    {
        System.out.println("Welcome to Battle Navale!!!");
        // TODO: Extend with boats info (size of each, etc)
    }

    private static GameProperties askProperties()
    {
        // Maxlength: min side of the board - 2
        GameProperties gp = null;
        int width = askForInput("Enter a width");
        return gp;
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