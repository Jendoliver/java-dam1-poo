public class Password
{
    //Attributes
    private int longitud = 8;
    private String password;
    
    //Constructors
    public Password() {
        generarPassword();
    }
    public Password(int newLongitud) {
        setLongitud(newLongitud);
        generarPassword();
    }
    
    //Setters
    public void setLongitud(int newLongitud) {
        this.longitud = newLongitud;
    }
    
    //Getters
    public int getLongitud() {
        return this.longitud;
    }
    public String getPassword() {
        return this.password;
    }
    
    //Methods
    public boolean esFuerte() 
    {
        int nMayus = 0, nMinus = 0, nNum = 0;
        for(int i=0; i < this.longitud; i++)
        {
            if(Character.isDigit(this.password.charAt(i))) // If it's a number
                nNum++;
            else
            {
                if(Character.isUpperCase(this.password.charAt(i)))
                    nMayus++;
                else
                    nMinus++;
            }
        }
        return nMayus > 2 && nMinus > 1 && nNum > 5;
    }
    
    public void generarPassword()
    {
        String passlist = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String newPass = "";
        for(int i=0; i<getLongitud(); i++)
        {
            int c = (int)(Math.random()*passlist.length());
            newPass += passlist.charAt(c);
        }
        this.password = newPass;
    }
}