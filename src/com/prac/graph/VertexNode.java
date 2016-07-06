package com.prac.graph;


//�������
public class VertexNode {

	private Object data;
	private EdgeNode firstNode;//ָ���һ���ڽӵ�
	
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
