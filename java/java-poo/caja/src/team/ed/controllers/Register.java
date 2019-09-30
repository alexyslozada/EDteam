package team.ed.controllers;

import team.ed.objects.Meat;
import team.ed.objects.Potato;
import team.ed.objects.Product;
import team.ed.objects.Rice;
import team.ed.storage.Database;
import team.ed.views.View;

import java.util.List;

public class Register {
    private Database database;

    public Register(){
        database = new Database();
    }

    // register inicia el proceso de la registradora
    public void register() {
        int option;
        do {
            View.showHeaderPrincipal();
            View.showMenuPrincipal();
            View.showGetOption();
            option = View.getOption();
            switch (option) {
                case 1:
                    buy();
                    break;
                case 2:
                    sale();
                    break;
                case 3:
                    showStock();
                    break;
                case 4:
                    showPurchases();
                    break;
                case 5:
                    showSales();
                    break;
                case 6:
                    View.showThanks();
                    System.exit(0);
                    break;
                default:
                    View.showInvalidOption();
            }
        } while(option >= 1 && option <= 6);
    }

    // buy se encargará de mostrar el menú de compras
    // y obtener la opción deseada por el usuario
    private void buy() {
        View.showBuyHeader();
        int option;
        do {
            View.showGetOption();
            option = View.getOption();
            if (option >= 1 && option <=3) {
                buyProduct(option);
            } else if (option == 4) {
                View.showGetBack("Compras");
                return;
            } else {
                View.showInvalidOption();
            }
       } while (option < 1 || option > 4);
    }

    // buyProduct registra en la base de datos
    // el producto comprado
    private void buyProduct(int option) {
        Product product = null;
        switch (option) {
            case 1:
                product = new Potato("Sabanera");
                break;
            case 2:
                product = new Rice("Una marca");
                break;
            case 3:
                product = new Meat("Lomo fino");
                break;
            default:
                View.showInvalidOption();
        }
        View.showGetAmount();
        int amount = View.getAmount();
        View.showGetPrice();
        double price = View.getPrice();

        product.setAmount(amount);
        product.setPrice(price);
        database.buy(product);
    }

    private void showStock() {
        View.showStockHeader();
        View.showItemsStock(database.getAll());
        View.showAnyKey();
        View.getOption();
    }

    // sale se encargará de mostrar el menú de ventas
    // y obtener la opción deseada por el usuario
    private void sale() {
        View.showSaleHeader();
        int option;
        do {
            View.showGetOption();
            option = View.getOption();
            if (option >= 1 && option <=3) {
                saleProduct(option);
            } else if (option == 4) {
                View.showGetBack("Ventas");
                return;
            } else {
                View.showInvalidOption();
            }
        } while (option < 1 || option > 4);
    }

    // saleProduct registra en la base de datos
    // el producto comprado
    private void saleProduct(int option) {
        Product product = null;
        if (option < 1 || option > 3) {
            View.showInvalidOption();
            return;
        }

        product = database.getByIndex(option - 1);
        View.showGetAmount();
        int amount = View.getAmount();
        if (product.getAmount() < amount) {
            View.showInvalidAmount();
            return;
        }

        product.setAmount(amount);
        database.sale(product);
    }

    private void showPurchases() {
        List<Product> listado = database.getPurchases();
        View.showBuyListHeader();
        View.showPurchases(listado);
    }

    private void showSales() {
        List<Product> listado = database.getSales();
        View.showSaleListHeader();
        View.showSales(listado);
    }

}
