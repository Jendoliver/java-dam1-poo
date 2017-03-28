public class Serie
{
    //Attributes
    String title = "undefined";
    int nseasons = 3;
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
    public Serie(String newTitle, int newNseasons, String newGenre, String newCreator) {
        setTitle(newTitle);
        setNseasons(newNseasons);
        setGenre(newGenre);
        setCreator(newCreator);
    }
    
    //Setters
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
    public void setNseasons(int newNseasons) {
        this.nseasons = newNseasons;
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
    public int getNseasons() {
        return this.nseasons;
    }
    public String getGenre() {
        return this.genre;
    }
    public String getCreator() {
        return this.creator;
    }
    
    //Methods
}