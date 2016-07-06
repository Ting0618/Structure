package com.prac.tree;

import java.util.Scanner;
import java.util.Stack;

public class Tree {

	Scanner scan = new Scanner(System.in);
	TreeNode root ;	//根节点，通过他来找别的结点
	
	public Tree(TreeNode root){
		this.root = root;
		System.out.println("Tree() root "+root);
	}
	
	public TreeNode getRoot(){
		return root;
	}
	public void setRoot(TreeNode root){
		this.root = root;
	}
	
	public void create(){
		this.root = create(root);
	}
	
	//构造的扩展二叉树，根据某种序列手动输入的
	public TreeNode create(TreeNode n){
		System.out.println("输入节点的值：");
		String data = scan.next();
		if("#".equals(data)){	//输入#表示没有这个结点
			return null;
		}
		else{
			n = new TreeNode();		//n递归的时候会为空，所以要创建一个
			n.setData(data);		//把新输入的值传给新创建的结点n 
			System.out.println("root.getLeft() "+n.getLeft());//这时候为空，但n不是空
			n.setLeft(create(n.getLeft()));	//为n设置左孩子  是递归过后的返回值
			n.setRight(create(n.getRight()));
			return n;	//返回的这一个结点将用于创建上一个节点的左/右孩子
		}
	}
	//通过数组构造二叉树
	public void createByArray(){
		
	}
	
	//手动输入的
	public TreeNode createByHand(){
		TreeNode a = new TreeNode(8);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(10);
		TreeNode d = new TreeNode(6);
		TreeNode e = new TreeNode(2);
		a.setLeft(b);
		a.setRight(c);
		b.setRight(d);
		b.setLeft(e);
		this.root = a;
		return root;
	}
	
	//通过前序递归的方式遍历二叉树   （错误）
	public void getValue(TreeNode n){
		System.out.println("getValue");
		if(root==null){
			System.out.println("结束");
		}else{
			System.out.print(root.getData()+"  ");
			getValue(root.getLeft());
			getValue(root.getRight());
		}
	}
	
	
	//通过递归的方式遍历二叉树
	public void preOrderTraverse(){
	    preOrderTraverse(root);
	}
	
	  private void preOrderTraverse(TreeNode node) {
	//	System.out.println("preOrderTraverse root  "+node);
	    if(node != null){
	/*----前序遍历-------------------------------------------------------------*/
	      System.out.print(node.getData()+"  ");
	      preOrderTraverse(node.getLeft());	//找到左孩子并打印，再去找左孩子，没有就找这个结点的右孩子
	      preOrderTraverse(node.getRight());//没有左孩子就找这个结点的右孩子
	    
	/*----中序遍历-------------------------------------------------------------*/    
	      /*preOrderTraverse(node.getLeft());	//找到最后一个左孩子
	      System.out.print(node.getData()+"  ");//找到后就打印
	      preOrderTraverse(node.getRight());//打印完就找上个结点的右孩子
*/	      
	/*----后序遍历-------------------------------------------------------------*/      
	      /*preOrderTraverse(node.getLeft());	//找到最后一个左孩子
	      preOrderTraverse(node.getRight());//打印完就找上个结点的右孩子
	      System.out.print(node.getData()+"  ");//找到后就打印
*/	    }
	  }
	  
	  
	  //通过前序不递归的方式遍历二叉树
	  public void preOrder(){
		  System.out.println("preOrder");
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  stack.push(root);		//放入栈底，从root开始放
		  TreeNode node = null;
			  while(!stack.isEmpty()){
				  node=stack.pop();	//将栈顶元素取出并返回该对象（）
				  System.out.print(node.getData()+"  ");//打印该对象数据
				  if(node.getRight()!=null) 
					  stack.push(node.getRight());//先取有右孩子，有则推入栈（保证所有的右孩子在左孩子之后被取出来）
				  if(node.getLeft()!=null)
					  stack.push(node.getLeft());//再取左孩子，有则推入栈
			  }
	  }
	  
	  //中序不递归遍历二叉树
	  public void midOrder(){
		  System.out.println("midOrder");
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  TreeNode current = root;
		  while (current != null || !stack.isEmpty()){//注意  这里是或 
			  while(current!=null){
				  stack.push(current);//将当前元素推入栈
				  current = current.getLeft();//找到下一个左孩子，没有左孩子的时候current=null
			  }
			  if(!stack.isEmpty()){//栈里面有值的时候
				  current = stack.pop();//取出栈顶元素，先输出的肯定是左孩子，只要栈里有值current就不会为null
				  System.out.println(current.getData());
				  current = current.getRight();//
			  }
		  }
	  }
	  
	  
	  //非递归后序遍历
	  public void postOder(){
		  System.out.print("postOder非递归后序遍历:");  
		  TreeNode rNode = null;  
		  TreeNode current = root;  
		  Stack<TreeNode> stack = new Stack<TreeNode>(); 
	        while(current != null || !stack.isEmpty()) {  
	            while(current != null) {  
	                stack.push(current);  
	                current = current.getLeft();  
	            }  
	            current = stack.pop();  
	            while (current != null && (current.getRight() == null ||current.getRight() == rNode)) {  
	                System.out.print(current.getData());  
	                rNode = current;  
	                if (stack.isEmpty()){  
	                    System.out.println();  
	                    return;  
	                }  
	                current = stack.pop();  
	            }  
	            stack.push(current);  
	            current = current.getRight();  
	        } 
	  }
}
