package com.prac.Stack;

//两栈共享空间
public class StackShare {
	private int maxsize=10;//默认栈的长度
	private int top1;
	private int top2;
	private Object[] object;
	private int stackSize;//表示当前栈的可用长度
	private int flag;//用于表明是要对哪一个栈进行操作  1  top1,2  top2
	
	//初始化栈
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
	
	//进栈操作
	public void push(Object obj,int flag){
		if(top1+1==top2){
			System.out.println("栈满了");
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
				System.out.println("要操作的栈不存在");
			}
		}
		System.out.println("top1 "+top1+" top2 "+top2);
	}
	//判断栈的某一空间是否为空   true 不为空
	public boolean isEmpty(int flag){
		boolean b=true;
		if(flag==1 && top1!=-1){
			b=false;
		}		
		else if(flag==2 && top2!=stackSize){
			b=false;
		}	
		else{
			System.out.println("输入错误");
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
			System.out.println("没有这个栈");
		}
	}
}
