package com.prac.Stack;

public class StackList {

	private int maxsize=20;//默认栈的长度
	private int top;//指向栈顶元素
	private Object[] object;//栈就是一个数组
	private int stackSize;//表示当前栈的可用长度
	
	//初始化栈
	public StackList(){
		object =new Object[maxsize];
		top=-1;
	}
	public StackList(int stackSize){
		this.stackSize=stackSize;
		object =new Object[stackSize];
		top=-1;
	}
	
	//进栈操作
	public void push(Object obj){
		if(top==stackSize-1){
			System.out.println("栈满了");
		}else{
			object[top+1]=obj;
			top++;
		}
	}
	//出栈操作
	public void pop(){
		if(top!=-1){
			top--;
		}else{
			System.out.println("没有可以删除的元素了");
		}
	}
	//打印元素
	public void print(){
		for(int i=0;i<=top;i++){
			System.out.print(object[i].toString()+" ");
		}
		System.out.println();
	}
	
}
