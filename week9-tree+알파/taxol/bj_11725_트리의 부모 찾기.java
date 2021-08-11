/*
문제이름
https://www.acmicpc.net/problem/123
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	static List<List<Integer>> tree;
	static StringBuilder sb;
	static boolean[] vis;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = stoi(br.readLine());
    	StringTokenizer stk;
    	
    	tree = new ArrayList<>();
    	
    	for(int i = 0; i <= n; i++) {
    		tree.add(new ArrayList<>());
    	}
    	int a,b;
    	for(int i = 0; i < n - 1; i++) {
    		stk = new StringTokenizer(br.readLine());
    		a = stoi(stk.nextToken());
    		b = stoi(stk.nextToken());
    		tree.get(a).add(b);
    		tree.get(b).add(a);
    	}
    	
    	sb = new StringBuilder();
    	parent = new int[n+1];
    	vis = new boolean[n+1];
    	DFS(1);
    	
    	for(int i = 2; i <= n; i++)
    		sb.append(parent[i]).append("\n");
    	
    	System.out.println(sb.toString());
    	br.close();
	}
	
	private static boolean DFS(int now) {
		vis[now] = true;
		for(int next : tree.get(now)) {
			if(!vis[next]) {
				parent[next] = now;
				vis[next] = true;
				DFS(next);
			}
		}
		return false;
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}