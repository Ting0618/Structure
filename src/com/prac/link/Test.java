package com.prac.link;

public class Test {

	public static void main(String[] args) {
		Node<Object> firstNode=new Node<Object>();
		Node<Object> tail=new Node<Object>();
		SequenceList<Integer> se = new SequenceList<Integer>(10);
		NodeList<Object> nolist = new NodeList<Object>(firstNode,tail);
		DoubleLink<Object> doub = new DoubleLink <Object>(firstNode,tail);
		
		try {	
			//顺序链表测试部分
			/*se.insertElement(1,1);
			se.insertElement(2,2);
			se.insertElement(3,3);
			se.insertElement(4,4);
			se.print();
			se.insertElement(2,"a");
			se.print();*/
			
			//链式链表测试部分
			
		//	nolist.insert(1, 1);
		//	nolist.insert(2, 2);
			/*nolist.insert(3, 3);
			nolist.insert(4, 4);
			nolist.insert(5, 5);
			nolist.print();*/
		//	Node<Object> s = nolist.serch(3);
		//	System.out.println(s);
		//	nolist.delete(1);
		//	nolist.insert(2, "a");
		//	nolist.add(3);
		//	nolist.add(1);
		//	nolist.add(2);
			/*nolist.headAdd(1);
			nolist.headAdd(2);
			nolist.headAdd(3);
			nolist.headAdd(4);*/
		//	nolist.destroy();
		//	nolist.print();
			
		//双向链表测试
			doub.insert(1, 1);
			doub.insert(2, 2);
			doub.insert(3, 3);
			doub.print();
			doub.insert(2, "a");
			doub.print();
			doub.delete(2);
			doub.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// function cantne (e) {
		 
	// 	$(this).toggleClass('current').find('span').toggleClass('mod_category') 
	// 	$(this).parents(".pop_select").siblings(".pop_tips").find(".sel_all").prop('checked',false)
	// }
}
