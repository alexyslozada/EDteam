class CicloFor {
    public static void main(String[] args) {
        
        // for (inicialización; expresión booleana; incremento) {
            // sentencia
        //}
        // break
        // continue

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i % 2 == 0) {
                // break;
                continue;
            }

            // Aqui hace otro proceso muy largo
            System.out.println("trabajando muy duro:"+i);
        }
    }
}