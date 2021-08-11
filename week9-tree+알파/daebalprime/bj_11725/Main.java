package bj_11725;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> tree = new ArrayList<List<Integer>>(N);
		for(int i = 0; i < N; i++){
			tree.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			addEdge(from, to, tree);
		}
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(0);
		int[] parents = new int[N];
		boolean[] visited = new boolean[N];
		visited[0] = true;
		while(!q.isEmpty()){
			int curr = q.poll();
			List<Integer> childs = tree.get(curr);
			for(int c : childs){
				if(visited[c]) continue;
				parents[c] = curr;
				visited[c] = true;
				q.offer(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N; i++){
			sb.append(parents[i]+1).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static void addEdge(int a, int b, List<List<Integer>> tree){
		List<Integer> na = tree.get(a);
		List<Integer> nb = tree.get(b);
		na.add(b);
		nb.add(a);
	}

}
