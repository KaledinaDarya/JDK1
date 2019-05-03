
public class Truck implements Runnable{

	public Port port;
	
	public Truck(Port port){
		this.port = port;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			port.get();
		}
	}
}
