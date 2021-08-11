/*
문제이름
https://www.acmicpc.net/problem/123
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result, max, deep;
	static List<List<Node>> node;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = stoi(br.readLine());
    	StringTokenizer stk;
    	
    	node = new ArrayList<>();
    	
    	for(int i = 0; i <= n; i++) {
    		node.add(new ArrayList<Node>());
    	}
    	
    	int a,b,c;
		for(int i = 0; i < n - 1; i++) {
			stk = new StringTokenizer(br.readLine());
			a = stoi(stk.nextToken());
			b = stoi(stk.nextToken());
			c = stoi(stk.nextToken());
			
			node.get(a).add(new Node(b,c));
			node.get(b).add(new Node(a,c));
		}
		// 루트 노드, 이전 노드, 현재까지의 합
		DFS(1, -1, 0);
		max = 0;
		DFS(deep, -1, 0);
		
		System.out.println(max);
    	br.close();
	}
	
	static void DFS(int curN, int preV, int sum) {
		
		if(max < sum) {
			max = sum;
			deep = curN;
		}
		
		int size = node.get(curN).size();
		for(int i = 0; i < size; i++) {
			if(node.get(curN).get(i).getName() != preV) {
				DFS(node.get(curN).get(i).getName(), curN, sum + node.get(curN).get(i).getVal());
			}
		}
		
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
	
	static class Node{
		private int name;
		private int val;
		
		Node(int name, int val){
			this.name = name;
			this.val = val;
		}
		public int getName() {
			return name;
		}
		public int getVal() {
			return val;
		}
	}
}