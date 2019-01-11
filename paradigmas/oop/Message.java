class Message {
    public void showMainMenu() {
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

    public void showProducts(Storage s) {
        System.out.println("*************************************************");
        System.out.println("*          PRODUCTOS DEL INVENTARIO             *");
        System.out.println("* --------------------------------------------- *");
        for (int i = 0; i < s.getProducts().length; i++) {
            System.out.println("* " + i + ". " + s.getProducts()[i].getName());
        }
        System.out.println("*************************************************");
    }

    public void showReport(Storage s) {
        System.out.println("*****************************************************************");
        System.out.println("*             INFORME DE INVENTARIO                             *");
        System.out.println("* ------------------------------------------------------------- *");
        System.out.println("* PRODUCTO\t| CANTIDAD\t| PRECIO\t| TOTAL\t\t*");
        for (int i = 0; i < s.getProducts().length; i++) {
            System.out.println("* " + s.getProducts()[i].getName() + "\t\t| " + s.getProducts()[i].getQuantity() + "\t\t| " + s.getProducts()[i].getPrice() + "\t\t| " + (s.getProducts()[i].getPrice() * s.getProducts()[i].getQuantity()) + "\t\t*");
        }
        System.out.println("*****************************************************************");
    }
}