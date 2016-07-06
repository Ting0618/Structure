package com.prac.queue;

/*
 * ����˳��洢
 * ѭ������˳��洢
 * */
public class SqQueue {

	private Object obj[];
	private int maxsize;
	private int size;// ��ʾ��ǰ����
	private int defaultSize = 10;// ��ʾ��󳤶�

	private int front; // ��ѭ������ʱ��Ҫ������
	private int rear;

	// ��ʼ������
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

	// ����һ������
	public void add(Object data) {
		if (size < maxsize) {
			obj[size] = data;
			size++;
		} else {
			System.out.println("����");
		}
	}

	//�ж϶����Ƿ�Ϊ��,��Ϊ�յ�ʱ��Ϊtrue
	public boolean isEmpty(){
		boolean b=false;
		if(size<=1){
			b=true;
		}
		return b;
	}
	// ɾ������Ԫ��
	public void delete() {
		if (size > 1) {
			for (int i = 0; i < size - 1; i++) { // ������size-1 ����size
				obj[i] = obj[i + 1];
			}
			size--;
		} else {
			obj[0] = null;
			size--;
		}
	}

	// �������
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(obj[i] + " ");
		}
		System.out.println();
	}
	
	
	

	// ѭ������ʱ��ĳ���
	public int qlength() {
		return (rear - front + maxsize)%maxsize;
	}
	// ѭ������ʱ�����Ԫ��
	public void addRe(Object data){
		if((rear+1)%maxsize == front){
			System.out.println("����");
		}else{
			obj[rear]=data;
			System.out.print(obj[rear]+" ");
		//	System.out.println("rear="+rear+" front="+front+" obj[] "+obj.length);
			rear=(rear+1)%maxsize;
		}
	}
	
	//ѭ������ʱ��ɾ��Ԫ��
	public void deleteRe(){
		if(front==rear){
			System.out.println("mei de shan");
		}
		Object o = obj[front];
		front=(front+1)%maxsize;
		System.out.println(o);
	}
}
