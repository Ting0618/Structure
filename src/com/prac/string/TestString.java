package com.prac.string;

public class TestString {

	public static void main(String[] args) {
		KMP kmp = new KMP();
		String s = "wang78ting";
		String t = "abcabx";
	//	int next[]=kmp.next(t);
		int index = kmp.index(s, "ting", 4);
		System.out.println(index);
		/*for(int i=0;i<next.length;i++){
			System.out.println("next"+i+" "+next[i]);
		}*/
	}
}
