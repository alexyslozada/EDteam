class Principal {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona otrapersona = new Persona("Leidy Gonzalez");
        Persona tercera = new Persona("Pedro Perez", 20);

        // persona.nombre = "Alexys Lozada";
        // persona.edad = -14;
        // persona.peso = 90f;
        // persona.estatura = 1.7f;
        persona.setNombre("Alexys Lozada");
        persona.setEdad(39);

        // System.out.println("Nombre: " + persona.getNombre());
        // System.out.println("Edad: " + persona.getEdad());
        // System.out.println("Nombre de la otra persona: " + otrapersona.getNombre());
        // System.out.println("Nombre tercera: " + tercera.getNombre());
        // System.out.println("Edad tercera: " + tercera.getEdad());
        // persona.saludar();
        // otrapersona.saludar();
        // tercera.saludar();
        // System.out.println("Edad: " + persona.edad);
        // System.out.println("Peso: " + persona.peso);
        // System.out.println("Estatura: " + persona.estatura);
    }
}