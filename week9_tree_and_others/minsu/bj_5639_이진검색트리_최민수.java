package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//[실버 1] 이진 검색 트리
//https://www.acmicpc.net/problem/5639
//참고: https://girawhale.tistory.com/59
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_5639_이진검색트리_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_5639"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean isRoot = true;
		Node rootNode = new Node(0);

		// 입력으로 트리를 구성하고
		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals("")) {
				break;
			}
			int number = Integer.parseInt(input);
			if (isRoot) {
				rootNode = new Node(number);
				isRoot = false;
			} else {
				rootNode.insert(number);
			}
		}
		// 그 트리를 후위순회해서 출력한다.
		postOrder(rootNode, bw);

		bw.flush();
		bw.close();
		br.close();
	}

	static class Node {
		int value;
		Node leftChild;
		Node rightChild;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		void insert(int num) {
			if (num < this.value) {
				if (this.leftChild == null) {
					this.leftChild = new Node(num);
				} else {
					this.leftChild.insert(num);
				}
			} else {
				if (this.rightChild == null) {
					this.rightChild = new Node(num);
				} else {
					this.rightChild.insert(num);
				}
			}
		}
	}

	static void postOrder(Node node, BufferedWriter bw) throws IOException {
		if (node == null) {
			return;
		}
		postOrder(node.leftChild, bw);
		postOrder(node.rightChild, bw);
		bw.write(node.value + "\n");
	}
}
