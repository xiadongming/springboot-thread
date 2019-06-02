package com.thread;

public class TwoMain {
	public static void main(String[] args) {
		ImplementRunnable implementRunnable = new ImplementRunnable();
		Thread t1 = new Thread(implementRunnable);
		Thread t2 = new Thread(implementRunnable);
		Thread t3 = new Thread(implementRunnable);
		t1.setDaemon(true);
		t1.start();
		t2.start();
		t3.start();
		
		
		System.out.println("=="+t1.getPriority());
		System.out.println("=="+t2.getPriority());
		System.out.println("=="+t3.getPriority());
		
	}

}
