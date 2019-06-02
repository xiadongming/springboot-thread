package com.thread.version6;

public class ProduceConsumeVersion1 {
	
	/**
	 * 这种是不行的，生产者一直生产，消费者一直消费，二者没有联系()在本案例中
	 * */
	private int i = 1;
	
	private final Object obj = new Object();
	
	
	private void produce() {
		synchronized (obj) {
			System.out.println("生产者=="+i++);
		}
	}
	
	private void consume() {
		synchronized (obj) {
		System.out.println("消费者=="+i);	
		}
	}
	public static void main(String[] args) {
		ProduceConsumeVersion1 produceConsumeVersion1 = new ProduceConsumeVersion1();
		new Thread("produce") {
			@Override
			public void run() {
             while(true) {
            	 produceConsumeVersion1.produce();
             }
			}
		}.start();
		new Thread("consume") {
			@Override
			public void run() {
	         while(true) {
	        	 produceConsumeVersion1.consume();
	         }
			}
		}.start();
	}

}
