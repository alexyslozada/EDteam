class While {
    public static void main(String[] args) {
        

        // while (expresión booleana) {
        //    sentencia
        //}
        // break
        // continue

        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
            if (i == 5) {
                break;
            }
        }

        // System.out.println("i termina valiendo: " + i);
    }
}