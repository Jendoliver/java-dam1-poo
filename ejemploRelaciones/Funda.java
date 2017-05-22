public class Funda
{
    private String color;
    private float precio;
    
    public Funda() {
        // Empty
    }
    public Funda(String color, float precio) {
        setColor(color);
        setPrecio(precio);
    }
    
    public String getColor() {
        return this.color;
    }
    public float getPrecio() {
        return this.precio;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}