public class Ship implements Runnable{

	public Port port;
	
	public Ship(Port port){
		this.port = port;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 6; i++) {
			port.put();
		}
	}
}
