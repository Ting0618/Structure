package com.prac.Stack;

public class Sqtest {

	public static void main(String[] args) {
		//һ��ջ
		/*StackList sta = new StackList(5);
		sta.push(1);
		sta.push(2);
		sta.push("a");
		sta.push(4);
		sta.push(5);
		
		sta.print();
		sta.pop();		
		sta.print();*/
		
		//��ջ����ռ����
		/*StackShare share = new StackShare(6);
		share.push(1, 1);
		share.push(2, 1);
		share.push(3, 1);
		share.push(4, 2);
		share.push(5, 2);
		share.push(6, 2);

		share.print(1);
		share.print(2);*/

		//ջ����ʽ�洢�ṹ����
		StackNode head = new StackNode();
		StackNode top = new StackNode();
		StackLink sl=new StackLink(head, top);
		
		sl.push(1);
		sl.push(2);
		sl.push("gg");
		sl.push(5);
		sl.print();
	}
}
