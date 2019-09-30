package team.ed.test;

public class Referencias {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.nombre = "Pedro";
        persona.edad = 20;

        Persona otraPersona = persona;
        otraPersona.nombre = "Carol";
        otraPersona.edad = 29;

        Persona segundaPersona = new Persona();
//        segundaPersona.nombre = persona.nombre;
//        segundaPersona.edad = persona.edad;

        try {
            segundaPersona = persona.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        segundaPersona.nombre = "Leidy";
        segundaPersona.edad = 15;

        System.out.println(persona.nombre);
        System.out.println(persona.edad);
        System.out.println(otraPersona.nombre);
        System.out.println(otraPersona.edad);
        System.out.println(segundaPersona.nombre);
        System.out.println(segundaPersona.edad);
    }
}
