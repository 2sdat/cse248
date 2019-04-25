package synchronized_block;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Worker {
	private Random random = new Random();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	private List<Integer> list1 = new LinkedList<Integer>();
	private List<Integer> list2 = new LinkedList<Integer>();
	
	public void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (lock1) {
			list1.add(random.nextInt(100));
		}
	}
	
	public void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (lock2) {
			list2.add(random.nextInt(100));
		}
	}
	
	public void process() {
		for(int i = 0; i < 5000; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main() {
		System.out.println("Starting...");
		Thread t1 = new Thread(() -> {process();});
		Thread t2 = new Thread(() -> {process();});
		
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
			System.out.println("Time elapsed: " + (System.currentTimeMillis()-start));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("List 1: " + list1.size() + "\tList 2: " + list2.size());
	}
}
