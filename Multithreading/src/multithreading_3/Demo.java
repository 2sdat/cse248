package multithreading_3;

public class Demo {
	public static int number = 0;
	
	//Synchronized method
	public static synchronized void increment() {
		number++;
	}
	
	public static void main(String[] args) {
		
		//Anonymous Class
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5000; i++) {
					System.out.println(Thread.currentThread() + ": Hello " + i);
					increment();
				}
			}
		});
		
		thread1.setName("Thread 1");
		
		//Lambda Expression
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				increment();
				System.out.println(Thread.currentThread() + ": Hello " + i);
			}
		});
		
		thread2.setName("Thread 2");
		
		//Start first thread
		thread1.start();
		System.out.println("Started thread " + thread1.getName());
		
		//Start second thread
		thread2.start();
		System.out.println("Started thread " + thread2.getName());
		
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
