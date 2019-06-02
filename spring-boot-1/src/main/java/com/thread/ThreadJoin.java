package com.thread;

import java.util.stream.IntStream;

public class ThreadJoin {

	
	public static void main(String[] args) throws Exception {
		//t1线程
		
		Thread t1 = new Thread(()->{
			IntStream.range(1, 100).forEach(i->System.out.println(Thread.currentThread().getName()+"==="+i));
			
		}) ;
		Thread t2 = new Thread(()->{
			IntStream.range(1, 100).forEach(i->System.out.println(Thread.currentThread().getName()+"==="+i));
			
		}) ;

		t1.start();
		t1.join();
		
		t2.start();
		//main主线程
		IntStream.range(1, 100).forEach(i->System.out.println(Thread.currentThread().getName()+"==="+i));
		
		
	}
}
