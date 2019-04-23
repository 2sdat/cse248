package multithreading_3;

public class Demo {
	public static int number = 0;
	
	public static void main(String[] args) {
		
		//Anonymous Class
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 1");
				for (int i = 0; i < 5000; i++) {
					System.out.println("Hello " + i);
					number++;
				}
			}
		});
		
		//Lambda Expression
		Thread thread2 = new Thread(() -> {
			System.out.println("Thread 2");
			for (int i = 0; i < 5000; i++) {
				number++;
				System.out.println("Hello " + i);
			}
		});
		
		//Start first thread
		thread1.start();
		
		//Start second thread
		thread2.start();
		
		try {
			//Pause main thread until threads completes
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("Done! Number = " + number);
	}
	
}
