package com.thread.version1;

public class ThreadOne1 {
	
	public static void main(String[] args) {
		
		TicketWindows task = new TicketWindows();
		Thread t1 = new Thread(task,"一号窗口");
		Thread t2 = new Thread(task,"二号窗口");
		Thread t3 = new Thread(task,"三号窗口");
		Thread t4 = new Thread(task,"四号窗口");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
