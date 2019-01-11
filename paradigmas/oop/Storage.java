class Storage {
    private Product[] products;

    public Storage() {
        products = new Product[3];
        products[0] = new Product("PAPA", 0, 0);
        products[1] = new Product("ARROZ", 0, 0);
        products[2] = new Product("CARNE", 0, 0);
    }

    public void buyProduct(int i, int q, float p) {
        products[i].addQuantity(q);
        products[i].setPrice(p);
    }

    public void saleProduct(int i, int q) {
        products[i].removeQuantity(q);
        System.out.println("Valor vendido: " + products[i].getPrice() * q * 1.25);
    }

    public Product[] getProducts() {
        return this.products;
    }
 }