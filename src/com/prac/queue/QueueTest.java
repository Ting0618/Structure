package com.prac.queue;

public class QueueTest {
	public static void main(String[] args) {
		SqQueue sq = new SqQueue(5);
	/*//顺序队列测试
		sq.add(5);
		sq.add(4);
		sq.add(3);
		sq.add(2);
		sq.add(1);
		sq.print();
		sq.add(6);
		sq.print();
		sq.delete();
		sq.print();*/
		
	//循环队列的测试
		sq.addRe(1);
		sq.addRe(2);
		sq.addRe(3);
		sq.addRe(4);
		System.out.println(sq.qlength());
		sq.addRe(5);
	//	sq.deleteRe();
	}
}
