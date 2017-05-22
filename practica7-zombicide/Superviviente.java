public class Superviviente
{
    // Atributos
    private int vidas = 3;
    private int nivel = 0;
    private String nombre = "undefined";
    private SkillsPersonaje skill = SkillsPersonaje.RAPIDO;
    private Arma arma = NULL;
    
    // Constructores
    public Superviviente() {
        // Empty constructor
    }
    public Superviviente(int vidas, int nivel, String nombre, SkillsPersonaje skill) {
        setVidas(vidas);
        setNivel(nivel);
        setNombre(nombre);
        setSkill(skill);
    }
    
    // Setters
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSkill(SkillsPersonaje skill) {
        this.skill = skill;
    }
    
    // Getters
    public int getVidas() {
        return vidas;
    }
    public int getNivel() {
        return nivel;
    }
    public String getNombre() {
        return nombre;
    }
    public SkillsPersonaje getSkill() {
        return skill;
    }
    
    // Methods
    public boolean tieneArma() {
        
    }
}