package com.thread.version1;

public class TicketWindows implements Runnable {
	private int index = 1;
	private final static int MAX = 300;
	private final Object obj = new Object();
	@Override
	public void run() {
		while (true) {
			synchronized (obj) {
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
}
