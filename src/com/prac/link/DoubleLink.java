package com.prac.link;

public class DoubleLink<E> {
	private int size;//线性表当前长度
	private Node<E> tail;//指向线性表最后一个结点
	private Node<E> firstNode;//指向第一个结点的指针，就是保存头结点
	
	public DoubleLink(Node<E> firstNode,Node<E> tail){
		this.firstNode=firstNode;
		this.tail=tail;
	}
	public DoubleLink(){
		
	}
	
	//插入元素
	public void insert(int i,Object obj){
		Node<E> e=new Node<E>(obj,firstNode.getPre(),firstNode.getNext());
		if(i<1 || i>size+1){
			System.out.println("insert 位置不合法！");
		}else{
			if(size==0){
				firstNode.setNext(e);
				e.setPre(firstNode);
				size++;
			}else{
				Node<E> qian = serch(i-1);
				Node<E> hou= serch(i);				
				e.setPre(qian);
				e.setNext(hou);
				if(hou!=  null){
					hou.setPre(e);
				}
				qian.setNext(e);
				size++;
			//	System.out.print(e);
			}
		}
	}
	//删除一个元素
	public void delete(int i){
		if(isEmpity()){
			if(i>1 || i<size+1){
				if(i==1){
					firstNode.setNext(null);
					size--;
				}else{
					Node<E> qian = serch(i-1);
					Node<E> hou= serch(i+1);
					qian.setNext(hou);
					if(hou!=null){					
						hou.setPre(qian);
					}					
					size--;
				}
			}else{
				System.out.println("位置不合法！");
			}
		}else{
			System.out.println("delete 不存在链表！");
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
	//判断链表是否存在
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
			for(int j=1;j<i;j++){
				node=node.getNext();	
			//	node.setNext(node);
			}
		}
		return node;
	}
}
