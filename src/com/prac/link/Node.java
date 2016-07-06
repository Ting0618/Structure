package com.prac.link;

public class Node<E> {

	private Object data;
	private Node<E> pre;
	private Node<E> next;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	public String toString(){
		return data.toString();
	}
	public Node(Object data,Node<E> next){
        this.data = data;
        this.next = next;
    }
	public Node(){}
	
	public Node<E> getPre() {
		return pre;
	}
	public void setPre(Node<E> pre) {
		this.pre = pre;
	}
	public Node<E> next(){
		return this.next;
	}
	public Node(Object data , Node<E> pre, Node<E> next){
		this.data=data;
		this.next=next;
		this.pre=pre;
	}
}
