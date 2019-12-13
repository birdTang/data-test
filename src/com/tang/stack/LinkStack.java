package com.tang.stack;

/**
 * 基于链表实现的栈
 * 后进先出，就是插入链表头结点，删除链表头结点
 * @ate 2018年10月13日
 * @author Administrator
 */
public class LinkStack {

	private Node top = null;
	
	/**
	 * 
	 * @date 2019年12月13日
	 * @author tangp
	 * @param value
	 * @return
	 */
	public boolean push(String value) {
		Node newNode = new Node(value, null);
		
		//栈空 ,可以不用判断
		if(top==null) {
			top = newNode;
			return true;
		}
		
		newNode.next = top;
		top = newNode;
		return true;
	}
	
	public String pop() {
		//栈空
		if (top==null) return null;
		String data = top.data;
		top = top.next;
		return data;
		
	}
	
	public void printAll() {
	    Node p = top;
	    while (p != null) {
	      System.out.print(p.data + " ");
	      p = p.next;
	    }
	    System.out.println();
	  }
	
	public static class Node {
		private String data;
		private Node next;
		public Node(String data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
	
	
	public static void main(String[] args) {
		LinkStack stack = new LinkStack();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");

		stack.pop();
		stack.printAll();
	}
}
