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
        System.out.println("«апуск потока " + name);
        try {
            // сначала получить разрешение
            System.out.println("ѕоток " + name + " ожидает разрешени€");
            sem.acquire();
            System.out.println("ѕоток " + name + " получает разрешение");
 
            // а теперь получить доступ к общему ресурсу
 
            for(int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
 
                // –азрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
 
        // освободить разрешение
        System.out.println("ѕоток " + name + " освобождает разрешение");
        sem.release();
    }
}
