public class PersonaApp
{
    public static void main(String[] args)
    {
        Persona p = new Persona("Jandol", 17, 'M');
        System.out.println(p.toString());
        if(p.esMayorDeEdad())
            System.out.println("Es mayor de edad");
        else
            System.out.println("Es menor de edad");
    }
}