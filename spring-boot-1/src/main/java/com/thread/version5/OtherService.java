package com.thread.version5;

public class OtherService {

	private final Object LOCK = new Object();

	private DeadLock deadLock;

	public void s1() {
		synchronized (LOCK) {
			System.out.println("s1=========s");
		}
	}

	public void s2() {
		synchronized (LOCK) {
			System.out.println("s2=========s");
			deadLock.m2();
		}
	}


	public void setDeadLock(DeadLock deadLock) {
		this.deadLock = deadLock;
	}
}
