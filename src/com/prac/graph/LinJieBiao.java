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
	
	//无向图的邻接表创建,有向图也是一样的，不过要注意弧头弧尾的问题
	public void createGraghWX(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入顶点个数和边的条数：");
		this.vNum = scan.nextInt();
		vertexNode = new VertexNode[vNum];//初始化，要不然后面要用的时候还是null
		visited = new boolean[vNum];//初始化，要不然后面要用的时候还是null
		this.eNum = scan.nextInt();
		//给所有的顶点赋值
		for(int i=0;i<vNum;i++){
			System.out.println("请输入顶点值：");
			String data = scan.next();
			System.out.println(vertexNode[i]+"  "+data);
			vertexNode[i] = new VertexNode(data);
		}
		//给边表赋值
		for(int j=0;j<eNum;j++){
			EdgeNode e = new EdgeNode();
			System.out.println("请输入（vi,vj）边上的顶点序号：");
			int vi = scan.nextInt();
			int vj = scan.nextInt();
		//	int weight = scan.nextInt();
			
			//单链表总的头插法，这里使用头插法最好，不用去找邻接表上最后一个结点的next
			e.setAdjvex(vj);//邻接序号是vj
		//	e.setWeight(weight);
			e.setNext(vertexNode[vi].getFirstNode());//让e指向原来firstNode指向的
			vertexNode[vi].setFirstNode(e);//在让firstNode指向e
			
			e = new EdgeNode();//这两个顶点的边表都要做相应的操作
			e.setAdjvex(vi);
		//	e.setWeight(weight);
			e.setNext(vertexNode[vj].getFirstNode());
			vertexNode[vj].setFirstNode(e);
		}
	}

	//判断是否为空
	public boolean isEmpty(){
		boolean b = true;
		if(vertexNode.length>0){
			b=false;
		}
		return b;
	}
	
	//邻接表的深度遍历操作
	public void DFSTraverse(){
		int i;
		for(i=0;i<vNum;i++){
			visited[i]=false;//初始化  把所有的顶点都设成未访问的状态
		}
		for(i=0;i<vNum;i++){
			if(!visited[i]){	//如果这个顶点没有被访问过
				DFS(i);	//对没有访问过的顶点深度遍历
			}
		}
	}
	//邻接表的深度优先递归算法(类似树的前序遍历)
	public void DFS(int i){
		visited[i] = true;//把这个顶点设成以访问状态
		System.out.print(vertexNode[i].getData()+"  ");
		EdgeNode p = vertexNode[i].getFirstNode();//第i个顶点的第一个结点
		while(p!=null){
			if(!visited[p.getAdjvex()]){//如果p.getAdjvex这个顶点没访问过的话
				DFS(p.getAdjvex());//去访问i顶点的这一个邻接点
			}
			p = p.getNext();//要是访问过了就访问邻接表上的下一个
		}
	}
	
	/*
	 * 邻接表的广度优先算法
	 * 
	 * */
	public void BFS(){
		int i;
		EdgeNode p = new EdgeNode();
		SqQueue sq = new SqQueue(10);
		for(i=0;i<vNum;i++){//首先把所有顶点设为未访问
			visited[i]=false;
		}
		for(i=0;i<vNum;i++){//一个顶点一个顶点的循环的
			if(!visited[i]){
				visited[i]=true;
				System.out.print(vertexNode[i].getData()+" ");
				sq.add(vertexNode[i].getData());//将访问的这个这个顶点放入队列
				while(!sq.isEmpty()){//要是队列不为空
					sq.delete();//删除队列中排第一的结点
					System.out.println(sq.isEmpty());
				//	sq.print();
					p = vertexNode[i].getFirstNode();//这个顶点的第一个结点
					while(p!=null){
						if(!visited[p.getAdjvex()]){//如果没有访问过，就去访问，如果访问过了就去下一个结点
							visited[p.getAdjvex()] = true;
							System.out.print(vertexNode[p.getAdjvex()].getData()+" ");
							sq.add(vertexNode[p.getAdjvex()].getData());//把这个没访问过的顶点加到队列中
						}
						p = p.getNext();//邻接表的下一个结点
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
