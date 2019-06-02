package com.thread.version2;

public class TicketWindows implements Runnable {
	private int index = 1;
	private final static int MAX = 300;
	@Override
	public synchronized void run() {
		while (true) {
			if (index > MAX) {
				break;
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "的号码是==" + index++);
		}
	}
}
