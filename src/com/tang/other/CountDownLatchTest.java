package com.tang.other;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(6);
		for(int i=0;i<5;i++) {
			Thread t = new Thread(new FirstBatchWorker(latch));
			t.start();
		}
		
		for(int i=0;i<5;i++) {
			Thread t = new Thread(new SecondBatchWorker(latch));
			t.start();
		}
		
		while ( latch.getCount() != 1 ){
			System.out.println(latch.getCount());
			Thread.sleep(100L);
			}
			System.out.println("Wait for first batch finish");
			latch.countDown();

	}
	
}

class FirstBatchWorker implements Runnable {
	private CountDownLatch latch;
	public FirstBatchWorker(CountDownLatch latch) {
	this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("First batch executed!");
		latch.countDown();
		
	}
	
}

class SecondBatchWorker implements Runnable {
	private CountDownLatch latch;
	public SecondBatchWorker(CountDownLatch latch) {
	this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Second batch executed!");
		
	}
	
}