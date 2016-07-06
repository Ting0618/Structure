package com.prac.link;

public class NodeList<E> {

	private int size;//线性表当前长度
	private Node<E> tail;//指向线性表最后一个结点
	private Node<E> firstNode;//指向第一个结点的指针，就是保存头结点
	public NodeList(Node<E> firstNode,Node<E> tail){
		this.firstNode=firstNode;
	//	tail = new Node<E>();
		this.tail=tail;
	}
	//单链表的插入   在第i个位置插入obj
	public void insert(int i,Object obj){
	//	Node<E> node=firstNode.getNext();//这时候的node就是第一个结点了
		Node<E> e=new Node<E>(obj,firstNode.getNext());
		if(i<1 || i>size+1){
			System.out.println("insert() 该位置不合法！！");
		}
		if(i==1){
			firstNode.setNext(e);
			tail.setNext(e);
			size++;
		}
		else{			
			Node<E> per = serch(i-1);
			Node<E> node= serch(i);
			System.out.println("node "+node);
		//	e.setNext(per.getNext().next());
			per.setNext(e);
			e.setNext(node);	
		//	System.out.println(per+"  "+e+" "+e.next());
			size++;
		}
	}
	//删除第i个结点
	public void delete(int i){
		//链表存在的话
		if(isEmpity()){
			if(i<1 || i>size){
				System.out.println("delete 位置错误");
			}
			if(i==1){
				Node<E> e = firstNode.getNext();
				firstNode.setNext(e.getNext());
				size--;
			//	firstNode.setNext(null);
			}
			else{
				Node<E> p = serch(i-1);
				Node<E> e = serch(i);
				Node<E> q = serch(i+1);
				p.setNext(q);
				q=e.getNext();				
				size--;
			}
		}
		else{
			System.out.println("链表不存在");
		}
	}
	
	//判断链表是否为空  true 链表存在    false 链表不存在
	public boolean isEmpity(){
		boolean b=false;
		if(firstNode!=null){
			b=true;
		}		
		return b;
	}
	//查找第i个元素的数据
	public Node<E> serch(int i){
		Node<E> node=firstNode.getNext();//这时候的node就是第一个结点了
		if(i<1 || i>size+1 || isEmpity()==false){
			System.out.println("serch该位置不合法！！");
		}
		else{
	//		System.out.println("serch else ");
			for(int j=1;j<i;j++){
				node=node.getNext();	
			//	node.setNext(node);
			}
		}
		return node;
	}
	
	//采用尾插法为创建链表
	public void add(Object obj){
		if(isEmpity()){
			Node<E> n = new Node<E>();
			Node<E> e=new Node<E>(obj,n);
			if(size==0){	
				firstNode.setNext(e);
				tail.setNext(e);
				tail=e;
				size++;
			}
			else{
				Node<E> p = tail.getNext();
				p.setNext(e);
				tail.setNext(e);
				tail=e;
				System.out.println(tail);
				size++;				
				
				/*for(int i=0;i<size;i++){
					p=p.next();
				}
				tail.setNext(e);
				System.out.println("first "+firstNode.next());
				System.out.println("tail e"+tail.next());
				size++;*/
				
			}
		}
		else{
			System.out.println("add 链表不存在！！");
		}
	}
	
	//用头插法创建链表
	public void headAdd(Object obj){
		Node<E> n = new Node<E>();
		Node<E> e=new Node<E>(obj,n);//将数据放到e这个结点中，让e的next指向某个节点而不是null
		if(isEmpity()){
			if(size==0){
				e.setNext(firstNode.getNext());
				firstNode.setNext(e);
				tail.setNext(e);
				tail=e;
				size++;
			}else{
				e.setNext(firstNode.getNext());
				firstNode.setNext(e);
				size++;
				System.out.println("tail "+tail+" e "+e);
			}
			
		}else{
			System.out.println("链表不存在！");
		}
	}
	//删除整个链表
	public void destroy(){
		if(isEmpity()){
			for(int i=size;i>0;i--){
				this.delete(i);
			}
			System.out.println("链表删除咯~~~");
		}else{
			System.out.println("该链表不存在！");
		}
	}
	//输出链表的元素
	public void print(){
		Node<E> node=firstNode.getNext();
		for(int i=0;i<size;i++){
			System.out.print(node+" ");	
			node=node.next();
		}
		System.out.println();
	}
}
