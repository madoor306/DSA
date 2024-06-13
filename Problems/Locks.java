import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Locks {

	public static void main(String[] args) {
		Resource newR = new Resource();

		Thread[] th = new Thread[10];
		for(int i=0; i<5; i++) {
			th[i] = new Thread(new ReadJob(newR), "Thread "+i);
		}

		for(int i=5; i<10; i++) {
			th[i] = new Thread(new DisplayJob(newR), "Thread "+i);
		}

		for(Thread t : th) {
			t.start();
		}
	}
}

class Resource {

	final Lock readLock = new ReentrantLock();
	final Lock displayLock = new ReentrantLock();
	
	public void read(Object document) {
		final Lock readLock = this.readLock;
		readLock.lock();

		try {
			for(int i=0; i<3; i++) {
				System.out.println(" Executing  Read Thread -> " + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch(Exception e) {
			System.out.println(" Thread Read Interrupted Exception " + e);
		} finally {
			readLock.unlock();
		}
	}

	public void display(Object document) {
		final Lock displayLock = this.displayLock;
		displayLock.lock();

		try {
			for(int i=0; i<3; i++) {
				System.out.println(" Executing Display Thread -> " + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch(Exception e) {
			System.out.println(" Thread Display Interrupted Exception " + e);
		} finally {
			displayLock.unlock();
		}
	}
}

class ReadJob implements Runnable {

	Resource r;

	ReadJob(Resource varR) {
		this.r = varR;
	}

	@Override
	public void run() {
		this.r.read(new Object());
	}
}

class DisplayJob implements Runnable {

	Resource r;

	DisplayJob(Resource varR) {
		this.r = varR;
	}

	@Override
	public void run() {
		this.r.display(new Object());
	}
}