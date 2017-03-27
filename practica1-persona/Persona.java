public class Persona
{
    //Attributes
    private String nombre = "";
    private int edad = 0;
    private String DNI = "";
    private char sexo = 'H';
    private double peso = 0;
    private double altura = 0;
    
    //Constructors
    public Persona() {
        generaDNI();
    }
    
    public Persona(String newNombre, int newEdad, char newSexo)
    {
        setNombre(newNombre);
        setEdad(newEdad);
        setSexo(newSexo);
        generaDNI();
    }
    
    public Persona(String newNombre, int newEdad, String newDNI, char newSexo, double newPeso, double newAltura)
    {
        setNombre(newNombre);
        setEdad(newEdad);
        generaDNI();
        setSexo(newSexo);
        setPeso(newPeso);
        setAltura(newAltura);
    }
    
    //Setters
    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }
    public void setEdad(int newEdad) {
        this.edad = newEdad;
    }
    public void setSexo(char newSexo) {
        this.sexo = newSexo;
    }
    public void setPeso(double newPeso) {
        this.peso = newPeso;
    }
    public void setAltura(double newAltura) {
        this.altura = newAltura;
    }
    
    //Getters
    public String getNombre() {
        return this.nombre;
    }
    public int getEdad() {
        return this.edad;
    }
    public String getDNI() {
        return this.DNI;
    }
    public char getSexo() {
        return this.sexo;
    }
    public double getPeso() {
        return this.peso;
    }
    public double getAltura() {
        return this.altura;
    }
    
    //Methods
    public int calcularIMC()
    {
        double imc = this.getPeso()/Math.pow(this.getAltura(),2);
        if(imc >= 18.5 && imc < 25)
            return 0;
        else if(imc < 18.5)
            return 1;
        return -1;
    }
    
    public boolean esMayorDeEdad()
    {
        return this.getEdad() > 17;
    }
    
    private boolean comprobarSexo(char sexo)
    {
        if(this.getSexo() == 'H' || this.getSexo() == 'M')
            return true;
        this.setSexo('H');
        return false;
    }
    
    public String toString()
    {
        return "Nombre: "+this.getNombre()+", Edad: "+this.getEdad()+", DNI: "+this.getDNI()+", Sexo: "+this.getSexo()+", Peso: "+this.getPeso()+", Altura: "+this.getAltura();
    }
    
    public void generaDNI()
    {
        int ndni = (int)(99999999 * Math.random() + 10000000);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int i = ndni % 23;
        char ldni = letras.charAt(i);
        this.DNI = Integer.toString(ndni)+ldni;
    }
}