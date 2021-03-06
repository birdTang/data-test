package com.tang.sort;

/**
 * 排序算法--冒泡，插入，选择排序
 * 
 * @ate 2018年11月13日
 * @author Administrator
 */
public class SortMethod {

	public static void bubbleSort(int[] datas,int n) {
		if (n<=1) return;
		System.out.println("==冒泡排序 before=="+  printVal(datas));
		/** 6,5,4,3,2,1
		 * i=0 j=0  --> 5, 6, 4, 3, 2, 1
		 * i=0 j=1  --> 5, 4, 6, 3, 2, 1
		 * i=0 j=2  --> 5, 4, 3, 6, 2, 1
		 * i=0 j=3  --> 5, 4, 3, 2, 6, 1
		 * i=0 j=4  --> 5, 4, 3, 2, 1, 6
		 * 
		 * i=1 j=0  --> 4, 5, 3, 2, 1, 6
		 * i=1 j=1  --> 4, 3, 5, 2, 1, 6
		 * i=1 j=2  --> 4, 3, 2, 5, 1, 6
		 * i=1 j=3  --> 4, 3, 2, 1, 5, 6
		 * 
		 * i=2 j=0  --> 3, 4, 2, 1, 5, 6
		 * i=2 j=1  --> 3, 2, 4, 1, 5, 6
		 * i=2 j=2  --> 3, 2, 1, 4, 5, 6
		 * 
		 * i=3 j=0  --> 2, 3, 1, 4, 5, 6
		 * i=3 j=1  --> 2, 1, 3, 4, 5, 6
		 * 
		 * i=4 j=0  --> 1, 2, 3, 4, 5, 6
		 * 
		 */
		
		for(int i=0;i<n;i++) {
			//提前退出冒泡循环的标识,若某次冒泡未发生任何数据交换移动，则说明数据已经按从小到大排序了
			boolean flag = false;
			
			for(int j=0;j<n-i-1;j++) {
				if(datas[j]>datas[j+1]) {
					int tem = datas[j];
					datas[j] = datas[j+1];
					datas[j+1] = tem;
					flag = true;
				}
			}
			if(!flag) break;
		}
		System.out.println("==冒泡排序 end====="+ printVal(datas) );
	}
	
	/**
	 * 插入排序
	 * 取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序
	 * @date 2018年11月13日
	 * @author tangp
	 * @param datas
	 * @param n
	 */
	public static void insertionSort(int[] datas,int n) {
		if (n<=1) return;
		System.out.println("==插入排序 before=="+  printVal(datas));
		/**
		 * 4,5,6,3,2,1
		 * 
		 * i=1,j=0 --> 4, 5, 6, 3, 2, 1
		 * 
		 * i=2,j=1  --> 4, 5, 6, 3, 2, 1
		 * 
		 *  i=3,j=2  -->4, 5, 6, 6, 2, 1
		 *  i=3,j=1  -->4, 5, 5, 6, 2, 1
		 *  i=3,j=0  -->4, 4, 5, 6, 2, 1--插入->3, 4, 5, 6, 2, 1
		 *  
		 *  i=4,j=3  -->3, 4, 5, 6, 6, 1
		 *  i=4,j=2  -->3, 4, 5, 5, 6, 1
		 *  i=4,j=1  -->3, 4, 4, 5, 6, 1
		 *  i=4,j=0  -->3, 3, 4, 5, 6, 1--插入->2, 3, 4, 5, 6, 1
		 *  
		 *  i=5,j=4  -->2, 3, 4, 5, 6, 6
		 *  i=5,j=3  -->2, 3, 4, 5, 5, 6
		 *  i=5,j=2  -->2, 3, 4, 4, 5, 6
		 *  i=5,j=1  -->2, 3, 3, 4, 5, 6
		 *  i=5,j=0  -->2, 2, 3, 4, 5, 6 --插入->1, 2, 3, 4, 5, 6
		 */
		
		for(int i=1;i<n;i++) {
			//待排区域
			int val = datas[i];
			int j = i-1;
			//已排区域， 查找插入的位置
			for(;j>=0;j--) {
				if (datas[j]>val) {
					datas[j+1] = datas[j]; //数据移动
				}else break;
			}
			//插入
			datas[j+1] = val;
		}
		
		System.out.println("==插入排序 end====="+  printVal(datas));
	}
	
