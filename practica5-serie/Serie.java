import java.util.ArrayList;

public class Serie
{
    //Attributes
    String title = "undefined";
    ArrayList<Season> seasons = new ArrayList<Season>();
    boolean delivered = false;
    String genre = "undefined";
    String creator = "undefined";
    
    //Constructors
    public Serie() {
        //Empty constructor
    }
    public Serie(String newTitle, String newCreator) {
        setTitle(newTitle);
        setCreator(newCreator);
    }
    public Serie(String newTitle, ArrayList<Season> newSeasons, String newGenre, String newCreator) {
        setTitle(newTitle);
        setSeasons(newSeasons);
        setGenre(newGenre);
        setCreator(newCreator);
    }
    
    //Setters
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    public void setSeasons(ArrayList<Season> newSeasons) {
        this.seasons = (ArrayList)newSeasons.clone();
    }
    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }
    public void setCreator(String newCreator) {
        this.creator = newCreator;
    }
    
    //Getters
    public String getTitle() {
        return this.title;
    }
    public ArrayList<Season> getSeasons() {
        return this.seasons;
    }
    public String getGenre() {
        return this.genre;
    }
    public String getCreator() {
        return this.creator;
    }
    
    //Methods
    public void addSeason(Season newSeason)
    {
        seasons.add(newSeason);
    }
    
    public void removeSeason(int index)
    {
        seasons.remove(index);
    }
    
    public String listSeasons()
    {
        String output = "";
        for(int i=0; i<seasons.size(); i++)
            output += "Season "+(i+1)+": "+seasons.get(i).getNchapters()+" chapters.\n";
        return output;
    }
}