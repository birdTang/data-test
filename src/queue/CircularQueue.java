package queue;

/**
 * 循环队列
 * @ate 2018年10月26日
 * @author Administrator
 */
public class CircularQueue {

	private String[] items;  //队列容器
	private int size;  //队列大小
	private int head;  //队头
	private int tail;  //队尾
	
	// 申请一个大小为capacity的数组
	public CircularQueue(int capacity) {
		items = new String[capacity];
		size = capacity;
  	}
	//入队
	public boolean enqueue(String value) {
		//判断队满
		if ((tail+1) % size == head) {
			return false;
		}
		items[tail] = value;
		tail = (tail + 1) % size;
		return true;
	}
	
	//出队
	public String dequeue() {
		//判断队空
	    if (head == tail) return null;
	    String value = items[head];
	    head = (head+1) % size;
		return value;
	}
}
