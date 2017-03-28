import java.util.ArrayList;

public class SerieApp
{
    public static void main(String[] args)
    {
        // Creation of Season objects;
        Season s1 = new Season(5);
        Season s2 = new Season(2);
        Season s3 = new Season(10);
        
        // Addition of Season objects to the ArrayList seasons
        ArrayList<Season> seasons = new ArrayList<Season>();
        seasons.add(s1); seasons.add(s2); seasons.add(s3);
        
        // Creation of Serie object
        Serie fullmetal = new Serie("Fullmetal Alchemist", seasons, "Drama", "Hiromu Arakawa");
        System.out.println("Serie: "+fullmetal.getTitle()+", Genre: "+fullmetal.getGenre()+", Creator: "+fullmetal.getCreator());
        System.out.println(fullmetal.listSeasons());
        
        // addSeason() test
        Season s4 = new Season(15);
        fullmetal.addSeason(s4);
        System.out.println("NEW SEASON ADDED");
        System.out.println(fullmetal.listSeasons());
        
        // removeSeason() test
        fullmetal.removeSeason(3);
        fullmetal.removeSeason(1);
        System.out.println("SEASONS REMOVED");
        System.out.println(fullmetal.listSeasons());
    }
}