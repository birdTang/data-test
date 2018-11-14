package binary;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 二分查找示例
 * @ate 2018年11月12日
 * @author Administrator
 */
public class BinarySearch {

	/**
	 * 
	 * 非递归实现
	 * @date 2018年11月12日
	 * @author Administrator
	 * @return
	 */
	public int bsearch(int[] a,int n,int val) {
		int low = 0;
		int mid;
		int high = n-1;
		while(low<=high) {
			mid = low + ((high-low) >>1);
			if (a[mid]==val) {
				return mid;
			}else if (a[mid]<val) {
				low = mid+1;
			}else {
				high = mid -1;
			}
		}
		
		return 1;
	}
	
	//递归实现
	public int bsearchInternally(int[] a,int low,int high,int val) {
		//递归终止条件
		if (low > high) return -1;
		int mid = low + ((high-low) >>1);
		if (a[mid]==val) {
			return mid;
		}else if (a[mid] <val) {
			low = mid+1;
		}else {
			high = mid-1;
		}
		return bsearchInternally(a, low, high, val);
	}
	
	//变体：查找第一个等于给定值的元素
	public int bsearch3(int[] a,int n,int val) {
		int low = 0;
		int high = n-1;
		
		while(low<=high) {
			int mid = low + ((high-low)>>1);
			if (a[mid] <val) {
				low = mid+1;
			}else if(a[mid]>val) {
				high = mid-1;
			}else {
				if (mid==0 || (a[mid-1]!=val)) {
					return mid;
				}else {
					high = mid-1;
				}
			}
		}
		return -1;
	}
	
	//查找最后一个等于给定值的元素
	public int bsearch4(int[] a,int n,int val) {
		int low = 0;
		int high = n-1;
		
		while(low<=high) {
			int mid = low + ((high-low)>>1);
			if (a[mid] <val) {
				low = mid+1;
			}else if(a[mid]>val) {
				high = mid-1;
			}else {
				if (mid==n-1 || (a[mid+1]!=val)) {
					return mid;
				}else {
					low = mid+1;
				}
			}
		}
		return -1;
	}
	
	//变体三：查找第一个大于等于给定值的元素
	public int bsearch5(int[] a,int n,int val) {
		int low = 0;
		int high = n-1;
		while(low<=high) {
			int mid = low +((high-low)>>1);
			if (a[mid]<val) {
				low = mid+1;
			}else {
				if(mid==0 || (a[mid-1]<val)) return mid;
				else high = mid-1;
			}
		}
		return -1;
	}
	
	//变体三：查找最后一个小于等于给定值的元素
		public int bsearch6(int[] a,int n,int val) {
			int low = 0;
			int high = n-1;
			while(low<=high) {
				int mid = low +((high-low)>>1);
				if (a[mid] <= val) {
					if( mid==n-1 || (a[mid+1]>val)) return mid;
					else low = mid+1;
				}else {
					high = mid-1;
				}
			}
			return -1;
		}
		
		public static void main(String[] args) {
			// 10 是初始大小，0.75 是装载因子，true 是表示按照访问时间排序
			HashMap<Integer, Integer> m = new LinkedHashMap<>();
			m.put(3, 11);
			m.put(1, 12);
			m.put(5, 23);
			m.put(2, 22);

			m.put(3, 26);
			m.get(5);

			for (Map.Entry e : m.entrySet()) {
			  System.out.println(e.getKey());
			}

		}
		
}
