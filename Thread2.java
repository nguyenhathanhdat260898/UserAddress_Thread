package Homework11;

public class Thread2 extends Thread {
	SharedData sharedData;

	public Thread2(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < sharedData.address.length; i++) {
			synchronized (sharedData) {
				sharedData.notifyAll();
				try {
					sharedData.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Address: " + sharedData.address[i]);
			}
		}
	}
}
