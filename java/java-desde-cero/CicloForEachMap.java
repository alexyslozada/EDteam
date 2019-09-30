import java.util.Map;
import java.util.HashMap;

class CicloForEachMap {
    public static void main(String[] args) {
        
        Map<Integer, String> nombres = new HashMap<>();
        nombres.put(28, "Alvaro");
        nombres.put(15, "Beto");
        nombres.put(33, "Mircha");
        nombres.put(15, "Alexys");
        nombres.put(39, "Alejo1");
        nombres.put(41, "Alejo2");

        nombres.forEach((id, name) -> {
            System.out.println("ID: "+ id + " Nombre: " + name);
        });
    }
}