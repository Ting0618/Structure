package com.prac.graph;


//顶点表结点
public class VertexNode {

	private Object data;
	private EdgeNode firstNode;//指向第一个邻接点
	
	public VertexNode(Object data,EdgeNode firstNode){
		this.data = data;
		this.firstNode = firstNode;
	}
	
	public VertexNode(){}
	
	public VertexNode(Object data){
		this.data = data;
	}
	
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public EdgeNode getFirstNode() {
		return firstNode;
	}
	public void setFirstNode(EdgeNode firstNode) {
		this.firstNode = firstNode;
	}
	
	
}
