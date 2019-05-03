
public class Main {

	public static void main(String[] args) {
        
        Port port = new Port();
        Ship ship = new Ship(port);
        Truck truck = new Truck(port);
        new Thread(ship).start();
        new Thread(truck).start();
    }
}
