package com.prac.Stack;

public class StackLink {

	private StackNode top;
	private StackNode head;
	
	public StackLink(StackNode head,StackNode top){
		this.top=top;
		this.head=head;
	}
	
	//��ջ����
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
			System.out.println("���ջ������Ŷ");
		}
	}
	
	//��ջ����
	public void pop(){
		if(isEmpty()){
			
		}else{
			System.out.println("������");
		}
	}
	//�ж���ջ�Ƿ����   true ����
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
