package com.tang.linklist;

/**
 * 单链表的插入\删除\查找操作
 * @ate 2018年10月12日
 * @author Administrator
 */
public class SingleLinkList2 {

	private Node head = null; //头结点
	
	/**
	 * 根据值查找结点
	 * @date 2019年12月12日
	 * @author tangp
	 * @param value
	 * @return
	 */
	public Node findByValue(int value) {
		
		Node p = head;
		if(p!=null && p.data!=value) {
			p = p.next;
		}
		return p;
	}
	
	/**
	 * 根据索引查找
	 * @date 2019年12月12日
	 * @author tangp
	 * @param index
	 * @return
	 */
	public Node findByIndex(int index) {
		Node p = head;
		int pos = 0;
		while(p!=null && pos!=index) {
			p =p.next;
			++pos;
		}
		return p;
	}
	
	/**
	 * 无头结点
	 * 表头插入
	 * @date 2019年12月12日
	 * @author tangp
	 * @param value
	 */
	public void insertToHead(int value) {
		Node newNode = new Node(value, null);
		insertToHead(newNode);
	}
	
	public void insertToHead(Node newNode) {
		if(head==null) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	/**
	 * 尾部插入
	 * @date 2019年12月12日
	 * @author tangp
	 * @param value
	 */
	public void insertTail(int value) {
		Node newNode = new Node(value, null);
		if(head==null) {
			//空链表
			head = newNode;
		}else {
			Node p = head;
			while(p!=null && p.next!=null) {
				p = p.next;
			}
			
			newNode.next = null;
			p.next = newNode;
		}
	}
	
	
	/**
	 * 在某个结点后面插入
	 * @date 2019年12月12日
	 * @author tangp
	 * @param p
	 * @param value
	 */
	public void insertAfter(Node p,int value) {
		Node newNode = new Node(value, null);
		insertAfter(p, newNode);
		
	}
	public void insertAfter(Node p,Node newNode) {
		if(p==null) return;
		newNode.next = p.next;
		p.next = newNode;
	}
	/**
	 * 在某个结点前插入
	 * @date 2019年12月12日
	 * @author tangp
	 * @param p
	 * @param value
	 */
	public void insertBefore(Node p,int value) {
		Node newNode = new Node(value, null);
		if(p==head) {
			insertToHead(newNode);
			return;
		}
		insertBefore(p, newNode);
		
	}
	public void insertBefore(Node p,Node newNode) {
		if(p==null) return;
		
		Node q = head;
		//遍历链表获取p的前一个结点
		while(q!=null && q.next!=p) {
			q = q.next;
		}
		if(q==null) return;
		
		newNode.next = p;
		q.next = newNode;
		
	}
	
	public void deleteByNode(Node p) {
		if(p==null || head==null) return;
		if(p==head) {
			head = head.next;
			return;
		}
		
		Node q = head;
		//遍历结点，查找要删除结点的前一个结点
		while(q!=null && q.next!=p) {
			p = p.next;
		}
		
		if(q==null) return;
		q.next = p.next;
	}
	
	public void deleteByValue(int value) {
		if(head==null) return;
		
		Node p = head; //当前结点
		Node pre = null; //当前结点的前一个结点
		while(p!=null && p.data!=value) {
			p = p.next;
			pre = p;
		}
		
		if(p==null) return;
		if(pre==null) {
			//说明要删除的是首节点
			head = p.next;
			return;
		}else {
			pre.next = p.next;
		}
	}
	
	public void printAll() {
		Node p =head;
		while(p!=null) {
			System.out.println(p.getData());
			p = p.next;
		}
		
		 System.out.println("=================================");
	}
	
	/**
	 * 单链表反转
	 * @date 2019年12月13日
	 * @author tangp
	 * @param list
	 * @return
	 */
	public Node reverse(Node list) {
		Node head = null;
		Node preNode = null;
		Node curNode = list;
		while(curNode!=null) {
			Node next = curNode.next;
			if(next==null) {
				head = curNode;
			}
			curNode.next = preNode;
			preNode = curNode;
			curNode = next;
		}
		
		return head;
	} 
	
	/**
	 * 早一步，快2步，相遇即是圆
	 * @date 2019年12月13日
	 * @author tangp
	 * @param list
	 * @return
	 */
	public boolean checkCircle(Node list) {
		if(list==null) return false;
		Node fast = list.next;
		Node slow = list;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) return true;
		}
		return false;
	}
	
	public Node mergeSortedList(Node a,Node b) {
		if(a==null) return b;
		if(b==null) return a;
		Node first = null;
		Node at = a;
		Node bt = b;
		if(at.data<bt.data) {
			first = at;
			at = at.next;
		}else {
			first = bt;
			bt = bt.next;
		}
		
		Node r = first;
		while(at!=null && bt!=null) {
			if(at.data<bt.data) {
				r.next = at;
				at = at.next;
			}else {
				r.next = bt;
				bt = bt.next;
			}
			r = r.next;
		}
		
		if(at!=null) {
			r.next = at;
		}else {
			r.next = bt;
		}
		
		return first;
	}
	
	/**
	 * 删除倒数第k个结点
	 * 从整数第k个结点fast开始遍历 ，
	 * 同时从头开始循环记录当前结点slow  
	 * 当fast遍历到尾结点，slow就是要删除的结点
	 * @date 2019年12月13日
	 * @author tangp
	 * @param list
	 * @param k
	 * @return
	 */
	public Node deleteLastKth(Node list,int k) {
		if(list==null) return list;
		Node fast = list;
		int i =1;
		//循环遍历获取第K个结点
		while(fast!=null && i<k) {
			fast = fast.next;
			++i;
		}
		
		if(fast==null) return list;
		
		Node pre = null;
		Node slow = list;
		while(fast.next!=null) {
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
		//说明要删除的是头结点
		if(pre==null) {
			list = list.next;
		}else {
			pre.next = slow.next;
		}
		
		return list;
	}
	
	/**
	 * 起点相同，快2步，我走到结尾，你走到居中
	 * @date 2019年12月13日
	 * @author tangp
	 * @param list
	 * @return
	 */
	public Node findMiddleNode(Node list) {
		if(list==null) return null;
		Node fast = list;
		Node slow = list;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	 /**
	 * @ate 2018年10月12日
	 * @author Administrator
	 */
	public static class Node {
		private int data;
		private Node next;
		
		
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}
	public static void main(String[] args) {
		
	}
}
