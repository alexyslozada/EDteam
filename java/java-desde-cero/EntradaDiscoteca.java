public class EntradaDiscoteca {
    public static void main(String... args) {
        int edad = 17;
        try {
            validar(edad);
        } catch (ExcepcionMayorDeEdad emde) {
            System.out.println(emde.getMessage());
        }

        System.out.println("proceso terminado");
    }

    public static void validar(int edad) throws ExcepcionMayorDeEdad {
        if (edad < 18) {
            throw new ExcepcionMayorDeEdad("no te puedo dejar entrar");
        } else {
            System.out.println("Bienvenido a la disco");
        }
    }
}