package com.prac.string;

public class KMP {

	//����T��S�ĵ�pos���ַ�֮���λ��,��pos����0��ʱ����Ǵӵ�һ���ַ���ʼ����
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
	
	//���Ӵ���next����
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
	    int next[]=new int[len+1];//next��ʾ����Ϊi���ַ���ǰ׺�ͺ�׺����������֣���1��ʼ  
	    next[0]=next[1]=0;  
	          
	    for(int i=1;i<len;i++)//i��ʾ�ַ������±꣬��0��ʼ  
	    {//j��ÿ��ѭ����ʼ����ʾnext[i]��ֵ��ͬʱҲ��ʾ��Ҫ�Ƚϵ���һ��λ��  
	        while(j>0&&b.charAt(i)!=b.charAt(j))j=next[j];  
	        if(b.charAt(i)==b.charAt(j))j++;  
	        next[i+1]=j;  
	    }  
		return next;*/
	}
}
