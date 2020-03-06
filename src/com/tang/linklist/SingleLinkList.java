package com.tang.linklist;

/**
 * 单链表的插入\删除\查找操作
 * @ate 2018年10月12日
 * @author Administrator
 */
public class SingleLinkList {

	private Node head = null; //头结点
	
	public Node findByValue(int value) {
		Node p = head;
		while (p!=null && p.data!=value) {
			p = p.next;
		}
		return p;
	}
	
	public Node findByIndex(int index) {
		Node p = head;
		int pos = 0;
		while(p!=null && pos!=index) {
			p = p.next;
			++pos;
		}
		
		return p;
	}
	//无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
	 public void insertToHead(int value) {
		 Node newNode = new Node(value,null);
		 insertToHead(newNode);
	 }
	
	 public void insertToHead(Node newNode) {
		 if (head==null) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
	 }
	
	 
	 public void insertAfter(Node p,int value) {
		 Node newNode = new Node(value, null);
		 insertAfter(p, newNode);
	 }
	 
	 public void  insertAfter(Node p,Node newNode) {
		 if (p==null) return;
		 newNode.next = p.next;
		 p.next = newNode;
	 }
	 
	 public void insertBefore(Node p,Node newNode) {
		 if (p==null) return;
		 if (head == p) {
			insertToHead(newNode);
			return;
		 }
		 //遍历获取 p 的前一个结点
		 Node q = head;
		 while(q !=null && q.next!=p) {
			 q = q.next;
		 }
		 if (q==null) {
			return;
		}
		 q.next = newNode;
		 newNode.next = p;
	 }
	 
	 public void deleteByNode(Node p) {
		 if (p==null || head==null) return;
		 if (p == head) {
			head = head.next;
			return;
		}
		 
		//遍历结点，查找要删除结点的前一个
		 Node q = head;
		 while(q!=null && q.next!=p) {
			 q = q.next;
		 }
		 
		 if (q==null) return;
		 q.next = p.next;
	 }
	 
	 public void deleteByvalue(int value) {
		 if (head==null) return;
		 
		 Node p = head; //当前结点
		 Node q = null; //前一个结点
		 while(p!=null && p.data!=value) {
			 p = p.next;
			 q = p;
		 }
		 
		 if (p==null) return;
		 
		 if (q==null) {
			 //说明要 删除的是首节点
			 head = p.next;
			 return;
		}else {
			q.next = p.next;
		}
		 
	 }
	 
	 public void printAll() {
		 Node p =head;
		 while (p!=null) {
			System.out.println(p.getData());
			p = p.next;
		}
		 System.out.println("=================================");
	 }
	 /**
	  * 单链表反转
	  * @date 2018年10月13日
	  * @author Administrator
	  */
	// 单链表反转
	  public  Node reverse(Node list) {
	    Node headNode = null;
	    Node previousNode = null;
	    Node currentNode = list;
	    while (currentNode!=null) {
			Node nextNode = currentNode.next;
			if (nextNode==null) {
				headNode = currentNode;
			}
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
	    return headNode;
	  }
	  
	  
	  //检测环
	  public boolean checkCircle(Node list) {
		  if (list==null) return false;
		  Node fast = list.next;
		  Node slow = list;
		  while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow==fast) return true;
		  }
		  return false;
	  }
	  
	  //有序列表合并 ，按数值从小到大排序
	  public Node mergeSortedLists(Node la,Node lb) {
		  if (la==null) return lb;
		  if (lb==null) return la;
		  Node first = null;
		  Node p = la;
		  Node q = lb;
		  if (p.data<q.data) {
			  first = p;
			p = p.next;
		  }else {
			  first = q;
			q = q.next;
		  }
		  Node r = first;
		  while(p!=null && q!=null) {
			  if (p.data<q.data) {
				r.next = p;
				p = p.next;
			  }else {
				r.next = q;
				q = q.next;
			  }
			  r = r.next;
		  }
		  
		if (p!=null) {
			r.next = p;
		}else {
			r.next = q;
		}
		  
		  
		  return first;
	  }
	  
	//有序列表合并 ，按数值从小到大排序
	  public Node mergeSortedLists2(Node la,Node lb) {
		  if (la==null) return lb;
		  if (lb==null) return la;
		  Node first = new Node();
		  Node p = la;
		  Node q = lb;
		  Node r = first;
		  while(p!=null && q!=null) {
			  if (p.data<q.data) {
				r.next = p;
				p = p.next;
			  }else {
				r.next = q;
				q = q.next;
			  }
			  r = r.next;
		  }
		  
		if (p!=null) {
			r.next = p;
		}else {
			r.next = q;
		}
		  return first.next;
	  }
	  //删除倒数第K个结点
	  public Node deleteLastKth(Node list,int k) {
		  Node fast = list;
		  int i=1;
		  //得到正数第K个设置为fast ,倒数第K个 = fast-slow
		  while(fast!=null && i<k) {
			  fast = fast.next;
			  ++i;
		  }
		  if(fast ==null) return list;
		  Node slow = list;
		  Node prev = null;
		  //遍历查找要删除元素的前一个元素 prev,slow标识的就是 要删除 的结点，
		  while(fast.next!=null) {
			  fast = fast.next;
			  prev = slow;
			  slow = slow.next;
		  }
		  //prev==null 说明要删除的结点是头结点
		  if (prev == null) {
		      list = list.next;
		    } else {
		    	prev.next = slow.next;
		    }
		    return list;
	  }
	  
	  //求中间结点
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
		
		public Node() {
		}
		
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
		SingleLinkList list = new SingleLinkList();
		list.insertToHead(5);
		list.insertToHead(3);
		list.insertToHead(1);
		list.printAll();
		//检测环，测试
//		list.findByIndex(2).setNext(list.findByIndex(0));
//		
//		System.out.println(list.checkCircle(list.findByIndex(0)));
		
		//单链表反转，测试
//		Node reverse = list.reverse(list.head);
//		SingleLinkList reverseList = new SingleLinkList();
//		reverseList.insertToHead(reverse);
//		reverseList.printAll();
		
		//有序列表合并--测试
//		SingleLinkList mergeList = new SingleLinkList();
//		mergeList.insertToHead(6);
//		mergeList.insertToHead(4);
//		mergeList.insertToHead(2);
//		Node mergeSortedLists2 = mergeList.mergeSortedLists2(list.head, mergeList.head);
//		while (mergeSortedLists2!=null) {
//			System.out.println(mergeSortedLists2.getData());
//			mergeSortedLists2 = mergeSortedLists2.next;
//		}
		
		//删除倒数k个元素 
		SingleLinkList deleteList = new SingleLinkList();
		deleteList.insertToHead(1);
		deleteList.insertToHead(2);
		deleteList.insertToHead(3);
		deleteList.insertToHead(4);
		deleteList.insertToHead(5);
		deleteList.deleteLastKth(deleteList.head, 2);
		deleteList.printAll();
	}
}
