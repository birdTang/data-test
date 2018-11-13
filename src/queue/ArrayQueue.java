package queue;

/**
 * 基于数据实现--顺序队列
 * @ate 2018年10月26日
 * @author Administrator
 */
public class ArrayQueue {

	private String[] items;  //容器
	private int size;  //容器大小
	private int head;  //队头
	private int tail;  //队尾
	
	// 申请一个大小为capacity的数组
	public ArrayQueue(int capacity) {
		items = new String[capacity];
		size = capacity;
  	}
	//入队
	public boolean enqueue(String value) {
		//队满判断  tail ==size 说明队列没有存储空间
		if (tail ==size) {
			//head ==0 说明队列已满
			if (head ==0) return false;
			
			//数据迁移
			for (int i = head; i < tail; i++) {
				items[i-head] = items[i];
			}
			//搬移完之后重新更新head和tail
			head = 0;
			tail = tail-head;
		}
		
		items[tail] = value;
		++tail;
		return true;
	}
	
	//出队
	public String dequeue() {
		//队空判断
		if (head == tail) {
			return null;
		}
		String value = items[head];
		++head;
		return value;
	}
	
}
