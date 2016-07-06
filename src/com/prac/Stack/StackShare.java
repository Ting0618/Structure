package com.prac.Stack;

//��ջ����ռ�
public class StackShare {
	private int maxsize=10;//Ĭ��ջ�ĳ���
	private int top1;
	private int top2;
	private Object[] object;
	private int stackSize;//��ʾ��ǰջ�Ŀ��ó���
	private int flag;//���ڱ�����Ҫ����һ��ջ���в���  1  top1,2  top2
	
	//��ʼ��ջ
	public StackShare(){
		object =new Object[maxsize];
		top1=-1;
		top2=maxsize;
	}
	public StackShare(int stackSize){
		this.stackSize=stackSize;
		object =new Object[stackSize];
		top1=-1;
		top2=stackSize;
	}
	
	//��ջ����
	public void push(Object obj,int flag){
		if(top1+1==top2){
			System.out.println("ջ����");
		}
		else{
			if(flag==1){
				object[top1+1]=obj;
				top1++;
			}
			else if(flag==2){
				object[top2-1]=obj;
				top2--;
			}else{
				System.out.println("Ҫ������ջ������");
			}
		}
		System.out.println("top1 "+top1+" top2 "+top2);
	}
	//�ж�ջ��ĳһ�ռ��Ƿ�Ϊ��   true ��Ϊ��
	public boolean isEmpty(int flag){
		boolean b=true;
		if(flag==1 && top1!=-1){
			b=false;
		}		
		else if(flag==2 && top2!=stackSize){
			b=false;
		}	
		else{
			System.out.println("�������");
		}
		return b;
	}
	
	public void print(int flag){
		if(flag==1){
			for(int i=0;i<=top1;i++){
				System.out.print(object[i].toString()+" ");
			}
			System.out.println();
		}else if(flag==2){
			for(int i=top2;i<stackSize;i++){
				System.out.print(object[i].toString()+" ");
			}
			System.out.println();
		}
		else{
			System.out.println("û�����ջ");
		}
	}
}
