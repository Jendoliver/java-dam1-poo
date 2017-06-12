import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Created by the Focking Jendoliver on 12/06/2017
 * GitHub: github.com/Jendoliver
 */
public class Input
{
    public class SaveInput
    {
        public int pos = -1;
        public boolean isTrue = false;
        SaveInput() {}
    }
    public static boolean isSaveInput = false;

    public static int askIntInput(String message)
    {
        int input = -1;
        System.out.print(message);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                input = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid format: Please enter a positive integer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (input < 0);
        return input;
    }

    public static int askSaveInput(String message) // askIntInput + checks if user wants to save
    {
        int input = -1;
        String SaveInput = "";
        System.out.print(message);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                SaveInput = br.readLine();
                input = Integer.parseInt(SaveInput);
            } catch (NumberFormatException nfe) {
                if(SaveInput.equals("s") || SaveInput.equals("S"))
                {
                    isSaveInput = true;
                    return input;
                }
                System.err.println("Invalid format: Please enter a positive integer or S to save the game");
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
