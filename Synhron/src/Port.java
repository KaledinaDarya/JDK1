
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
	      System.out.println("�������� ������ 1 �������");
	      System.out.println("������� � �����: " + box);
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
	       System.out.println("������� ��������� 1 ������� � ����");
	       System.out.println("������� � �����: " + box);
	       notify();
	   }
	
}
