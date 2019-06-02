package com.thread;

import java.util.Optional;

public class ThreadDemo {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			for(int i=0;i<100;i++) {
				Optional.of(Thread.currentThread().getName()+"=="+i).ifPresent(System.out::println);;
			}
			
		});
		
		Thread t2 = new Thread(()->{
			for(int i=0;i<100;i++) {
				Optional.of(Thread.currentThread().getName()+"=="+i).ifPresent(System.out::println);;
			}
			
		});
		Thread t3 = new Thread(()->{
			for(int i=0;i<100;i++) {
				Optional.of(Thread.currentThread().getName()+"=="+i).ifPresent(System.out::println);;
			}
			
		});
		t1.setPriority(Thread.MAX_PRIORITY);//最高优先级--10
		t2.setPriority(Thread.NORM_PRIORITY);//一般优先级--5
		t3.setPriority(Thread.NORM_PRIORITY);//最低优先级--1
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
