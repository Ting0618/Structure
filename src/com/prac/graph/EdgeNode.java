package com.prac.graph;


//�߱���
public class EdgeNode {
	
	private Object weight;//Ȩֵ
	private EdgeNode next;//ָ����һ���ڽӵ�
	private int adjvex;//�洢�ý���Ӧ���±�
	
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
