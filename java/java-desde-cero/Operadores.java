class Operadores {
    public static void main(String[] args) {
        
        // Asignación =
        // int a = 2;
        // int b;
        // b = 2 + 2 + 3;
        // System.out.println(b);

        // Preincremento
        // int a = 0;
        // ++a;
        // System.out.println(a);

        // Postincremento
        // int b = 0;
        // b++;
        // System.out.println(b);

        // Preincremento vs Postincremento
        // int a = 3;
        // int b = 2;
        
        // Comenzamos con preincremento
        // int c = a * ++b;
        // Línea 24
        // a = 3
        // b = 3
        // c = 9

        // Ahora el postincremento
        // int c = a * b++;
        // a = 3
        // b = ? Primero multiplica y luego aumenta. Termina valiendo 3
        // c = 6
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);

        // Recomendación:
        // Nunca utilicen preincremento o postincremento dentro de una asignación.
        // b++;
        // int c = a * b;
        // O así:
        // ++b;
        // int c = a * b;

        // Operadores aritméticos
        // + - * /
        // Jerarquía:
        // Operador . (POO), operador ()
        // Primero * / (con prioridad de izquierda a derecha)
        // Segundo + - (con prioridad de izquierda a derecha)

        // int o = 3 + 3 * 3 - 3;
        // 3 / 3 * 3
        // (3 + 3) * 3 - 3

        // System.out.println(o);

        // Y O
        // Tabla de verdad
        
        // Tabla de verdad de Y (&&)
        //   A     B     Resultado
        // true   true   true
        // true   false  false
        // false  true   false
        // false  false  false

        int edad = 15;
        boolean ninez = edad <= 11 && edad >=0;
        System.out.println(ninez);

        // Tabla de verdad de O (||)
        //   A     B     Resultado
        // true   true   true
        // true   false  true
        // false  true   true
        // false  false  false
        
        
    }
}