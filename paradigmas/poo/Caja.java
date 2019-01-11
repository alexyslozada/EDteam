import java.util.Scanner;

class Caja {
    Scanner teclado;
    Storage storage;
    Messages messages;
     
    public Caja() {
        init();
        showApp();
    }

    public void init() {
        teclado = new Scanner(System.in);
        storage = new Storage();
        messages = new Messages();
    }

    public void showApp() {
        int opcion = 0;
        while (opcion < 1 || opcion > 4) {
            messages.showMainMenu();
            opcion = teclado.nextInt();
            int opcionDetalle = -1;
            int q = 0;
            float p = 0;
            switch (opcion) {
                case 1:
                    messages.showProducts(storage);
                    opcionDetalle = teclado.nextInt();
                    if (opcionDetalle < 0 || opcionDetalle > storage.getProducts().length - 1) {
                        System.out.println("la opción no es válida");
                        break;
                    }
                    System.out.print("Cantidad: ");
                    q = teclado.nextInt();
                    System.out.print("Precio: ");
                    p = teclado.nextFloat();
                    storage.buyProduct(opcionDetalle, q, p);
                    break;
                case 2:
                    messages.showProducts(storage);
                    opcionDetalle = teclado.nextInt();
                    if (opcionDetalle < 0 || opcionDetalle > storage.getProducts().length - 1) {
                        System.out.println("la opción no es válida");
                        break;
                    }
                    System.out.print("Cantidad: ");
                    q = teclado.nextInt();
                    storage.saleProduct(opcionDetalle, q);
                    break;
                case 3:
                    messages.showReport(storage);
                    System.out.print("Presione 0 para continuar...");
                    q = teclado.nextInt();
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
}
