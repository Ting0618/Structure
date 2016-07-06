package com.prac.suanfa;

import com.prac.tree.Tree;
import com.prac.tree.TreeNode;

public class SuanFaTest {

	public static void main(String[] args) {
		/*TreeNode child = new TreeNode();
		TreeNode f = new TreeNode();
		TreeNode p = new TreeNode();
		Tree tree = new Tree(child);
		child = tree.createByHand();
		tree.preOrder();
		SearchAndSort s = new SearchAndSort();
	//	boolean b = s.SearchBST(tree.getRoot(), 6, f, p);
	//	System.out.println(b);
		boolean c = s.insertBST(tree.getRoot(), 12);
		System.out.println(c);*/
		
		int[] a = {50,10,90,30,70,40,80,60,20};
		SearchAndSort s = new SearchAndSort();
		s.quickSort(a);
		System.out.println(a[0]);
	}
}
