package com.thread.version2;


public class Thread2 {
	public static void main(String[] args) {

		TicketWindows2 task = new TicketWindows2();
		Thread t1 = new Thread(task, "一号窗口");
		Thread t2 = new Thread(task, "二号窗口");
		Thread t3 = new Thread(task, "三号窗口");
		Thread t4 = new Thread(task, "四号窗口");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
