package com.prac.Stack;

public class StackList {

	private int maxsize=20;//Ĭ��ջ�ĳ���
	private int top;//ָ��ջ��Ԫ��
	private Object[] object;//ջ����һ������
	private int stackSize;//��ʾ��ǰջ�Ŀ��ó���
	
	//��ʼ��ջ
	public StackList(){
		object =new Object[maxsize];
		top=-1;
	}
	public StackList(int stackSize){
		this.stackSize=stackSize;
		object =new Object[stackSize];
		top=-1;
	}
	
	//��ջ����
	public void push(Object obj){
		if(top==stackSize-1){
			System.out.println("ջ����");
		}else{
			object[top+1]=obj;
			top++;
		}
	}
	//��ջ����
	public void pop(){
		if(top!=-1){
			top--;
		}else{
			System.out.println("û�п���ɾ����Ԫ����");
		}
	}
	//��ӡԪ��
	public void print(){
		for(int i=0;i<=top;i++){
			System.out.print(object[i].toString()+" ");
		}
		System.out.println();
	}
	
}
