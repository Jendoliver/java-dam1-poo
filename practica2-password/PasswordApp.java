import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordApp
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nPass = 0;
        // Introducción del número de contraseñas
        System.out.print("Introduce el numero de contrasenas: ");
        try {
            nPass = Integer.parseInt(br.readLine());
        } catch(NumberFormatException nfe) {
            System.err.println("Formato no válido");
        }
        
        // Introducción de longitudes
        int[] lengths = new int[nPass];
        System.out.println("Introduce las longitudes de las contrasenas: ");
        for(int i=0; i<nPass; i++)
        {
            int L = 0;
            System.out.print("Longitud de la contrasena "+(i+1)+": ");
            try {
                L = Integer.parseInt(br.readLine());
            } catch(NumberFormatException nfe) {
                System.err.println("Formato no válido");
            }
            lengths[i] = L;
        }
        
        // Creación de passwords y array de booleanos, impresión de contraseñas y su robustez
        Password[] passwords = new Password[nPass];
        boolean[] strongs = new boolean[nPass];
        for(int i=0; i<nPass; i++) 
        {
            passwords[i] = new Password(lengths[i]);
            strongs[i] = passwords[i].esFuerte();
            System.out.println(passwords[i].getPassword()+" "+strongs[i]);
        }
    }
}