// Producto Concreto
public class SportMotorbike implements Motorbike {

    @Override
    public String getType() {
        return "Sport!";
    }

    @Override
    public int getWheels() {
        return 2;
    }

    @Override
    public int getSeats() {
        return 1;
    }
}