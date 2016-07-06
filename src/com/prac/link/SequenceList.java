package com.prac.link;

public class SequenceList<T> {

	private int defaultSize =20;
	private int maxSize;//���Ա����󳤶�
	private Object[] element;//����һ���������ڱ���˳�����Ա��Ԫ��
	private int size;//���Ա�ǰ����
	
	//��ʼ�����Ա�   û��˵Ҫ���ľ͸�һ��Ĭ�ϵ�
	public SequenceList(){
		size = 0;
		element = new Object[defaultSize];
	}
	
	//��ʼ���������ȵ����Ա�
	public SequenceList(int giveSize){
		size = 0;
		maxSize=giveSize;
		element = new Object[giveSize];
	}
	//�����Ա��ָ��λ�ò���һ��ֵ
	public void insertElement(int i,Object obj)throws Exception{
		int ok=0;
		if(size == maxSize){
			throw new Exception("������");
		}
		if(i<1 || i>size+1){	//���Ա��λ���Ǵ�1��ʼ��
			throw new Exception("����λ�ò��Ϸ�");
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

	//ɾ����i��Ԫ��
	public void deleteElement(int i)throws Exception{
		if(size<0){
			throw new Exception("��������");
		}
		if(i>size || i<1){
			throw new Exception("��λ�ò��Ϸ�");
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
