package com.prac.graph;

public class TestGraph {

	public static void main(String[] args) {
		LinJieBiao linjie = new LinJieBiao();
		linjie.createGraghWX();
		linjie.DFSTraverse();
		System.out.println();
		linjie.BFS();
	}
}
