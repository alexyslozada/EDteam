// Lanzar excepciones a metodos superiores

// throws permite elevar una excepcion a un metodo superior
// throw lanza la excepcion

// Excepciones verificadas
// controlar el uso de try catch en tiempo de compilacion
// Es obligatorio usar try catch para poder comiplar
// Heredan de Exception

// Excepciones no verificadas
// no obligan el uso de try catch en tiempo de compilacion
// Heredan RuntimeException

public class EncadenarExcepcion {

    public static void main(String... args) {
        int a = 6;
        int b = 0;
        try {
            int c = dividir(a, b);
            System.out.println("Resultado: " + c);
        } catch (ArithmeticException ae) {
            System.out.println("No se puede dividir por cero");
        }

        System.out.println("Este programa puede seguir funcionando");

        try {
            superior();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalizado totalmente");
    }

    public static int dividir(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void superior() throws Exception {
        try {
            intermedio();
        } catch (Exception e) {
            throw new Exception("Metodo superior", e);
        }
    }

    public static void intermedio() throws Exception {
        try {
            inferior();
        } catch (Exception e) {
            throw new Exception("Metodo intermedio", e);
        }
    }

    public static void inferior() throws Exception {
        throw new Exception("Metodo inferior");
    }
}