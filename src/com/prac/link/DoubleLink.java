package com.prac.link;

public class DoubleLink<E> {
	private int size;//���Ա�ǰ����
	private Node<E> tail;//ָ�����Ա����һ�����
	private Node<E> firstNode;//ָ���һ������ָ�룬���Ǳ���ͷ���
	
	public DoubleLink(Node<E> firstNode,Node<E> tail){
		this.firstNode=firstNode;
		this.tail=tail;
	}
	public DoubleLink(){
		
	}
	
	//����Ԫ��
	public void insert(int i,Object obj){
		Node<E> e=new Node<E>(obj,firstNode.getPre(),firstNode.getNext());
		if(i<1 || i>size+1){
			System.out.println("insert λ�ò��Ϸ���");
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
	//ɾ��һ��Ԫ��
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
				System.out.println("λ�ò��Ϸ���");
			}
		}else{
			System.out.println("delete ����������");
		}
	}
	//��������Ԫ��
	public void print(){
		Node<E> node=firstNode.getNext();
		for(int i=0;i<size;i++){
			System.out.print(node+" ");	
			node=node.next();
		}
		System.out.println();
	}
	//�ж������Ƿ����
	public boolean isEmpity(){
		boolean b=false;
		if(firstNode!=null){
			b=true;
		}		
		return b;
	}
	//���ҵ�i��Ԫ�ص�����
	public Node<E> serch(int i){
		Node<E> node=firstNode.getNext();//��ʱ���node���ǵ�һ�������
		if(i<1 || i>size+1 || isEmpity()==false){
			System.out.println("serch��λ�ò��Ϸ�����");
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
