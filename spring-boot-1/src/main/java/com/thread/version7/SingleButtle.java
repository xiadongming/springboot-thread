package com.thread.version7;

public class SingleButtle {

	private Integer num = 30;

	public static final SingleButtle buttle = new SingleButtle();

	public static SingleButtle getInstance() {

		return buttle;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
