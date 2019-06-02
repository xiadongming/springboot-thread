package com.thread.version8;

import java.util.stream.Stream;

public class ProduceConsumeVersion2 {
	/**
	 * 生产一个，消费一个
	 */
	private int i = 0;
	private final Object LOCK = new Object();
	private volatile Boolean isProduce = false;
	private int NUM = 1000;

	private void produce() {
		/**
		 * 将LOCK换成this，也可，lock只是起到同一把锁的竞争作用 LOCK.wait();this.wait();也可，起到线程等待的作用
		 */
		synchronized (LOCK) {
			while (isProduce) {
				try {
					LOCK.wait();// 让produce停止生产，进入等待状态
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			// 开始生产，
			System.out.println("生产者==" + i);
			LOCK.notifyAll();
			i++;
			isProduce = true;
		}
	}

	private void consume() {
		synchronized (LOCK) {
			while (!isProduce) {
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			System.out.println("消费者==" + i);
			LOCK.notifyAll();
			isProduce = false;
		}
	}

	public static void main(String[] args) {
		ProduceConsumeVersion2 produceConsumeVersion2 = new ProduceConsumeVersion2();
		
		Stream.of("p1","p2").forEach(n->
		new Thread("produce") {
			@Override
			public void run() {
				while (true) {
					produceConsumeVersion2.produce();

				}
			}
		}.start()
		);
		
		Stream.of("c1","c2").forEach(n->
		new Thread("consume") {
			@Override
			public void run() {
				while (true) {
					produceConsumeVersion2.consume();
				}
			}
		}.start()
		);
	}

}
