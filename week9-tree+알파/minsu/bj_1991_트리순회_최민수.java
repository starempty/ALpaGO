package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//[실버 1] 트리 순회
//https://www.acmicpc.net/problem/1991
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1991_트리순회_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1991"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().replaceAll(" ", "").toCharArray();
			char me = temp[0];
			char left = temp[1];
			char right = temp[2];
			tree.insert(me, left, right);
		}

		tree.preOrder(tree.root, bw);
		bw.write("\n");
		tree.middleOrder(tree.root, bw);
		bw.write("\n");
		tree.postOrder(tree.root, bw);

		bw.flush();
		bw.close();
		br.close();
	}

	public static class Node {
		char value;
		Node leftChild;
		Node rightChild;

		public Node(char value) {
			this.value = value;
		}

		public Node(char value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

	}

	public static class Tree {
		Node root;

		void insert(char me, char left, char right) {
			if (root == null) {
				root = new Node(me);
				if (left != '.') {
					root.leftChild = new Node(left);
				}
				if (right != '.') {
					root.rightChild = new Node(right);
				}
			} else {
				search(root, me, left, right);
			}
		}

		public void search(Node node, char me, char left, char right) {
			// node.value 값이 me인 것을 찾는 중
			if (node == null) {
				return;
			} else if (node.value == me) {
				if (left != '.') {
					node.leftChild = new Node(left);
				}
				if (right != '.') {
					node.rightChild = new Node(right);
				}
			} else {
				search(node.leftChild, me, left, right);
				search(node.rightChild, me, left, right);
			}
		}

		public void preOrder(Node node, BufferedWriter bw) throws IOException {
			if (node == null) {
				return;
			}
			bw.write(node.value + "");
			preOrder(node.leftChild, bw);
			preOrder(node.rightChild, bw);
		}

		public void middleOrder(Node node, BufferedWriter bw) throws IOException {
			if (node == null) {
				return;
			}
			middleOrder(node.leftChild, bw);
			bw.write(node.value + "");
			middleOrder(node.rightChild, bw);
		}

		public void postOrder(Node node, BufferedWriter bw) throws IOException {
			if (node == null) {
				return;
			}
			postOrder(node.leftChild, bw);
			postOrder(node.rightChild, bw);
			bw.write(node.value + "");
		}

	}
}
