package bj_1967;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		List<List<Edge>> tree = new ArrayList<List<Edge>>();
		for(int i = 0; i < N; i++){
			tree.add(new ArrayList<>());
		}
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			Edge e = new Edge(from,to,weight);
			tree.get(from).add(e);
			tree.get(to).add(e);
		}
		boolean[] visited = new boolean[N];
		//find leaf nodes
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> leaves = new ArrayList<Integer>();
		visited[0] = true;
		stack.push(0);
		while(!stack.isEmpty()){
			int curr = stack.pop();
			List<Edge> edges = tree.get(curr);
			boolean hasNext = false;
			for(Edge e : edges){
				int nxt = e.getDest(curr);
				if(!visited[nxt]){
					visited[nxt] = true;
					hasNext = true;
					stack.push(nxt);
				}
			}
			if(!hasNext){
				leaves.add(curr);
			}
		}
		int answer = 0;
		for(int leaf : leaves){
			visited = new boolean[N];
			visited[leaf] = true;
			answer = Math.max(answer,dfs(leaf, visited, tree));
		}
		System.out.println(answer);
		br.close();
		
	}
	static int dfs(int curr, boolean[] visited, List<List<Edge>> tree){
		List<Edge> edges = tree.get(curr);
		int largest = 0;
		for(Edge edge : edges){
			int nxt = edge.getDest(curr);
			if(!visited[nxt]){
				visited[nxt] = true;
				largest = Math.max(largest, edge.getWeight()+dfs(nxt,visited,tree));
			}
		}
		return largest;
	}
	static class Edge{
		final int a;
		final int b;
		final int w;
		Edge(int a, int b, int w){
			this.a = a;
			this.b = b;
			this.w = w;
		}
		int getDest(int s){
			return s == a ? b : a;
		}
		int getWeight(){
			return this.w;
		}
	}
}
