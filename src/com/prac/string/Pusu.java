package com.prac.string;

public class Pusu {
	
	//返回T在S的第pos个字符之后的位置
	   public int index(int[] S,int[] T,int pos){
		   int i=pos;
		   int j=1;
		   while(i<=S[0] && j<=T[0]){//是  <=
			   if(S[i]==T[j]){	//如果这个匹配上了就继续匹配下一个
				   ++i;
				   ++j;
			   }else{
				   j=1;		//j是T的  T又要从头开始匹配
				   i=i-j+2;   //pos表示的是第pos个位置之后才开始数的
			   }
		   }
		   if(j>T[0]){	//表示T中的每一个都匹配完了
			   return i-T[0];	//i和j一样   只不过是s中的   最后也要会过去
		   }else{
			   return 0;
		   }
	   }
}
