package com.prac.suanfa;

import com.prac.link.SequenceList;
import com.prac.tree.TreeNode;

public class SearchAndSort {

	/*二分查找      key是要查找的对象，n是元素个数  nl是一个有序的线性表返回该key所在的位置 */	
	public int Binary_Search(int key,int n,int[] nl){
		int low,high,mid;
		low = 1;	//最左边的下标，我们从1开始
		high = n;	//最右边的下标
		while(low <= high){		//最左边和最右边的不在同一个地方的时候
			mid = (low+high)/2;		
			if(key < nl[mid]){	//比中间的小就去左边继续找
				high = mid - 1;
			}
			else if(key > nl[mid]){
				low = mid + 1;
			}
			else{
				return mid;
			}
		}
		return 0;
	}
	
	
	//二叉排序树  查找操作    T代表的是顶点  key是要查找的数（自身原因，所以不是整型） f为T的双亲  p指向该数据元素
	public boolean SearchBST(TreeNode T,Integer key,TreeNode f,TreeNode p){
		if(T == null){	//
			p = f ;	//也可以不要这个
			return false;
		}
		else if(key == (Integer)T.getData()){
			p = T;	//也可以不要这个
			return true;
		}
		else if(key < (Integer)T.getData()){	//key比顶点值小，就走左边
			if(T.getLeft() != null){	//一定要判断，因为T是叶子结点的时候没有孩子，会报空指针错误
				return SearchBST(T.getLeft(),key,T,p);//递归查询
			}
			else return false;//t为叶子结点的时候不论key比这个T大还是小，都表示这颗二叉树上没有key
		}
		else{
			if(T.getRight() != null){	//key比顶点值大，就走右边
				return SearchBST(T.getRight(),key,T,p);
			}
			else return false;
		}
	}
	
	
	//二叉排序树插入操作   成功插入返回true  道理同查找
	public boolean insertBST(TreeNode T,Integer key){
		if(T == null){
			return false;
		}
		else if(key < (Integer)T.getData()){
			if(T.getLeft() != null){
				return insertBST(T.getLeft(),key);
			}
			else{
				TreeNode e = new TreeNode(key);
				T.setLeft(e);
				return true;
			}
		}
		else if(key > (Integer)T.getData()){
			if(T.getRight() != null){
				return insertBST(T.getRight(),key);
			}
			else{
				TreeNode e = new TreeNode(key);
				T.setRight(e);
				return true;
			}
		}
		else return false;
	}
	
	
	//二叉排序树删除操作
	public boolean deleteBST(TreeNode T,Integer key){
		if(T == null){
			return false;
		}
		else{
			if(key == (Integer)T.getData()){	//key为T的数据，直接删除
				return delete(T);
			}
			else if(key < (Integer)T.getData()){	//key在T的左边
				return deleteBST(T.getLeft(),key);	//递归查找T左边的顶点
			}
			else{
				return deleteBST(T.getRight(),key);	//递归查找T右边的顶点
			}
		}
	}
	//二叉排序树删除操作
	private boolean delete(TreeNode p) {	//要删除的顶点p
		// TODO Auto-generated method stub
		TreeNode q,s;	//临时变量
		if(p.getRight() ==null){	//顶点没有右孩子，
			q = p;	//临时存储q
			p = p.getLeft();	//则删除p后其左孩子替代原来的位置
		}
		else if(p.getLeft() ==null){
			q = p;
			p = p.getRight();
			q = null;
		}
		else{	//既有右孩子，又有左孩子的
			q = p;
			s = p.getLeft();	//p的左孩子赋值给s
			while(s.getRight() != null){	//一直找到顶点左边最大的那个数，这个数大小是和顶点最接近的
				q = s;	//此时的q指向s的前一个点，也就是s的双亲
				s = s.getRight();	//此时的s指向的是那个最接近顶点的数
			}
			p.setData(s.getData());//用s的值去替代要删除的顶点p
			if(q != p){	//s的双亲q如果不是p的话
				q.setRight(s.getLeft());//把s的左孩子赋给q，s现在没有右孩子了
			}
			else{
				q.setLeft(s.getLeft());//同理，
			}
		}
		return true;
	}
	
	
	
	//冒泡排序  s为需要排序的数组
	public void BubbleSort1(int[] s){
		int i,j;
		for(i = 1;i<s.length;i++){
			for(j=s.length-1;j<i;j--){
				if(s[j]>s[j+1]){
					//把s[j]和s[j+1]的位置互换
					int t = s[j];
					s[j] = s[j+1];
					s[j+1] = t;
				}
			}
		}
	}
	
	//改进的冒泡算法
	public void BubbleSort2(int[] s){
		int i,j;
		boolean flag = true;
		for(i=1;i<s.length && flag;i++){	//falg为false的时候会退出循环
			flag = false;
			for(j=s.length-1;j<i;j--){
				int t = s[j];	//把s[j]和s[j+1]的位置互换
				s[j] = s[j+1];
				s[j+1] = t;
				flag = true;	//如果有数据交换，则flag为true
			}
		}
	}
	
	/**
	 * 简单选择排序
	 * @param s 一个数组
	 */
	public void selectSort(int[] s){
		int i,j,min;
		for(i=1;i<s.length;i++){
			min=i;
			for(j=i+1;j<s.length;j++){
				if(s[min]>s[j]){	//j的值比min小，min是最小值的下标
					min=j;
				}
			}
			if(i !=min){	//说明找到最小值，把小的值放前面
				//s[i]和s[min]交换位置
				swap(s,i,min);
			}
		}
	}
	
	/**
	 * 给s[i]和s[j]交换位置
	 */
	public void swap(int[] s,int i,int j){
		int t = s[i];	//把s[j]和s[j+1]的位置互换
		s[i] = s[j];
		s[j] = t;
	}
	
	/**
	 * @param a 对数组L作快速排列
	 */
	public void quickSort(int[] a){
		qSort(a,1,a.length);
	}
	
	/**
	 * 对数组a的子序列a[low....high]做快速排序
	 * @param low
	 * @param high
	 */
	public void qSort(int[] a,int low,int high){
		int pivot;
		if(low<high){
			pivot = partition(a,low,high);	//将a[low...high]一分为二 得出枢轴值
			qSort(a,low,pivot-1);	//对低的那个子表进行排序
			qSort(a,pivot-1,high);	//对高的那个子表进行排序
		}
	}
	
	/**
	 * 交换a中数据的记录，使之有序
	 * @return 返回枢轴记录的位置
	 */
	public int partition(int[] a,int low,int high){
		int pivotkey;
		pivotkey = a[low];	//先用第一个记录当枢轴记录
		while(low<high){
			while(low<high && a[high]>=pivotkey)//从高位开始，数组中比pivotkey小的都在他的左边
				high--;	
			swap(a,low,high);  //否则把比 pivotkey 还小的数放到左边
			while(low<high && a[low]<=pivotkey)	//一个一个找，然后把比 pivotkey 大的 都放右边
				low++;
			swap(a,low,high);
		}
		return low;
	}
}
