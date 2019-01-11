class Messages {
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
        Product[] products = s.getProducts();
        for (int i = 0; i < products.length; i++) {
            System.out.println("* " + i + ". " + products[i].getName());
        }
        System.out.println("*************************************************");
    }

    public void showReport(Storage s) {
        System.out.println("*****************************************************************");
        System.out.println("*             INFORME DE INVENTARIO                             *");
        System.out.println("* ------------------------------------------------------------- *");
        System.out.println("* PRODUCTO\t| CANTIDAD\t| PRECIO\t| TOTAL\t\t*");
        Product[] products = s.getProducts();
        for (int i = 0; i < products.length; i++) {
            System.out.println("* " + products[i].getName() + "\t\t| " + products[i].getQuantity() + "\t\t| " + products[i].getPrice() + "\t\t| " + (products[i].getQuantity() * products[i].getPrice()) + "\t\t*");
        }
        System.out.println("*****************************************************************");
    }
}