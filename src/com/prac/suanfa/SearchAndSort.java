package com.prac.suanfa;

import com.prac.link.SequenceList;
import com.prac.tree.TreeNode;

public class SearchAndSort {

	/*���ֲ���      key��Ҫ���ҵĶ���n��Ԫ�ظ���  nl��һ����������Ա��ظ�key���ڵ�λ�� */	
	public int Binary_Search(int key,int n,int[] nl){
		int low,high,mid;
		low = 1;	//����ߵ��±꣬���Ǵ�1��ʼ
		high = n;	//���ұߵ��±�
		while(low <= high){		//����ߺ����ұߵĲ���ͬһ���ط���ʱ��
			mid = (low+high)/2;		
			if(key < nl[mid]){	//���м��С��ȥ��߼�����
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
	
	
	//����������  ���Ҳ���    T������Ƕ���  key��Ҫ���ҵ���������ԭ�����Բ������ͣ� fΪT��˫��  pָ�������Ԫ��
	public boolean SearchBST(TreeNode T,Integer key,TreeNode f,TreeNode p){
		if(T == null){	//
			p = f ;	//Ҳ���Բ�Ҫ���
			return false;
		}
		else if(key == (Integer)T.getData()){
			p = T;	//Ҳ���Բ�Ҫ���
			return true;
		}
		else if(key < (Integer)T.getData()){	//key�ȶ���ֵС���������
			if(T.getLeft() != null){	//һ��Ҫ�жϣ���ΪT��Ҷ�ӽ���ʱ��û�к��ӣ��ᱨ��ָ�����
				return SearchBST(T.getLeft(),key,T,p);//�ݹ��ѯ
			}
			else return false;//tΪҶ�ӽ���ʱ����key�����T����С������ʾ��Ŷ�������û��key
		}
		else{
			if(T.getRight() != null){	//key�ȶ���ֵ�󣬾����ұ�
				return SearchBST(T.getRight(),key,T,p);
			}
			else return false;
		}
	}
	
	
	//�����������������   �ɹ����뷵��true  ����ͬ����
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
	
	
	//����������ɾ������
	public boolean deleteBST(TreeNode T,Integer key){
		if(T == null){
			return false;
		}
		else{
			if(key == (Integer)T.getData()){	//keyΪT�����ݣ�ֱ��ɾ��
				return delete(T);
			}
			else if(key < (Integer)T.getData()){	//key��T�����
				return deleteBST(T.getLeft(),key);	//�ݹ����T��ߵĶ���
			}
			else{
				return deleteBST(T.getRight(),key);	//�ݹ����T�ұߵĶ���
			}
		}
	}
	//����������ɾ������
	private boolean delete(TreeNode p) {	//Ҫɾ���Ķ���p
		// TODO Auto-generated method stub
		TreeNode q,s;	//��ʱ����
		if(p.getRight() ==null){	//����û���Һ��ӣ�
			q = p;	//��ʱ�洢q
			p = p.getLeft();	//��ɾ��p�����������ԭ����λ��
		}
		else if(p.getLeft() ==null){
			q = p;
			p = p.getRight();
			q = null;
		}
		else{	//�����Һ��ӣ��������ӵ�
			q = p;
			s = p.getLeft();	//p�����Ӹ�ֵ��s
			while(s.getRight() != null){	//һֱ�ҵ�������������Ǹ������������С�ǺͶ�����ӽ���
				q = s;	//��ʱ��qָ��s��ǰһ���㣬Ҳ����s��˫��
				s = s.getRight();	//��ʱ��sָ������Ǹ���ӽ��������
			}
			p.setData(s.getData());//��s��ֵȥ���Ҫɾ���Ķ���p
			if(q != p){	//s��˫��q�������p�Ļ�
				q.setRight(s.getLeft());//��s�����Ӹ���q��s����û���Һ�����
			}
			else{
				q.setLeft(s.getLeft());//ͬ��
			}
		}
		return true;
	}
	
	
	
	//ð������  sΪ��Ҫ���������
	public void BubbleSort1(int[] s){
		int i,j;
		for(i = 1;i<s.length;i++){
			for(j=s.length-1;j<i;j--){
				if(s[j]>s[j+1]){
					//��s[j]��s[j+1]��λ�û���
					int t = s[j];
					s[j] = s[j+1];
					s[j+1] = t;
				}
			}
		}
	}
	
	//�Ľ���ð���㷨
	public void BubbleSort2(int[] s){
		int i,j;
		boolean flag = true;
		for(i=1;i<s.length && flag;i++){	//falgΪfalse��ʱ����˳�ѭ��
			flag = false;
			for(j=s.length-1;j<i;j--){
				int t = s[j];	//��s[j]��s[j+1]��λ�û���
				s[j] = s[j+1];
				s[j+1] = t;
				flag = true;	//��������ݽ�������flagΪtrue
			}
		}
	}
	
	/**
	 * ��ѡ������
	 * @param s һ������
	 */
	public void selectSort(int[] s){
		int i,j,min;
		for(i=1;i<s.length;i++){
			min=i;
			for(j=i+1;j<s.length;j++){
				if(s[min]>s[j]){	//j��ֵ��minС��min����Сֵ���±�
					min=j;
				}
			}
			if(i !=min){	//˵���ҵ���Сֵ����С��ֵ��ǰ��
				//s[i]��s[min]����λ��
				swap(s,i,min);
			}
		}
	}
	
	/**
	 * ��s[i]��s[j]����λ��
	 */
	public void swap(int[] s,int i,int j){
		int t = s[i];	//��s[j]��s[j+1]��λ�û���
		s[i] = s[j];
		s[j] = t;
	}
	
	/**
	 * @param a ������L����������
	 */
	public void quickSort(int[] a){
		qSort(a,1,a.length);
	}
	
	/**
	 * ������a��������a[low....high]����������
	 * @param low
	 * @param high
	 */
	public void qSort(int[] a,int low,int high){
		int pivot;
		if(low<high){
			pivot = partition(a,low,high);	//��a[low...high]һ��Ϊ�� �ó�����ֵ
			qSort(a,low,pivot-1);	//�Ե͵��Ǹ��ӱ��������
			qSort(a,pivot-1,high);	//�Ըߵ��Ǹ��ӱ��������
		}
	}
	
	/**
	 * ����a�����ݵļ�¼��ʹ֮����
	 * @return ���������¼��λ��
	 */
	public int partition(int[] a,int low,int high){
		int pivotkey;
		pivotkey = a[low];	//���õ�һ����¼�������¼
		while(low<high){
			while(low<high && a[high]>=pivotkey)//�Ӹ�λ��ʼ�������б�pivotkeyС�Ķ����������
				high--;	
			swap(a,low,high);  //����ѱ� pivotkey ��С�����ŵ����
			while(low<high && a[low]<=pivotkey)	//һ��һ���ң�Ȼ��ѱ� pivotkey ��� �����ұ�
				low++;
			swap(a,low,high);
		}
		return low;
	}
}
