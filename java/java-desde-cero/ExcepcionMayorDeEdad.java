public class ExcepcionMayorDeEdad extends RuntimeException {

    public ExcepcionMayorDeEdad(String str) {
        super(str + " no eres mayor de edad");
    }

    public ExcepcionMayorDeEdad() {
        this("lo lamento, no puedes entrar porque");
    }
}