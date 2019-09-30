class CondicionalesDos {
    public static void main(String[] args) {
        
        int dia = 4;

        switch (dia) {
            case 1:
                // puede tener varias líneas
                System.out.println("lunes");
                break;
            case 2:
                System.out.println("martes");
                break;
            case 3:
                System.out.println("miercoles");
                break;
            case 4:
                System.out.println("jueves");
                break;
            case 5:
                System.out.println("viernes");
                break;
            case 6:
                System.out.println("sabado");
                break;
            case 7:
                System.out.println("domingo");
                break;
            default:
                System.out.println("día no válido");
        }
    }
}