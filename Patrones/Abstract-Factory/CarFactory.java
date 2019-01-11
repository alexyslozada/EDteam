public class CarFactory extends VehicleAbstractFactory {
    public final int LUXURY = 1;
    public final int FAMILY = 2;

    @Override
    public Vehicle getVehicle(int t) {
        switch (t) {
            case LUXURY:
                return new LuxuryCar();
            case FAMILY:
                return new FamilyCar();
        }
        return null;
    }
}