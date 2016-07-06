package com.prac.Stack;

public class StackLink {

	private StackNode top;
	private StackNode head;
	
	public StackLink(StackNode head,StackNode top){
		this.top=top;
		this.head=head;
	}
	
	//进栈操作
	public void push(Object obj){                                        
		StackNode e=new StackNode(obj,head.getNext());
		if(isEmpty()){
			if(top.getNext()==null){
				e.setNext(head);
				top.setNext(e);
			}else{
				e.setNext(top.getNext());
				top.setNext(e);
			}
			
		}else{
			System.out.println("这个栈不存在哦");
		}
	}
	
	//出栈操作
	public void pop(){
		if(isEmpty()){
			
		}else{
			System.out.println("不存在");
		}
	}
	//判断链栈是否存在   true 存在
	public boolean isEmpty(){
		boolean b=false;
		if(head!=null){
			b=true;
		}
		return b;
	}
	
	public void print(){
		StackNode e=top.getNext();
		while(e.getNext()!=null){
			System.out.print(e.getData().toString()+" ");
			e=e.getNext();
		}
	}
}
