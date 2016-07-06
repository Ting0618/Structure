package com.prac.tree;

import java.util.Scanner;
import java.util.Stack;

public class Tree {

	Scanner scan = new Scanner(System.in);
	TreeNode root ;	//���ڵ㣬ͨ�������ұ�Ľ��
	
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
	
	//�������չ������������ĳ�������ֶ������
	public TreeNode create(TreeNode n){
		System.out.println("����ڵ��ֵ��");
		String data = scan.next();
		if("#".equals(data)){	//����#��ʾû��������
			return null;
		}
		else{
			n = new TreeNode();		//n�ݹ��ʱ���Ϊ�գ�����Ҫ����һ��
			n.setData(data);		//���������ֵ�����´����Ľ��n 
			System.out.println("root.getLeft() "+n.getLeft());//��ʱ��Ϊ�գ���n���ǿ�
			n.setLeft(create(n.getLeft()));	//Ϊn��������  �ǵݹ����ķ���ֵ
			n.setRight(create(n.getRight()));
			return n;	//���ص���һ����㽫���ڴ�����һ���ڵ����/�Һ���
		}
	}
	//ͨ�����鹹�������
	public void createByArray(){
		
	}
	
	//�ֶ������
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
	
	//ͨ��ǰ��ݹ�ķ�ʽ����������   ������
	public void getValue(TreeNode n){
		System.out.println("getValue");
		if(root==null){
			System.out.println("����");
		}else{
			System.out.print(root.getData()+"  ");
			getValue(root.getLeft());
			getValue(root.getRight());
		}
	}
	
	
	//ͨ���ݹ�ķ�ʽ����������
	public void preOrderTraverse(){
	    preOrderTraverse(root);
	}
	
	  private void preOrderTraverse(TreeNode node) {
	//	System.out.println("preOrderTraverse root  "+node);
	    if(node != null){
	/*----ǰ�����-------------------------------------------------------------*/
	      System.out.print(node.getData()+"  ");
	      preOrderTraverse(node.getLeft());	//�ҵ����Ӳ���ӡ����ȥ�����ӣ�û�о�����������Һ���
	      preOrderTraverse(node.getRight());//û�����Ӿ�����������Һ���
	    
	/*----�������-------------------------------------------------------------*/    
	      /*preOrderTraverse(node.getLeft());	//�ҵ����һ������
	      System.out.print(node.getData()+"  ");//�ҵ���ʹ�ӡ
	      preOrderTraverse(node.getRight());//��ӡ������ϸ������Һ���
*/	      
	/*----�������-------------------------------------------------------------*/      
	      /*preOrderTraverse(node.getLeft());	//�ҵ����һ������
	      preOrderTraverse(node.getRight());//��ӡ������ϸ������Һ���
	      System.out.print(node.getData()+"  ");//�ҵ���ʹ�ӡ
*/	    }
	  }
	  
	  
	  //ͨ��ǰ�򲻵ݹ�ķ�ʽ����������
	  public void preOrder(){
		  System.out.println("preOrder");
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  stack.push(root);		//����ջ�ף���root��ʼ��
		  TreeNode node = null;
			  while(!stack.isEmpty()){
				  node=stack.pop();	//��ջ��Ԫ��ȡ�������ظö��󣨣�
				  System.out.print(node.getData()+"  ");//��ӡ�ö�������
				  if(node.getRight()!=null) 
					  stack.push(node.getRight());//��ȡ���Һ��ӣ���������ջ����֤���е��Һ���������֮��ȡ������
				  if(node.getLeft()!=null)
					  stack.push(node.getLeft());//��ȡ���ӣ���������ջ
			  }
	  }
	  
	  //���򲻵ݹ����������
	  public void midOrder(){
		  System.out.println("midOrder");
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  TreeNode current = root;
		  while (current != null || !stack.isEmpty()){//ע��  �����ǻ� 
			  while(current!=null){
				  stack.push(current);//����ǰԪ������ջ
				  current = current.getLeft();//�ҵ���һ�����ӣ�û�����ӵ�ʱ��current=null
			  }
			  if(!stack.isEmpty()){//ջ������ֵ��ʱ��
				  current = stack.pop();//ȡ��ջ��Ԫ�أ�������Ŀ϶������ӣ�ֻҪջ����ֵcurrent�Ͳ���Ϊnull
				  System.out.println(current.getData());
				  current = current.getRight();//
			  }
		  }
	  }
	  
	  
	  //�ǵݹ�������
	  public void postOder(){
		  System.out.print("postOder�ǵݹ�������:");  
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
