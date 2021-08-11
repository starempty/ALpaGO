package bj_5639;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Tree tree = new Tree();
		while(true){
			String str = br.readLine();
			if(str == null || str.equals("")){
				break;
			}
			int key = Integer.parseInt(str);
			tree.addNode(key);
		}
		// System.out.println("멜롱");
		StringBuilder sb = new StringBuilder();
		tree.postOrder(tree.root, sb);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static class Tree{
		Node root = null;
		void postOrder(Node n, StringBuilder sb){
			if(n == null){return;}
			postOrder(n.getLeftChild(), sb);
			postOrder(n.getRightChild(), sb);
			sb.append(n.getKey()).append("\n");
		}
		void addNode(int key){
			if(root == null){
				this.root = new Node(key);
			}
			else{
				Node curr = root;
				while(true){
					int currKey = curr.getKey();
					if(key < currKey){
						if(curr.getLeftChild() == null){
							curr.setLeftChild(new Node(key));
							break;
						}
						curr = curr.getLeftChild();
					}
					else{
						if(curr.getRightChild() == null){
							curr.setRightChild(new Node(key));
							break;
						}
						curr = curr.getRightChild();
					}
				}
			}
		}
	}

	static class Node{
		Node leftChild = null;
		Node rightChild = null;
		int key = 0;
		Node(int key){
			this.key = key;
		}
		void setLeftChild(Node n){
			this.leftChild = n;
		}
		void setRightChild(Node n){
			this.rightChild = n;
		}
		Node getLeftChild(){
			return leftChild;
		}
		Node getRightChild(){
			return rightChild;
		}
		int getKey(){
			return key;
		}

	}

}
