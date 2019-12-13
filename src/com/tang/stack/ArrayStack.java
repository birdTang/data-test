package com.tang.stack;

/**
 * 基于数组实现的栈
 * @ate 2018年10月13日
 * @author Administrator
 */
public class ArrayStack {

	private String[] items; //数组
	private int count; //栈中数据个数
	private int n; //栈的大小
	public ArrayStack(int n) {
		super();
		this.n = n;
		this.items = new String[n];
		this.count = 0;
	}
	
	//入栈
	public boolean push(String value) {
		//栈满
		if (count==n) {
			return false;
		}
		items[count] = value;
		++count;
		return true;
	}
	
	//出栈
	public String pop() {
		//栈空
		if (count==0) return null;
		String temp = items[count-1];
		--count;		
		return temp;
	}
	
}
