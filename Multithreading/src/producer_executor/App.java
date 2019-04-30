package producer_executor;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
	
	private static BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			try {
				producer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void producer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			Integer value = random.nextInt();
			q.put(value);
			System.out.println("Produced value: " + value + "| queue size: " + q.size());
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			Thread.sleep(100);
			if (random.nextInt(10) == 0) {
				Integer value = q.take();
				System.out.println("Taken value: " + value + "| queue size: " + q.size());
			}
		}
	}

}
