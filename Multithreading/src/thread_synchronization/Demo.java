package thread_synchronization;

import java.util.Scanner;

public class Demo {
	
	private static volatile boolean flag = true;
	
	public static void main(String[] args) {
		Processor p1 = new Processor();
		p1.start();
		
		System.out.println("Press <Enter> to pause");
		Scanner kb = new Scanner(System.in);
		kb.nextLine();
		p1.shutdown();
		kb.close();
	}
	
	private static class Processor extends Thread{
		@Override
		public void run() {
			while (flag) {
				System.out.println("Hello world!");
			}
		}

		public void shutdown() {
			flag = false;
			System.out.println("Stopping...");
		}
	}
}
