package com.prac.Stack;

public class StackNode {

	private Object data;
	private StackNode next;
	
	public StackNode(Object data,StackNode next){
		this.data=data;
		this.next=next;
	}
	
	public StackNode(){
		
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public StackNode getNext() {
		return next;
	}
	public void setNext(StackNode next) {
		this.next = next;
	}
	
}
