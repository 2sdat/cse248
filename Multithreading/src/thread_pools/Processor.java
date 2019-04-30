package thread_pools;

public class Processor extends Thread{
	@Override
	public void run() {
		try {
			System.out.println("Starting thread: " + this.getName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing thread: " + this.getName());
	}
}
