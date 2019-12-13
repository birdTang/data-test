package com.tang.sort;

/**
 * 快速排序
 * @ate 2018年11月13日
 * @author Administrator
 */
public class QuickSort {

	private static void quickSort(int[] a,int n) {
		quickSortInternally(a, 0, n-1);
		System.out.println(SortMethod.printVal(a));
	}
	
	private static void quickSortInternally(int[] a,int p,int r) {
		//递归终止条件
		if(p>=r) return;
		int q = partition(a, p, r); //获取分区点
		quickSortInternally(a, p, q-1);
		quickSortInternally(a, q+1, r);
	}
	
	private static int partition(int[] a,int p,int r) {
		
		int pivot = a[r];
		int i = p;
		for(int j=p;j<=r;j++) {
			//小于pivot，则交换
			if(a[j] < pivot) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				++i;
			}
		}
		
		int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
		
		 System.out.println("i=" + i);
		 return i;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 2, 6, 4, 5, 1, 9, 20, 13, 16};
		
		quickSort(arr, arr.length);
	}
}
