class Product {
    private String name;
    private int quantity;
    private float price;

    public Product(){}

    public Product(String n, int q, float p) {
        this.name = n;
        this.quantity = q;
        this.price = p;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public void setPrice(float p) {
        this.price = p;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public float getPrice() {
        return this.price;
    }

    public void addQuantity(int q) {
        this.quantity += q;
    }

    public void delQuantity(int q) {
        this.quantity -= q;
    }
}