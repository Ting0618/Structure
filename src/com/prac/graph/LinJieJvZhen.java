package com.prac.graph;

import java.util.Scanner;

import com.prac.queue.SqQueue;

public class LinJieJvZhen {

	private int maxvex = 20;
	private VertexNode[] vertexNode;//顶点表
	private int vNum;//顶点数
	private int eNum;//边数
	private Integer[][] obj;//二维数组嘛，可看作边表
	private Boolean[] visited;
	
	Scanner scan = new Scanner(System.in);
	
	public LinJieJvZhen(){
		
	}
	
	/*
	 * 创建邻接矩阵
	 * 
	 * */
	public void create(int vNum,int eNum){
		this.vNum = vNum;
		this.eNum = eNum;
		vertexNode = new VertexNode[vNum];//顶点初始化
		obj = new Integer[vNum][vNum];//给那个矩阵初始化
		visited = new Boolean[vNum];
		for(int i=0;i<vNum;i++){ 	//给顶点赋值
			System.out.println("输入顶点值：");
			String data = scan.next();
			vertexNode[i].setData(data);
		}
		
		for(int i=0;i<vNum;i++){	//给那个矩阵赋值
			for(int j=0;j<vNum;j++){
				System.out.println("输入（vi，vj）的值：");
				int vij = scan.nextInt(); 
				obj[i][j] = vij;
			//	obj[j][i] = vij;	无向图是对称的，所以可以这样，有向图就一个一个赋
			}
		}
	}
	
	
	
	/*
	 * 邻接矩阵的深度优先遍历算法
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
	 * 邻接矩阵的深度优先递归算法
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
	 * 邻接矩阵的广度遍历算法
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
	
	//最小生成树算法
	public void prim(){
		int min,i,j,k;
		int adjvex[]=new int[maxvex];	//prim最小树的结果数组
		int lowcost[]=new int[maxvex];	//用来放第i个顶点与各个顶点间的权值
		lowcost[0]=0;	//因为我们默认是从0开始的，所以这里设成【0】
		adjvex[0]=0;	//初始化第一个顶点坐标为0
		for(i=1;i<vNum;i++){	//主要就是给lowcost赋值的
			lowcost[i]=obj[0][i]; 	//因为从第0行开始的
			adjvex[i]=0;	//初始化都为v0的下标
		}
		for(i=1;i<vNum;i++){
			min = 65535;	//通常设置为不可能的大数字
			j=1;
			k=0;	//因为我们是从第0个顶点开始的
			while(j<vNum){
				if(lowcost[j] != 0 && lowcost[j] < min){
					min = lowcost[j];
					k = j;
				}
				j++;	//与之相关的下一个顶点
			}
			System.out.println(adjvex[k]+"  "+k);
			lowcost[k] = 0;	//把这个数组中第k个赋成0表示这个顶点已经访问过了
			for(j=1;j<vNum;j++){	//去到第k（上一次最小权值对应下标的顶点）行
				if(lowcost[j] != 0 && obj[k][j] < lowcost[j]){	//用第k个顶点与各个顶点之间的权值与lowcost做对比，
					lowcost[j] = obj[k][j];	//比lowcost小的就用把lowcost中的该为更小的哪一个
					k = j;
				}
			}
		}
	}
	
	
	public void Dijkstra(){
		
	}
}

