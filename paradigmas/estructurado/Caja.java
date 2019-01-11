import java.util.Scanner;

class Caja {
    static Scanner teclado = new Scanner(System.in);
    static String[] names = new String[3];
    static int[] quantities = new int[3];
    static float[] prices = new float[3];

    public static void main(String ...args) {
        loadProducts();
        int opcion = 0;
        while (opcion < 1 || opcion > 4) {
            showMainMenu();
            opcion = teclado.nextInt();
            int opcionDetalle = -1;
            int c = 0;
            switch (opcion) {
                case 1:
                    showProducts();
                    opcionDetalle = teclado.nextInt();
                    if (opcionDetalle < 0 || opcionDetalle > names.length - 1) {
                        System.out.println("la opción no es válida");
                        break;
                    }
                    System.out.print("Cantidad: ");
                    c = teclado.nextInt();
                    quantities[opcionDetalle] += c;
                    System.out.print("Precio: ");
                    c = teclado.nextInt();
                    prices[opcionDetalle] = c;
                    break;
                case 2:
                    showProducts();
                    opcionDetalle = teclado.nextInt();
                    if (opcionDetalle < 0 || opcionDetalle > names.length - 1) {
                        System.out.println("la opción no es válida");
                        break;
                    }
                    System.out.print("Cantidad: ");
                    c = teclado.nextInt();
                    System.out.println("Valor a recibir: " + c * prices[opcionDetalle] * 1.25);
                    quantities[opcionDetalle] -= c;
                    break;
                case 3:
                    showReport();
                    System.out.print("Presione 0 para continuar...");
                    c = teclado.nextInt();
                    break;
                case 4:
                    System.exit(1);
                    break;
                default:
                    System.out.println("La opción digitada no es válida!");
            }
            opcion = 0;
        }
    }

    static void loadProducts() {
        names[0] = "PAPA";
        names[1] = "ARROZ";
        names[2] = "CARNE";
        quantities[0] = 0;
        quantities[1] = 0;
        quantities[2] = 0;
        prices[0] = 0;
        prices[1] = 0;
        prices[2] = 0;
    }

    static void showMainMenu() {
        System.out.println("**************************");
        System.out.println("* BIENVENIDOS AL SISTEMA *");
        System.out.println("* ---------------------- *");
        System.out.println("*                        *");
        System.out.println("* 1. Comprar             *");
        System.out.println("* 2. Vender              *");
        System.out.println("* 3. Informes            *");
        System.out.println("* 4. Salir               *");
        System.out.println("*                        *");
        System.out.println("**************************");
    }

    static void showReport() {
        System.out.println("*****************************************************************");
        System.out.println("*             INFORME DE INVENTARIO                             *");
        System.out.println("* ------------------------------------------------------------- *");
        System.out.println("* PRODUCTO\t| CANTIDAD\t| PRECIO\t| TOTAL\t\t*");
        for (int i = 0; i < 3; i++) {
            System.out.println("* " + names[i] + "\t\t| " + quantities[i] + "\t\t| " + prices[i] + "\t\t| " + (quantities[i] * prices[i]) + "\t\t*");
        }
        System.out.println("*****************************************************************");
    }

    static void showProducts() {
        System.out.println("*************************************************");
        System.out.println("*          PRODUCTOS DEL INVENTARIO             *");
        System.out.println("* --------------------------------------------- *");
        for (int i = 0; i < 3; i++) {
            System.out.println("* " + i + ". " + names[i]);
        }
        System.out.println("*************************************************");
    }
}