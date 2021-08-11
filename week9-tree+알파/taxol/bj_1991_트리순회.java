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
		n = stoi(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		Node rootNode = new Node(stk.nextToken().charAt(0),stk.nextToken().charAt(0),stk.nextToken().charAt(0));
		char a,b,c;
		for(int i = 1; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			a = stk.nextToken().charAt(0);
			b = stk.nextToken().charAt(0);
			c = stk.nextToken().charAt(0);
			
			insertNode(rootNode, a, b, c);
		}
		sb = new StringBuilder();
		
		preOrder(rootNode);
		sb.append("\n");
		
		midOrder(rootNode);
		sb.append("\n");
		
		postOrder(rootNode);
		System.out.println(sb.toString());
    	br.close();	
	}
	// 전위 순회
	private static void preOrder(Node curNode) {
		
		if(curNode == null)
			return;
		sb.append(curNode.getVal());
		preOrder(curNode.getLeft());
		preOrder(curNode.getRight());
	}
	// 중위 순회
	private static void midOrder(Node curNode) {
		
		if(curNode == null)
			return;
		midOrder(curNode.getLeft());
		sb.append(curNode.getVal());
		midOrder(curNode.getRight());
	}
	// 후위 순회
	private static void postOrder(Node curNode) {
		
		if(curNode == null)
			return;
		
		postOrder(curNode.getLeft());
		postOrder(curNode.getRight());
		
		sb.append(curNode.getVal());
	}

	private static void insertNode(Node curNode, char target, char left, char right) {
		if(curNode == null)
			return;
		
		if(curNode.getLeftChar() == target) {
			curNode.setLeft(new Node(target,left,right));
			return;
		}
		if(curNode.getRightChar() == target) {
			curNode.setRight(new Node(target,left,right));
			return;
		}
		insertNode(curNode.getLeft(), target, left, right);
		insertNode(curNode.getRight(), target, left, right);
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
	
	static class Node{
		Node left;
		Node right;
		char val;
		char leftChar;
		char rightChar;
		
		public Node(char val, char leftChar, char rightChar) {
			super();
			this.leftChar = leftChar;
			this.rightChar = rightChar;
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
		public Node getLeft() {
			return left;
		}
		public Node getRight() {
			return right;
		}
		char getVal() {
			return val; 
		}
		public char getLeftChar() {
			return leftChar;
		}
		public char getRightChar() {
			return rightChar;
		}
	}
}