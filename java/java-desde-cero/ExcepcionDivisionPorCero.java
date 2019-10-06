// Las Excepciones nos sirven para controlar errores
// "poco" frecuentes.

/*
Estructura de manejo de excepciones
try {
    // En este bloque se coloca el codigo que puede
    // tener errores en tiempo de ejecucion.
} catch (Exception e) {
    // Aqui es donde manejamos la excepcion
} finally {
    // En este bloque colocaremos lo que 
    // queremos que se ejecute 
    // ocurra o no ocurra una excepcion
}
*/
import java.util.Scanner;

public class ExcepcionDivisionPorCero {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Programa para dividir");
        System.out.println();

        int numerador, denominador, resultado;
        System.out.print("Digite el numerador: ");
        numerador = sc.nextInt();
        System.out.print("Digite el denominador: ");
        denominador = sc.nextInt();

        try {
            resultado = numerador / denominador;
            System.out.println("Resultado: " + resultado);
            // Si hubieran mas lineas, no se ejecutan si ocurre una excepcion.
            // aqui podemos tener otras lineas de codigo.
        } catch (ArithmeticException ae) {
            System.out.println("No se puede dividir por cero");
        } finally {
            System.out.println("Esta linea se ejecuta siempre");
            // Cerrar recursos que se usaron o no se usaron.
        }

        System.out.println("Programa terminado");
    }
}