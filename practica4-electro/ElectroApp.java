public class ElectroApp
{
    public static void main(String[] args)
    {
        Electro e = new Electro(100, "blanso", 'C', 5);
        System.out.println("Precio final del electrodomestico de color "+e.getColor()+": "+e.precioFinal()+" €");
    }
}