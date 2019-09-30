package team.ed.test;

public class Persona implements Cloneable {
    public String nombre;
    public int edad;

    public Persona clone() throws CloneNotSupportedException {
        return (Persona) super.clone();
    }
}
