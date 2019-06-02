package com.thread;

public class OneMain {
	public static void main(String[] args) {
		
		ExtendThread t1 = new ExtendThread();
		ExtendThread t2 = new ExtendThread();
		ExtendThread t3 = new ExtendThread();
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
