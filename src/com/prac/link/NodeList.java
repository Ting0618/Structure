package com.prac.link;

public class NodeList<E> {

	private int size;//���Ա�ǰ����
	private Node<E> tail;//ָ�����Ա����һ�����
	private Node<E> firstNode;//ָ���һ������ָ�룬���Ǳ���ͷ���
	public NodeList(Node<E> firstNode,Node<E> tail){
		this.firstNode=firstNode;
	//	tail = new Node<E>();
		this.tail=tail;
	}
	//������Ĳ���   �ڵ�i��λ�ò���obj
	public void insert(int i,Object obj){
	//	Node<E> node=firstNode.getNext();//��ʱ���node���ǵ�һ�������
		Node<E> e=new Node<E>(obj,firstNode.getNext());
		if(i<1 || i>size+1){
			System.out.println("insert() ��λ�ò��Ϸ�����");
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
	//ɾ����i�����
	public void delete(int i){
		//������ڵĻ�
		if(isEmpity()){
			if(i<1 || i>size){
				System.out.println("delete λ�ô���");
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
			System.out.println("��������");
		}
	}
	
	//�ж������Ƿ�Ϊ��  true �������    false ��������
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
	//		System.out.println("serch else ");
			for(int j=1;j<i;j++){
				node=node.getNext();	
			//	node.setNext(node);
			}
		}
		return node;
	}
	
	//����β�巨Ϊ��������
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
			System.out.println("add �������ڣ���");
		}
	}
	
	//��ͷ�巨��������
	public void headAdd(Object obj){
		Node<E> n = new Node<E>();
		Node<E> e=new Node<E>(obj,n);//�����ݷŵ�e�������У���e��nextָ��ĳ���ڵ������null
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
			System.out.println("�������ڣ�");
		}
	}
	//ɾ����������
	public void destroy(){
		if(isEmpity()){
			for(int i=size;i>0;i--){
				this.delete(i);
			}
			System.out.println("����ɾ����~~~");
		}else{
			System.out.println("���������ڣ�");
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
}
