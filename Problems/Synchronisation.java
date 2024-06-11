import java.util.*;
import java.lang.*;

class Line {
	
	synchronized public void getLine() {

		for(int i=0; i<3; i++) {

			System.out.println("Test --> " + i);

			try {

				Thread.sleep(400);

			} catch( Exception e) {
				System.out.println(" Thread InterruptedException "+ e);
			}

		}
	}
}

class LineThread extends Thread {

	Line line;

	LineThread(Line l) {

		this.line = l;

	}

	@Override
	public void run() {

		line.getLine();

	}

}

class Synchronisation {

	public static void main(String[] args) {
		Line line = new Line();

		Thread lineThread1 = new LineThread(line);
		Thread lineThread2 = new LineThread(line);

		lineThread1.start();
		lineThread2.start();

	}
}