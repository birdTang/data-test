package com.tang.queue;

/**
 * 基于链表的队列  --链式队列
 * @ate 2018年10月26日
 * @author Administrator
 */
public class LinkQueue {

	private Node head = null;
	private Node tail = null;
	
	//入队
	public boolean enqueue(String value) {
		
		if(tail==null) {
			Node newnode = new Node(value, null);
			head = newnode;
			tail = newnode;
		}else {
			tail.next = new Node(value, null);
			tail = tail.next;
		}
		
		return true;
	}
	
	//出队
	public String dequeue() {
		if (head==null) {
			return null;
		}
		String value = head.data;
		head = head.next;
		if (head==null) {
			tail = null;
		}
		return value;
	}
	
	static class Node {
		private String data;
		private Node next;
		
		 public Node(String data, Node next) {
		      this.data = data;
		      this.next = next;
		    }
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}
}
