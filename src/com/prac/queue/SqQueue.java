package com.prac.queue;

/*
 * 队列顺序存储
 * 循环队列顺序存储
 * */
public class SqQueue {

	private Object obj[];
	private int maxsize;
	private int size;// 表示当前长度
	private int defaultSize = 10;// 表示最大长度

	private int front; // 做循环队列时需要的两个
	private int rear;

	// 初始化队列
	public SqQueue(int maxsize) {
		obj = new Object[maxsize];
		this.maxsize = maxsize;
		size = 0;

		front = 0;
		rear = 0;
	}

	public SqQueue() {
		obj = new Object[defaultSize];
		size = 0;
	}

	// 插入一个数据
	public void add(Object data) {
		if (size < maxsize) {
			obj[size] = data;
			size++;
		} else {
			System.out.println("满了");
		}
	}

	//判断队列是否为空,不为空的时候为true
	public boolean isEmpty(){
		boolean b=false;
		if(size<=1){
			b=true;
		}
		return b;
	}
	// 删除队列元素
	public void delete() {
		if (size > 1) {
			for (int i = 0; i < size - 1; i++) { // 这里是size-1 不是size
				obj[i] = obj[i + 1];
			}
			size--;
		} else {
			obj[0] = null;
			size--;
		}
	}

	// 输出数据
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(obj[i] + " ");
		}
		System.out.println();
	}
	
	
	

	// 循环队列时候的长度
	public int qlength() {
		return (rear - front + maxsize)%maxsize;
	}
	// 循环队列时候添加元素
	public void addRe(Object data){
		if((rear+1)%maxsize == front){
			System.out.println("满了");
		}else{
			obj[rear]=data;
			System.out.print(obj[rear]+" ");
		//	System.out.println("rear="+rear+" front="+front+" obj[] "+obj.length);
			rear=(rear+1)%maxsize;
		}
	}
	
	//循环队列时候删除元素
	public void deleteRe(){
		if(front==rear){
			System.out.println("mei de shan");
		}
		Object o = obj[front];
		front=(front+1)%maxsize;
		System.out.println(o);
	}
}
