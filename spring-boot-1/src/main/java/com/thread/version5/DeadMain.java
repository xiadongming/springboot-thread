package com.thread.version5;

public class DeadMain {
	public static void main(String[] args) {
		/**
		 * 多綫程死锁的原因是，第一条线程拿着锁1，想要获取锁2，第二条线程拿着锁2，想要获取锁1，造成死循环
		 * */
		OtherService otherService = new OtherService();
		DeadLock deadLock = new DeadLock(otherService);
		otherService.setDeadLock(deadLock);
		new Thread() {
			@Override
			public void run() {
               while(true) {
            	   deadLock.m1();
               }
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
             while(true) {
            	 otherService.s2();
             }
			}
		}.start();
	}
}
