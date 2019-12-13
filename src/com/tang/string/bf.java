package com.tang.string;
public class bf {

	// b 表示模式串，m 表示长度，suffix，prefix 数组事先申请好了
	private static void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
	  for (int i = 0; i < m; ++i) { // 初始化
	    suffix[i] = -1;
	    prefix[i] = false;
	  }
	  for (int i = 0; i < m - 1; ++i) { // b[0, i]
	    int j = i;
	    int k = 0; // 公共后缀子串长度
	    while (j >= 0 && b[j] == b[m-1-k]) { // 与 b[0, m-1] 求公共后缀子串
	      --j;
	      ++k;
	      suffix[k] = j+1; //j+1 表示公共后缀子串在 b[0, i] 中的起始下标
	    }
	    
	    if (j == -1) prefix[k] = true; // 如果公共后缀子串也是模式串的前缀子串
	  }
	  
	  for (int i=0;i<suffix.length;i++) {
		System.out.println("suffix["+i+"]=" + suffix[i]);
	  }
	  for (int i=0;i<prefix.length;i++) {
			System.out.println("prefix["+i+"]=" + prefix[i]);
		  }
	}
	
	public static void main(String[] args) {
		char[] b = {'c','a','b','c','a','b'};
		generateGS(b, b.length, new int[6], new boolean[6]);
	}
	

}
