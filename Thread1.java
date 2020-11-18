package Homework11;

public class Thread1 extends Thread {
	SharedData sharedData;

	public Thread1(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < sharedData.user.length; i++) {
			synchronized (sharedData) {
				System.out.println("User: " + sharedData.user[i]);
				sharedData.notifyAll();
				if (i < sharedData.user.length - 1) {
					try {
						sharedData.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