	/**
	 * 选择排序：找到待排区域中的最小值，放入已排区域的尾部
	 * @date 2019年12月16日
	 * @author tangp
	 * @param datas
	 * @param n
	 */
	public static void selectionSort(int[] datas,int n) {
		if (n<=1) return;
		
		System.out.println("==选择排序 before=="+  printVal(datas));
		
		for(int i=0;i<n;i++) {
			//查找 最小值
			int minIndex = i;
			for(int j=i+1;j<n;j++) {
				if(datas[j]<datas[minIndex]) {
					minIndex = j;
				}
			}
			//交换最小值位置
			int tmp = datas[i];
			datas[i] = datas[minIndex];
			datas[minIndex] = tmp;
		
		}
		
		System.out.println("==选择排序 end====="+  printVal(datas));
	}
	/**
	   * 向下冒泡。可能比冒泡更易懂？
	   * 
	   * 算法概要：
	   * 从0开始，用这个元素去跟后面的所有元素比较，如果发现这个元素大于后面的某个元素，则交换。
	   * 3 2 6 4 5 1
	   * 第一趟是从 index=0 也就是 3， 开始跟index=1及其后面的数字比较
	   *  3 大于 2，交换，变为 2 3 6 4 5 1，此时index=0的位置变为了2
	   *    接下来将用2跟index=2比较
	   *  2 不大于 6 不交换
	   *  2 不大于 4 不交换
	   *  2 不大于 5 不交换
	   *  2 大于 1，交换，变为 1 3 6 4 5 2，第一趟排序完成。
	   * 
	   * 第二趟是从 index=1 也就是 3，开始跟index=2及其后面的数字比较
	   *  3 不大于 6 不交换
	   *  3 不大于 4 不交换
	   *  3 不大于 5 不交换
	   *  3 大于 2，交换，变为 1 2 6 4 5 3，第二趟排序完成。
	   * 
	   * 第三趟是从 index=2 也就是 6，开始跟index=3及其后面的数字比较
	   *  6 大于 4，交换，变为 1 2 4 6 5 3, 此时 index = 2 的位置变为了4
	   *     接下来将用4跟index=4比较
	   *  4 不大于 5 不交换
	   *  4 大于 3，交换，变为 1 2 3 6 5 4，第三趟排序完成。
	   * 
	   * 第四趟是从 index=3 也就是 6，开始跟index=4及其后面的数字比较
	   *  6 大于 5，交换，变为 1 2 3 5 6 4, 此时 index = 3 的位置变为了5
	   *     接下来将用5跟index=5比较
	   *  5 大于 4，交换，变为 1 2 3 4 6 5, 第四趟排序完成。
	   *
	   * 第五趟是从 index=4 也就是 6，开始跟index=5及其后面的数字比较
	   *  6 大于 5，交换，变为 1 2 3 4 5 6, 此时 index = 4 的位置变为了5
	   *     接下来将用5跟index=6比较
	   *  index = 6 已经不满足 index < length 的条件，整个排序完成。
	   */
	  private static void bubbleDownSort(int[] arr) {
	    int len = arr.length;
	    if (len == 1) return;
	    System.out.println("==向下冒泡排序 before=="+  printVal(arr));
	    for (int i = 0; i < len; i++) {
	      for (int j = i + 1; j < len; j++) {
	        if (arr[i] > arr[j]) {
	          int tmp = arr[i];
	          arr[i] = arr[j];
	          arr[j] = tmp;
	        }
	      }
	    }
	    
	    System.out.println("==向下冒泡排序 end====="+  printVal(arr));
	  }
	  
	  private static void shellSort(int[] arr) {
		    int len = arr.length;
		    if (len == 1) return;
		    System.out.println("==希尔排序 before====="+  printVal(arr));
		    int step = len / 2;
		    while (step >= 1) {
		      for (int i = step; i < len; i++) {
		        int value = arr[i];
		        int j = i - step;
		        for (; j >= 0; j -= step) {
		          if (value < arr[j]) {
		            arr[j+step] = arr[j];
		          } else {
		            break;
		          }
		        }
		        arr[j+step] = value;
		      }

		      step = step / 2;
		    }
		    
		    System.out.println("==希尔排序 end====="+  printVal(arr));
		  }
	public static String printVal(int[] datas) {
		StringBuffer sb = new StringBuffer();
		for (int i : datas) {
			sb.append(i+" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] datas = {6,5,4,3,2,1};
		SortMethod.bubbleSort(datas, datas.length);
		
		int[] datas2 = {4,5,6,3,2,1};
		SortMethod.insertionSort(datas2, datas2.length);
		
		int[] datas3 = {4,5,6,3,2,1};
		SortMethod.insertionSort(datas3, datas3.length);
		
		int[] arr = {3, 2, 6, 4, 5, 1, 9, 20, 13, 16};
		bubbleDownSort(arr);
		int[] arr2 = {3, 2, 6, 4, 5, 1, 9, 20, 13, 16};
		shellSort(arr2);
	}
}
