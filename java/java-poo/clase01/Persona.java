class Persona {
    // Atributos
    private String nombre;
    private int edad;
    private float peso;
    private float estatura;

    // Constructores
    public Persona() {
        // Sirve para inicializar los valores por defecto
        // de un objeto instanciado
        this.nombre = "";
        this.edad = 0;
        this.peso = 0f;
        this.estatura = 0f;
    }

    // Segundo constructor
    // sobrecarga: escribir un método con el mismo nombre
    // pero con diferente firma
    public Persona(String n) {
        this.nombre = n;
        this.saludar();
    }

    // Tercer constructor
    public Persona(String n, int e) {
        this.nombre = n;
        this.edad = e;
    }

    // Getter y Setter
    // Get obtener valores
    // Set asignar valores

    // Métodos
    void setNombre(String n) {
        this.nombre = n;
    }

    String getNombre() {
        return this.nombre;
    }

    void setEdad(int e) {
        if (e < 0 || e > 150) {
            System.out.println("La edad no es válida");
        } else {
            this.edad = e;
        }
    }

    int getEdad() {
        return this.edad;
    }

    void saludar() {
        System.out.println("hola, mi nombre es: " + this.nombre);
    }
}