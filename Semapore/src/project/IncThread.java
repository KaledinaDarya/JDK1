package project;

import java.util.concurrent.Semaphore;

public class IncThread implements Runnable {

	String name;
    Semaphore sem;
 
    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }
 
    public void run() {
        System.out.println("������ ������ " + name);
        try {
            // ������� �������� ����������
            System.out.println("����� " + name + " ������� ����������");
            sem.acquire();
            System.out.println("����� " + name + " �������� ����������");
 
            // � ������ �������� ������ � ������ �������
 
            for(int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
 
                // ���������, ���� ��������, ������������ ���������
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
 
        // ���������� ����������
        System.out.println("����� " + name + " ����������� ����������");
        sem.release();
    }
}
