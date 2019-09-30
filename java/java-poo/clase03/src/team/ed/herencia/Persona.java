package team.ed.herencia;

public abstract class Persona {
    public String nombre;
    public int edad;
    public float alto;
    public float peso;

    public void hablar() {
        System.out.println("Hola soy " + this.nombre);
    }

    public void comer() {
        System.out.println("Estoy comiendo");
    }

    public abstract void reir();
}
