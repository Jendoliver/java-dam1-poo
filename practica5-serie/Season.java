public class Season
{
    //Attributes
    private int nchapters = 0;
    
    //Constructors
    public Season() {
        //Empty constructor
    }
    public Season(int newNchapters) {
        setNchapters(newNchapters);
    }
    
    //Setters
    public void setNchapters(int newNchapters) {
        this.nchapters = newNchapters;
    }
    
    //Getters
    public int getNchapters() {
        return this.nchapters;
    }
}