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
        do {
            BNGame = (askYNQuestion("Do you want to load a previous game?")) ? FileManager.load() : new BNGame(gp);
            printIntro();
            BNGame.printBoard();
            do {
                System.out.println("Shots left: "+ BNGame.getTries());
                int x = askForInput("Input the row to attack (or type S to save and quit): ");
                if (x == -696969) FileManager.save(BNGame); // TODO: PLEASE REFACTOR THIS MY EYES ARE BLEEDING
                int y = askForInput("Input the column to attack: ");
                InputChecks check = BNGame.checkPosition(x, y);
                BNGame.processPosition(check, x, y);
                BNGame.printBoard();
                printInputCheck(check);
            } while ( ! BNGame.isGameFinished());
            System.out.println(BNGame.summariseGame());
            BNGame.setPlayagain(askYNQuestion("Do you want to play again?"));
        } while (BNGame.wannaPlayAgain());
    }

    private static GameModes decodeArgs(String[] args)
    {
        if(args.length != 0)
        {
            switch (args[0])
            {
                case "help":case "man":case "-h":case "-m":
                    printDocumentation();
                    System.exit(0);
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
                int[] boatsarray = {7, 7, 6, 6, 5, 4, 3, 2, 1, 1};
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
        GameProperties gp = new GameProperties();
        gp.width = askForInput("Enter a width between 20 and 50: ");
        gp.height = askForInput("Enter a height between 20 and 50: ");
        int nboats = askForInput("Enter a number of boats between 1 and 15: ");
        gp.boats = new int[nboats];
        for(int i=0; i < gp.boats.length; i++)
        {
            gp.boats[i] = askForInput("Enter the lenght of the boat num "+(i+1)+": ");
        }
        gp.tries = askForInput("Enter your desired number of tries to win this battle: ");
        return gp;
    }

    private static int askForInput(String message) // TODO: Refactor return value
    {
        int input = -1;
        String saveInput;
        System.out.print(message);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            saveInput = br.readLine();
            if(saveInput.equals("s") || saveInput.equals("S"))
                return -696969; // Ninja patch aka PLEASE REFACTOR THIS
            else
                input = Integer.parseInt(saveInput);
        }/* catch (NumberFormatException nfe) {
            System.err.println("Invalid format: Please enter an integer");
        }*/ catch (IOException e) {
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
            case INVALID_ROW:
                System.out.println("Please insert a row range between 0 and "+Board.getHeight()); break;
            case INVALID_COL:
                System.out.println("Please insert a column range between 0 and "+Board.getWidth()); break;
            case UNDEFINED:
                System.out.println("UNDEFINED"); break;
        }
    }

    private static boolean askYNQuestion(String question)
    {
        String input = "not valid";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(question+" (y/n): ");
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