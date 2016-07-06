package com.prac.link;

public class SequenceList<T> {

	private int defaultSize =20;
	private int maxSize;//线性表的最大长度
	private Object[] element;//定义一个数组用于保存顺序线性表的元素
	private int size;//线性表当前长度
	
	//初始化线性表   没有说要多大的就给一个默认的
	public SequenceList(){
		size = 0;
		element = new Object[defaultSize];
	}
	
	//初始化给定长度的线性表
	public SequenceList(int giveSize){
		size = 0;
		maxSize=giveSize;
		element = new Object[giveSize];
	}
	//在线性表的指定位置插入一个值
	public void insertElement(int i,Object obj)throws Exception{
		int ok=0;
		if(size == maxSize){
			throw new Exception("表已满");
		}
		if(i<1 || i>size+1){	//线性表的位置是从1开始的
			throw new Exception("插入位置不合法");
		}
		if(i<=size){
		//	System.out.println("here");
			for(int j=size-1;j>=i-1;j--){
				element[j+1]=element[j];
		//		System.out.println("element"+j+element[j]);
			}			
		}
		element[i-1]=obj;
		size++;
		/*for(int y=0;y<size;y++){
			System.out.println("element"+y+"  "+element[y]);
		}*/
	}
	
	
	
	public void print() {
		for(int y=0;y<size;y++){
			System.out.print(element[y]+"  ");
		}
		System.out.println();
	}

	//删除第i个元素
	public void deleteElement(int i)throws Exception{
		if(size<0){
			throw new Exception("链表不存在");
		}
		if(i>size || i<1){
			throw new Exception("该位置不合法");
		}
		if(i<size){
			for(int j=i;j<size;j++){
				element[j-1]=element[j];
			}
		}
		size--;
	}
	
	public int getSize(){
		return size;
	}
	
}
