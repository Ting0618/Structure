package com.prac.graph;


//边表结点
public class EdgeNode {
	
	private Object weight;//权值
	private EdgeNode next;//指向下一个邻接点
	private int adjvex;//存储该结点对应的下标
	
	public EdgeNode(Object weight,int adjvex){
		this.weight = weight;
		this.adjvex = adjvex;
		this.next = null;
	}
	public EdgeNode(){
		
	}
	
	
	public Object getWeight() {
		return weight;
	}
	public void setWeight(Object weight) {
		this.weight = weight;
	}
	public EdgeNode getNext() {
		return next;
	}
	public void setNext(EdgeNode next) {
		this.next = next;
	}
	public int getAdjvex() {
		return adjvex;
	}
	public void setAdjvex(int adjvex) {
		this.adjvex = adjvex;
	}
	
}
