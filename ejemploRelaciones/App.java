public class App
{
    public static void main(String[] args)
    {
        Movil mov = new Movil();
        Funda fun = new Funda();
        
        System.out.println(mov.getMarca());
        System.out.println(mov.getPantalla().getPulgadas());
    }
}