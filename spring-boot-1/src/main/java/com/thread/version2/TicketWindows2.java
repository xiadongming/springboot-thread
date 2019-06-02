package com.thread.version2;

public class TicketWindows2 implements Runnable {

	private int index = 1;

	private final static int MAX = 300;

	@Override
	public  void run() {
        while(true) {
		if(ticlet()) {
			break;
		}
        }

	}
	 public synchronized Boolean ticlet() {
		 if(index>MAX) {
			 return true;
		 }
		 try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 System.out.println(Thread.currentThread() + "的号码是==" + index++);
		 
		 return false;
	 }
}
