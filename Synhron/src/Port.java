
public class Port {

	private int box = 0;
	
	public synchronized void get() {
	      while (box < 1) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) {
	         }
	      }
	      box--;
	      System.out.println("Грузовик забрал 1 коробку");
	      System.out.println("Коробок в порту: " + box);
	      notify();
	   }
	
	   public synchronized void put() {
	       while (box >= 3) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) { 
	         } 
	       }
	       box++;
	       System.out.println("Корабль разгрузил 1 коробку в порт");
	       System.out.println("Коробок в порту: " + box);
	       notify();
	   }
	
}
