package com.tang.linklist;

import java.util.Scanner;

public class LRUBaseLinkList<T> {
	
	//默认链表容量
	private static int DEFAULT_CAPACITY = 10;
	//头结点
	private Node<T> head;
	//列表长度
	private Integer length;
	/**
     * 链表容量
     */
    private Integer capacity;
	
	public LRUBaseLinkList() {
        this.head = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }
	
	 public LRUBaseLinkList(Integer capacity) {
        this.head = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }
	 /**
	  * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
		2. 如果此数据没有在缓存链表中，又可以分为两种情况：
			如果此时缓存未满，则将此结点直接插入到链表的头部；
			如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
	  * @date 2019年12月13日
	  * @author tangp
	  * @param data
	  */
	 public void  add(T data) {
		 Node preNode = findPreNode(data);
		 if(preNode!=null) {
			 deleteNode(preNode);
			 insertNode(data);
		 }else {
			if(length>=this.capacity) {
				deleteEnd();
			}
			 insertNode(data);
		 }
	 }
	 
	 public void deleteNode(Node preNode) {
		 Node next = preNode.getNext();
		 preNode.setNext(next.getNext());
		 next = null;
		 length--;
	 }
	 
	 public void insertNode(T data) {
		 Node next = head.getNext();
		 head.setNext(new Node(data, next));
		 length++;
	 }
	 
	 public void deleteEnd() {
		 Node<T> ptr  = head;
		 //空列表直接返回
		 if(ptr.getNext()==null) {
			 return ;
		 }
		 
		 //获取倒数第二个结点
		 while (ptr.getNext().getNext()!=null) {
			ptr = ptr.getNext();
		}
		 
		 deleteNode(ptr);
	 }
	 
	 public void printAll() {
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getData() + ",");
            node = node.getNext();
        }
        System.out.println();
	}
	 /**
	  * 获取查找元素的前一个结点
	  * @date 2019年12月12日
	  * @author tangp
	  * @param data
	  * @return
	  */
	 public Node findPreNode(T data) {
		 Node node = head;
		 while(node.getNext()!=null) {
			 if(data.equals(node.getNext().getData())) {
				 return node;
			 }
			 node = node.getNext();
		 }
		 return null;
	 }
	 
	 
	public static void main(String[] args) {
		LRUBaseLinkList<Integer> lruBaseLinkList = new LRUBaseLinkList<>();
		Scanner sc = new Scanner(System.in);
        while (true) {
        	lruBaseLinkList.add(sc.nextInt());
        	lruBaseLinkList.printAll();
        }
	}

}

class Node<T> {
	private T data;
	private Node next;
	
	
	public Node(T data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	
	public Node(T element) {
        this.data = data;
    }
	
	public Node() {
        this.next = null;
    }

	
	
	
	public T getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
