import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Created by Jendoliver on 12/06/2017
 * GitHub: github.com/Jendoliver
 */
public class Input
{
    public static boolean isSaveInput = false;

    public static int askIntInput(String message)
    {
        int input = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(message);
            try {
                input = Integer.parseInt(br.readLine());
                if(input < 0) System.err.println("Invalid format: Please enter a positive integer");
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid format: Please enter a positive integer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (input == -1);
        return input;
    }

    public static int askIntInputBetween(String message, int a, int b)
    {
        int input = a - 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(message);
            try {
                input = Integer.parseInt(br.readLine());
                if(input < a || input > b) System.err.println("Invalid format: Please enter an integer between "+a+" and "+b);
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid format: Please enter a positive integer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (input < a || input > b);
        return input;
    }

    public static int askSaveInput(String message) // askIntInput + checks if user wants to save
    {
        int input = -1;
        String SaveInput = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(message);
            try {
                SaveInput = br.readLine();
                input = Integer.parseInt(SaveInput);
                if(input < 0) System.err.println("Invalid format: Please enter a positive integer or S to save the game\n");
            } catch (NumberFormatException nfe) {
                if(SaveInput.equals("s") || SaveInput.equals("S"))
                {
                    isSaveInput = true;
                    return input;
                }
                else
                    System.err.println("Invalid format: Please enter a positive integer or S to save the game\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (input < 0);
        return input;
    }

    public static boolean askYNQuestion(String question)
    {
        String input = "not valid";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(question+" (y/n): ");
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
