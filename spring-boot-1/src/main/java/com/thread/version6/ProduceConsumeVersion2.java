package com.thread.version6;

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
		// synchronized (this) {
		synchronized (LOCK) {
			if (isProduce) {
				try {
					System.out.println("生产者==" + i);
					LOCK.wait();// 让produce停止生产，进入等待状态
					// this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				// 开始生产，
				LOCK.notify();
				i++;
				isProduce = true;
			}
		}
	}

	private void consume() {
		synchronized (LOCK) {
			if (isProduce) {
				System.out.println("消费者==" + i);
				LOCK.notify();
				isProduce = false;
			} else {
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		ProduceConsumeVersion2 produceConsumeVersion2 = new ProduceConsumeVersion2();
		new Thread("produce") {
			@Override
			public void run() {
				while (true) {
					produceConsumeVersion2.produce();

				}
			}
		}.start();
		new Thread("consume") {
			@Override
			public void run() {
				while (true) {
					produceConsumeVersion2.consume();
				}
			}
		}.start();
	}

}
