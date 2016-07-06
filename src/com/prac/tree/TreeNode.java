package com.prac.tree;

public class TreeNode {

	private Object data;
	private TreeNode left;
	private TreeNode right;
	private int iint;
	
	public TreeNode(){}
	public TreeNode(TreeNode left,TreeNode right){
		this.right=right;
		this.left=left;
	}
	public TreeNode(Object data){
		this.data = data;
	}
	
	/*public int getData() {
		return iint;
	}*/
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	/*public void setData(int data){
		this.iint = data;
	}*/
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	
	
}
