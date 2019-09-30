package team.ed.ejecutar;

import team.ed.herencia.Persona;
import team.ed.herencia.Profesor;

public class Main {
    public static void main(String[] args) {
//        Persona persona = new Persona();
//        persona.nombre = "Pedro";
//        persona.hablar();
//        persona.comer();

        Profesor profesor = new Profesor("Juan");
//        profesor.nombre = "Juan";
        profesor.hablar();
        profesor.ensenar();
        profesor.ensenar("Matemáticas");
        profesor.comer();
        profesor.reir();
    }
}
