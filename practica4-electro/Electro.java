public class Electro
{
    //Attributes
    double preciobase = 100;
    String color = "blanco";
    char consumo = 'F';
    double peso = 5;
    
    //Constructors
    public Electro() {
        // Empty constructor
    }
    public Electro(double newPreciobase, double newPeso) {
        setPreciobase(newPreciobase);
        setPeso(newPeso);
    }
    public Electro(double newPreciobase, String newColor, char newConsumo, double newPeso) {
        setPreciobase(newPreciobase);
        setColor(newColor);
        setConsumo(newConsumo);
        setPeso(newPeso);
    }
    
    //Setters
    public void setPreciobase(double newPreciobase) {
        this.preciobase = newPreciobase;
    }
    public void setColor(String newColor) {
        if(comprobarColor(newColor))
            this.color = newColor;
    }
    public void setConsumo(char newConsumo) {
        if(comprobarConsumoEnergetico(newConsumo))
            this.consumo = newConsumo;
    }
    public void setPeso(double newPeso) {
        this.peso = newPeso;
    }
    
    //Getters
    public double getPreciobase() {
        return this.preciobase;
    }
    public String getColor() {
        return this.color;
    }
    public char getConsumo() {
        return this.consumo;
    }
    public double getPeso() {
        return this.peso;
    }
    
    //Methods
    private boolean comprobarColor(String newColor)
    {
        String upColor = newColor.toUpperCase();
        return (upColor == "BLANCO" || upColor == "NEGRO" || upColor == "ROJO" || upColor == "AZUL" || upColor == "GRIS");
    }
    
    private boolean comprobarConsumoEnergetico(char newConsumo)
    {
        return (newConsumo == 'A' || newConsumo == 'B' || newConsumo == 'C' || newConsumo == 'D' || newConsumo == 'E' || newConsumo == 'F');
    }
    
    public double precioFinal()
    {
        double preciofinal = this.preciobase;
        switch(this.consumo)
        {
            case 'A': preciofinal += 100; break;
            case 'B': preciofinal += 80; break;
            case 'C': preciofinal += 60; break;
            case 'D': preciofinal += 50; break;
            case 'E': preciofinal += 30; break;
            case 'F': preciofinal += 10; break;
        }
        if(this.peso < 20)
            preciofinal += 10;
        else if(this.peso < 50)
            preciofinal += 50;
        else if(this.peso < 80)
            preciofinal += 80;
        else if(this.peso < 100)
            preciofinal += 100;
        return preciofinal;
    }
}