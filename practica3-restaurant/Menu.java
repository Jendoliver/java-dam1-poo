public class Menu
{
    //Attributes
    private String name;
    private double kcal;
    private int cookingtime;
    private double price;
    private double winebottles;
    
    //Constructors
    public Menu() {
        setName("undefined");
        setKcal(0);
        setCookingtime(0);
        setPrice(0);
        setWinebottles(0);
    }
    public Menu(String newName, double newKcal, int newCookingtime, double newPrice, double newWinebottles) {
        setName(newName);
        setKcal(newKcal);
        setCookingtime(newCookingtime);
        setPrice(newPrice);
        setWinebottles(newWinebottles);
    }
    
    //Setters
    public void setName(String newName) {
        this.name = newName;
    }
    public void setKcal(double newKcal) {
        this.kcal = newKcal;
    }
    public void setCookingtime(int newCookingtime) {
        this.cookingtime = newCookingtime;
    }
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    public void setWinebottles(double newWinebottles) {
        this.winebottles = newWinebottles;
    }
    
    //Getters
    public String getName() {
        return this.name;
    }
    public double getKcal() {
        return this.kcal;
    }
    public int getCookingtime() {
        return this.cookingtime;
    }
    public double getPrice() {
        return this.price;
    }
    public double getWinebottles() {
        return this.winebottles;
    }
    
    //Methods
    public String toString() 
    {
        return "Menu "+this.name+" contains "
        +this.kcal+" calories, comes with "
        +this.winebottles+" bottles and costs "
        +this.price+"$";
    }
}