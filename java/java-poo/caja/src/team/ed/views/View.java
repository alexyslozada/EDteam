package team.ed.views;

import team.ed.objects.Product;

import java.util.List;
import java.util.Scanner;

public class View {
    public static void showHeaderPrincipal() {
        System.out.println("\t\t**************************************");
        System.out.println("\t\t* BIENVENIDOS A LA CAJA REGISTRADORA *");
        System.out.println("\t\t**************************************");
    }

    public static void showMenuPrincipal() {
        System.out.println("\t\t\t 1. Comprar");
        System.out.println("\t\t\t 2. Vender");
        System.out.println("\t\t\t 3. Inventario");
        System.out.println("\t\t\t 4. Compras");
        System.out.println("\t\t\t 5. Ventas");
        System.out.println("\t\t\t 6. Salir");
    }

    public static void showGetOption() {
        System.out.print("\t\tDigite la opción: ");
    }

    public static void showGetAmount() {
        System.out.print("\t\tDigite la cantidad: ");
    }

    public static void showGetPrice() {
        System.out.print("\t\tDigite el precio: ");
    }

    public static int getOption() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    public static int getAmount() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    public static double getPrice() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    public static void showBuyHeader() {
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*            MENU DE COMPRAS         *");
        System.out.println("\t\t**************************************");
        showItemsMenu();
    }

    public static void showSaleHeader() {
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*            MENU DE VENTAS          *");
        System.out.println("\t\t**************************************");
        showItemsMenu();
    }

    public static void showStockHeader() {
        System.out.println("\t\t*****************************************************");
        System.out.println("\t\t*               I N V E N T A R I O                 *");
        System.out.println("\t\t*****************************************************");
        showItemsHeader();
    }

    public static void showItemsHeader() {
        System.out.println("\t\t-----------------------------------------------------");
        System.out.println("\t\t* PRODUCTO\t| Cantidad\t| Vr Unitario\t| Vr Total\t*");
        System.out.println("\t\t-----------------------------------------------------");
    }

    public static void showBuyListHeader() {
        System.out.println("\t\t*****************************************************");
        System.out.println("\t\t*                C O M P R A S                      *");
        System.out.println("\t\t*****************************************************");
        showItemsHeader();
    }

    public static void showSaleListHeader() {
        System.out.println("\t\t*****************************************************");
        System.out.println("\t\t*                  V E N T A S                      *");
        System.out.println("\t\t*****************************************************");
        showItemsHeader();
    }

    public static void showItemsMenu() {
        System.out.println("\t\t\t1. Papa");
        System.out.println("\t\t\t2. Arroz");
        System.out.println("\t\t\t3. Carne");
        System.out.println("\t\t\t4. Volver");
    }

    public static void showThanks() {
        System.out.println("Gracias por utilizar nuestra primer APP!!!");

    }
    public static void showInvalidOption() {
        System.out.println("Opción no válida!!!");
    }

    public static void showGetBack(String name) {
        System.out.println("\t\t\tSaliendo del módulo " + name);
    }

    public static void showAnyKey() {
        System.out.print("Digite cualquier número para continuar: ");
    }

    public static void showItemsStock(Product[] products) {
        for (Product v : products) {
            System.out.println("\t\t* "+v.getName()+"\t| "+v.getAmount()+"\t\t| "+v.getPrice()+"\t\t\t| "+v.getAmount()*v.getPrice()+"\t\t*");
        }
    }

    public static void showInvalidAmount() {
        System.out.println("La cantidad no es válida");
    }

    public static void showPurchases(List<Product> listado) {
        for(Product v : listado) {
            System.out.println("\t\t* "+v.getName()+"\t| "+v.getAmount()+"\t\t| "+v.getPrice()+"\t\t\t| "+v.getAmount()*v.getPrice()+"\t\t*");
        }
    }

    public static void showSales(List<Product> listado) {
        for(Product v : listado) {
            System.out.println("\t\t* "+v.getName()+"\t| "+v.getAmount()+"\t\t| "+v.getPrice()+"\t\t\t| "+v.getAmount()*v.getPrice()*1.25+"\t\t*");
        }
    }

}
