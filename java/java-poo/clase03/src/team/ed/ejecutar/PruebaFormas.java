package team.ed.ejecutar;

import team.ed.formas.Circulo;
import team.ed.formas.Figura;
import team.ed.formas.Rectangulo;
import team.ed.formas.Triangulo;

public class PruebaFormas {
    public static void main(String[] args) {
        Figura formas[] = new Figura[3];
        formas[0] = new Rectangulo("Rectangulo", 20, 30);
        formas[1] = new Circulo("Circulo",15);
        formas[2] = new Triangulo("Triangulo", 10, 20);

        for (Figura v : formas) {
            System.out.println("Area de "+v.getNombre()+": "+v.getArea());
        }
    }
}
