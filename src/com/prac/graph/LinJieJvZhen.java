package com.prac.graph;

import java.util.Scanner;

import com.prac.queue.SqQueue;

public class LinJieJvZhen {

	private int maxvex = 20;
	private VertexNode[] vertexNode;//�����
	private int vNum;//������
	private int eNum;//����
	private Integer[][] obj;//��ά������ɿ����߱�
	private Boolean[] visited;
	
	Scanner scan = new Scanner(System.in);
	
	public LinJieJvZhen(){
		
	}
	
	/*
	 * �����ڽӾ���
	 * 
	 * */
	public void create(int vNum,int eNum){
		this.vNum = vNum;
		this.eNum = eNum;
		vertexNode = new VertexNode[vNum];//�����ʼ��
		obj = new Integer[vNum][vNum];//���Ǹ������ʼ��
		visited = new Boolean[vNum];
		for(int i=0;i<vNum;i++){ 	//�����㸳ֵ
			System.out.println("���붥��ֵ��");
			String data = scan.next();
			vertexNode[i].setData(data);
		}
		
		for(int i=0;i<vNum;i++){	//���Ǹ�����ֵ
			for(int j=0;j<vNum;j++){
				System.out.println("���루vi��vj����ֵ��");
				int vij = scan.nextInt(); 
				obj[i][j] = vij;
			//	obj[j][i] = vij;	����ͼ�ǶԳƵģ����Կ�������������ͼ��һ��һ����
			}
		}
	}
	
	
	
	/*
	 * �ڽӾ����������ȱ����㷨
	 * */
	public void DFSTraverse(){
		for(int j = 0;j<vNum;j++){
			visited[j] = false;
		}
		for(int j = 0;j<vNum;j++){
			if(!visited[j]){
				DFS(j);
			}
		}
	}
	/*
	 * �ڽӾ����������ȵݹ��㷨
	 * */
	public void DFS(int i){
		int j;
		visited[i] = true;
		System.out.println(vertexNode[i]+" ");
		for(j = 0;j<vNum;j++){
			if(obj[i][j] == 1 && !visited[j]){
				DFS(j);
			}
		}
	}
	
	
	/*
	 * �ڽӾ���Ĺ�ȱ����㷨
	 * 
	 * */
	public void BFS(){
		int i,j;
		EdgeNode p = new EdgeNode();
		SqQueue sq = new SqQueue(10);
		for(i = 0;i<vNum;i++){
			if(!visited[i]){
				visited[i]=true;
				System.out.print(vertexNode[i]);
				sq.add(vertexNode[i]);
				while(!sq.isEmpty()){
					sq.delete();
					for(j=0;j<vNum;j++){
						if(obj[i][j] == 1 && !visited[j]){
							visited[j]=true;
							System.out.println(vertexNode[j]);
							sq.add(vertexNode[j]);
						}
					}
				}
			}
		}
	}
	
	//��С�������㷨
	public void prim(){
		int min,i,j,k;
		int adjvex[]=new int[maxvex];	//prim��С���Ľ������
		int lowcost[]=new int[maxvex];	//�����ŵ�i�����������������Ȩֵ
		lowcost[0]=0;	//��Ϊ����Ĭ���Ǵ�0��ʼ�ģ�����������ɡ�0��
		adjvex[0]=0;	//��ʼ����һ����������Ϊ0
		for(i=1;i<vNum;i++){	//��Ҫ���Ǹ�lowcost��ֵ��
			lowcost[i]=obj[0][i]; 	//��Ϊ�ӵ�0�п�ʼ��
			adjvex[i]=0;	//��ʼ����Ϊv0���±�
		}
		for(i=1;i<vNum;i++){
			min = 65535;	//ͨ������Ϊ�����ܵĴ�����
			j=1;
			k=0;	//��Ϊ�����Ǵӵ�0�����㿪ʼ��
			while(j<vNum){
				if(lowcost[j] != 0 && lowcost[j] < min){
					min = lowcost[j];
					k = j;
				}
				j++;	//��֮��ص���һ������
			}
			System.out.println(adjvex[k]+"  "+k);
			lowcost[k] = 0;	//����������е�k������0��ʾ��������Ѿ����ʹ���
			for(j=1;j<vNum;j++){	//ȥ����k����һ����СȨֵ��Ӧ�±�Ķ��㣩��
				if(lowcost[j] != 0 && obj[k][j] < lowcost[j]){	//�õ�k���������������֮���Ȩֵ��lowcost���Աȣ�
					lowcost[j] = obj[k][j];	//��lowcostС�ľ��ð�lowcost�еĸ�Ϊ��С����һ��
					k = j;
				}
			}
		}
	}
	
	
	public void Dijkstra(){
		
	}
}

