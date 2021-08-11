/*
문제이름
https://www.acmicpc.net/problem/123
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		Node startNode = new Node(stoi(br.readLine()));
		
		while(true) {
			input = br.readLine();
			// 문제에서 종료 조건이 없으므로, 아래 조건 문으로 대체
			if(input == null || input.equals("")) {
				break;
			}
			int num = stoi(input);
			insertNode(num , startNode);
		}	
		
		sb = new StringBuilder();
		postOrder(startNode);
		System.out.println(sb.toString());
    	br.close();	
	}
	
	private static void postOrder(Node curNode) {
		
		if(curNode == null)
			return;
		
		postOrder(curNode.getLeft());
		postOrder(curNode.getRight());
        
		sb.append(curNode.getVal()).append("\n");
	}

	private static void insertNode(int num, Node curNode) {

		if(num < curNode.getVal()) {
			// 왼쪽 노드가 비어있을 때
			if(curNode.getLeft() == null) {
				curNode.setLeft(new Node(num));
			}
			else {
				insertNode(num, curNode.getLeft());
			}
		}
		else {
			if(curNode.getRight() == null) {
				curNode.setRight(new Node(num));
			}
			else {
				insertNode(num, curNode.getRight());
			}
		}
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
	
	static class Node{
		Node left;
		Node right;
		int val;
		Node(int val){
			this.val = val;
			left = null;
			right = null;
		}
		void setLeft(Node n) {
			this.left = n;
		}
		void setRight(Node n) {
			this.right = n;
		}
		void setVal(int n) {
			this.val = n;
		}
		public Node getLeft() {
			return left;
		}
		public Node getRight() {
			return right;
		}
		int getVal() {
			return val; 
		}
	}
}