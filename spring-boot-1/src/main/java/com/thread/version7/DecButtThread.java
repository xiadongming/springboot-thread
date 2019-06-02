package com.thread.version7;

public class DecButtThread extends Thread {

	@Override
	public void run() {

		SingleButtle singleButtle = SingleButtle.getInstance();

		while (true) {

			if (singleButtle.getNum() <= 1) {
				break;
			}
			singleButtle.setNum(singleButtle.getNum() - 1);

			System.out.println(singleButtle.getNum());
		}

	}
}
