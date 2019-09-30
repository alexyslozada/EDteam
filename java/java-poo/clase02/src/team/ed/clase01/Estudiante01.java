package team.ed.clase01;

import team.ed.clase02.Persona;

public class Estudiante01 extends Persona {
    public void setEdad(int e) {
        edad = e;
    }

    public void saludar() {
        System.out.println("Hola, tengo: " + edad);
    }
}
