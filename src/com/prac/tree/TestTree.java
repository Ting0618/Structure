package com.prac.tree;

public class TestTree {

	public static void main(String[] args) {
		TreeNode child = new TreeNode();
		TreeNode node = new TreeNode(child,child);
		Tree tree = new Tree(child);
	//	tree.create();
		tree.createByHand();
		tree.preOrderTraverse();
		tree.preOrder();
	//	tree.getValue(tree.getRoot());
	//	System.out.println(tree.getNode().getData());
	}
}
