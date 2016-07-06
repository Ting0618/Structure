package com.prac.string;

public class KMP {

	//返回T在S的第pos个字符之后的位置,当pos等于0的时候就是从第一个字符开始比了
	public int index(String S,String T,int pos){
		char[] sc = S.toCharArray();
		char[] tc = T.toCharArray();
		int i=pos;
		int j=1;
		int next[] = this.next(T);
		while(i<sc.length && j<tc.length){
			if(j==0 || sc[i]==tc[j]){
				++i;
				++j;
			}
			else{
				j=next[j];
				System.out.println("j "+next[j]);
			}
		}
		if(j>=tc.length){
			return i-tc.length;
		}else
		return 0;
	}
	
	//求子串的next数组
	public int[] next(String b){
		char[] t = b.toCharArray();
		int[] next = new int[t.length+1];  
		next[0]=next[1] = 0;
	    int i=1;  
	    int j=0;
	    while (i < t.length) {  
            if (j == 0 || t[i] == t[j]) {  
                i++;  
                j++;  
                next[i] = j;  
                /*if (t[i] != t[j]) {  
                    next[i] = j;  
                } else {  
                    next[i] = next[j];  
                } */ 
            } else {  
                j = next[j];  
            } 
        }  
        return next;
	     
		/*int len=b.length();  
	    int j=0;
	    int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始  
	    next[0]=next[1]=0;  
	          
	    for(int i=1;i<len;i++)//i表示字符串的下标，从0开始  
	    {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置  
	        while(j>0&&b.charAt(i)!=b.charAt(j))j=next[j];  
	        if(b.charAt(i)==b.charAt(j))j++;  
	        next[i+1]=j;  
	    }  
		return next;*/
	}
}
