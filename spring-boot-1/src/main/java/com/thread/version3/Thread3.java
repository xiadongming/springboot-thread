package com.thread.version3;


public class Thread3 {
	public static void main(String[] args) {

		//this代表正在执行的类thislock
		ThisLock thisLock = new ThisLock();
		new Thread("t1") {
			@Override
			public void run() {
				thisLock.m1();
			}
		}.start();
		
		new Thread("t2") {
			@Override
			public void run() {
             thisLock.m2();
			}
		}.start();
		
	}
}
