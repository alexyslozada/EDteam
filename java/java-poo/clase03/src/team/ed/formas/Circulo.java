package team.ed.formas;

public class Circulo implements Figura {
    String nombre;
    double radio;

    public Circulo(String nombre, double radio) {
        this.nombre = nombre;
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return PI * this.radio * this.radio;
    }

    @Override
    public double getPerimetro() {
        return 0;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
