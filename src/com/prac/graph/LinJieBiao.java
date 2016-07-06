package com.prac.graph;

import java.util.Scanner;

import com.prac.queue.SqQueue;

public class LinJieBiao {

	private VertexNode[] vertexNode;
	private EdgeNode edgeNode;
	boolean visited[];
	private int vNum;
	private int eNum;
	
	public LinJieBiao(){
		
	}
	
	//����ͼ���ڽӱ���,����ͼҲ��һ���ģ�����Ҫע�⻡ͷ��β������
	public void createGraghWX(){
		Scanner scan = new Scanner(System.in);
		System.out.println("�����붥������ͱߵ�������");
		this.vNum = scan.nextInt();
		vertexNode = new VertexNode[vNum];//��ʼ����Ҫ��Ȼ����Ҫ�õ�ʱ����null
		visited = new boolean[vNum];//��ʼ����Ҫ��Ȼ����Ҫ�õ�ʱ����null
		this.eNum = scan.nextInt();
		//�����еĶ��㸳ֵ
		for(int i=0;i<vNum;i++){
			System.out.println("�����붥��ֵ��");
			String data = scan.next();
			System.out.println(vertexNode[i]+"  "+data);
			vertexNode[i] = new VertexNode(data);
		}
		//���߱�ֵ
		for(int j=0;j<eNum;j++){
			EdgeNode e = new EdgeNode();
			System.out.println("�����루vi,vj�����ϵĶ�����ţ�");
			int vi = scan.nextInt();
			int vj = scan.nextInt();
		//	int weight = scan.nextInt();
			
			//�������ܵ�ͷ�巨������ʹ��ͷ�巨��ã�����ȥ���ڽӱ������һ������next
			e.setAdjvex(vj);//�ڽ������vj
		//	e.setWeight(weight);
			e.setNext(vertexNode[vi].getFirstNode());//��eָ��ԭ��firstNodeָ���
			vertexNode[vi].setFirstNode(e);//����firstNodeָ��e
			
			e = new EdgeNode();//����������ı߱�Ҫ����Ӧ�Ĳ���
			e.setAdjvex(vi);
		//	e.setWeight(weight);
			e.setNext(vertexNode[vj].getFirstNode());
			vertexNode[vj].setFirstNode(e);
		}
	}

	//�ж��Ƿ�Ϊ��
	public boolean isEmpty(){
		boolean b = true;
		if(vertexNode.length>0){
			b=false;
		}
		return b;
	}
	
	//�ڽӱ����ȱ�������
	public void DFSTraverse(){
		int i;
		for(i=0;i<vNum;i++){
			visited[i]=false;//��ʼ��  �����еĶ��㶼���δ���ʵ�״̬
		}
		for(i=0;i<vNum;i++){
			if(!visited[i]){	//����������û�б����ʹ�
				DFS(i);	//��û�з��ʹ��Ķ�����ȱ���
			}
		}
	}
	//�ڽӱ��������ȵݹ��㷨(��������ǰ�����)
	public void DFS(int i){
		visited[i] = true;//�������������Է���״̬
		System.out.print(vertexNode[i].getData()+"  ");
		EdgeNode p = vertexNode[i].getFirstNode();//��i������ĵ�һ�����
		while(p!=null){
			if(!visited[p.getAdjvex()]){//���p.getAdjvex�������û���ʹ��Ļ�
				DFS(p.getAdjvex());//ȥ����i�������һ���ڽӵ�
			}
			p = p.getNext();//Ҫ�Ƿ��ʹ��˾ͷ����ڽӱ��ϵ���һ��
		}
	}
	
	/*
	 * �ڽӱ�Ĺ�������㷨
	 * 
	 * */
	public void BFS(){
		int i;
		EdgeNode p = new EdgeNode();
		SqQueue sq = new SqQueue(10);
		for(i=0;i<vNum;i++){//���Ȱ����ж�����Ϊδ����
			visited[i]=false;
		}
		for(i=0;i<vNum;i++){//һ������һ�������ѭ����
			if(!visited[i]){
				visited[i]=true;
				System.out.print(vertexNode[i].getData()+" ");
				sq.add(vertexNode[i].getData());//�����ʵ�����������������
				while(!sq.isEmpty()){//Ҫ�Ƕ��в�Ϊ��
					sq.delete();//ɾ���������ŵ�һ�Ľ��
					System.out.println(sq.isEmpty());
				//	sq.print();
					p = vertexNode[i].getFirstNode();//�������ĵ�һ�����
					while(p!=null){
						if(!visited[p.getAdjvex()]){//���û�з��ʹ�����ȥ���ʣ�������ʹ��˾�ȥ��һ�����
							visited[p.getAdjvex()] = true;
							System.out.print(vertexNode[p.getAdjvex()].getData()+" ");
							sq.add(vertexNode[p.getAdjvex()].getData());//�����û���ʹ��Ķ���ӵ�������
						}
						p = p.getNext();//�ڽӱ����һ�����
					}
				}
			}
		}
	}
	
	
	public EdgeNode getEdgeNode() {
		return edgeNode;
	}
	public void setEdgeNode(EdgeNode edgeNode) {
		this.edgeNode = edgeNode;
	}
	
}
