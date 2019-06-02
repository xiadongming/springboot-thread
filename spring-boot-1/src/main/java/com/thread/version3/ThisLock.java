package com.thread.version3;

public class ThisLock {
	
	private final Object obj = new Object();
	
	public  void m1() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(this);
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	public  void m2() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(10_000);
				System.out.println(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
}
