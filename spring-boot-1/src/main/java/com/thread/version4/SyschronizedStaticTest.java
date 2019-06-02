package com.thread.version4;

public class SyschronizedStaticTest {

	public static void main(String[] args) {

	//	SyschronizedStatic syschronizedStatic = new SyschronizedStatic();
		
		new Thread("t1") {
			@Override
			public void run() {
				SyschronizedStatic.m1();
			}
		}.start();

		new Thread("t2") {
			@Override
			public void run() {
				SyschronizedStatic.m2();
			}
		}.start();
		new Thread("t3") {
			@Override
			public void run() {
				SyschronizedStatic.m3();
			}
		}.start();
	}

}
