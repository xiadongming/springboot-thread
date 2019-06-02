package com.thread.version5;

public class DeadLock {
	
	private OtherService otherService;

	private final Object LOCK = new Object();

	public DeadLock(OtherService otherService) {
		this.otherService = otherService;
	}
	/**
	 * m1和m2处于竞争锁的状态，抢占LOCK同一把锁
	 * */

	public void m1() {
		synchronized (LOCK) {
			System.out.println("m1========");
			otherService.s1();
		}
	}

	public void m2() {
		synchronized (LOCK) {
			System.out.println("m2========");
		}
	}
}
