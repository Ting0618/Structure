package com.prac.string;

public class Pusu {
	
	//����T��S�ĵ�pos���ַ�֮���λ��
	   public int index(int[] S,int[] T,int pos){
		   int i=pos;
		   int j=1;
		   while(i<=S[0] && j<=T[0]){//��  <=
			   if(S[i]==T[j]){	//������ƥ�����˾ͼ���ƥ����һ��
				   ++i;
				   ++j;
			   }else{
				   j=1;		//j��T��  T��Ҫ��ͷ��ʼƥ��
				   i=i-j+2;   //pos��ʾ���ǵ�pos��λ��֮��ſ�ʼ����
			   }
		   }
		   if(j>T[0]){	//��ʾT�е�ÿһ����ƥ������
			   return i-T[0];	//i��jһ��   ֻ������s�е�   ���ҲҪ���ȥ
		   }else{
			   return 0;
		   }
	   }
}
