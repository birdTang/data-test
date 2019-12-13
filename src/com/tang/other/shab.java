package com.tang.other;

public class shab {

	public static void main(String[] args) {
		
	}
	
	
	int find(char[] a,int n,char key) {
		if (a==null || n<=0) {
			return -1;
		}
		
		int i=0;
		while(i<n) {
			if (a[i] == key) {
				return a[i];
			}
			++i;
		}
		return -1;
	}
	
	int find2(char[] a,int n,char key) {
		if (a==null || n<=0) {
			return -1;
		}
		
		if (a[n-1]==key) {
			return a[n-1];
		}
		char temp = a[n-1];
		a[n-1] = key;
		
		int i=0;
		while(a[i] !=key) {
			++i;
		}
		a[n-1] = temp;
		
		if (i== n-1) {
			return -1;
		}else {
			return a[i];
		}
	}
}
