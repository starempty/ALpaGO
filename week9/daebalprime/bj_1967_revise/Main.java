package bj_1967_revise;

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
		visited = new boolean[N];
		visited[0] = true;
		int[] start = dfs(0,visited,tree);
		visited = new boolean[N];
		visited[start[1]] = true;
		int[] answer = dfs(start[1], visited, tree);
		System.out.println(answer[0]);
		br.close();
		
	}
	static int[] dfs(int curr, boolean[] visited, List<List<Edge>> tree){
		List<Edge> edges = tree.get(curr);
		int[] ret = new int[] {0,curr};
		for(Edge edge : edges){
			int nxt = edge.getDest(curr);
			if(!visited[nxt]){
				visited[nxt] = true;
				int[] result = null;
				if(edge.getWeight()+(result = dfs(nxt,visited,tree))[0] >= ret[0]){
					result[0] += edge.getWeight();
					ret = result;
				}
			}
		}
		return ret;
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
