package team.ed.clase01;

import team.ed.clase02.Persona;

public class Ejecutar {
    public static void main(String[] args) {
        //Persona p = new Persona();
        //p.edad = 10;
        //System.out.println(p.edad);

        Estudiante01 e = new Estudiante01();
        e.setEdad(33);
        e.saludar();
    }
}
