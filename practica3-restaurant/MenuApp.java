public class MenuApp
{
    public static void main(String[] args)
    {
        //Creation of the Menus (ex3)
        Menu m1 = new Menu("Stamppot boerenkool", 564.65, 45, 20.5, 0.5);
        Menu m2 = new Menu("Metworst", 345, 12, 10.99, 0);
        Menu m3 = new Menu("Hutspot", 560.4, 65, 30.9, 1);
        Menu m4 = new Menu("Biefstuk", 780, 46, 50.34, 2);
        Menu m5 = new Menu("Kibbeling", 450.4, 23, 20.78, 1);
        
        //Creation of the array and toString() print loop (ex4)
        Menu[] menus = {m1, m2, m3, m4, m5};
        for(int i=0; i<menus.length; i++)
            System.out.println(menus[i].toString());
            
        //Cooking time loop (ex5)
        for(int i=0; i<menus.length; i++)
        {
            int cookingtime = menus[i].getCookingtime();
            if(cookingtime < 30)
                System.out.println(menus[i].getName()+" cooks in "+cookingtime+" minutes");
        }
        
        //Total price loop (ex6)
        double totalprice = 0;
        for(int i=0; i<menus.length; i++)
            totalprice += menus[i].getPrice();
        System.out.println("The total price is: "+totalprice+"$");
        // Discounted price
        if(totalprice > 65)
            System.out.println("The discounted price is: "+(totalprice-totalprice*0.1)+"$");
    }
}