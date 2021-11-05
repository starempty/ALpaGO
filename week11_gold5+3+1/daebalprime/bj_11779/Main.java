package bj_11779;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] prev = new int[N+1];
		Arrays.fill(prev, -1);
		List<List<int[]>> graph = new ArrayList<List<int[]>>();
		boolean[] visited = new boolean[N+1];
		for(int i = 0; i < N+1; i++){
			graph.add(new ArrayList<int[]>());
		}
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(a).add(new int[]{b,w});
			// graph.get(b).add(new int[]{a,w});
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		pq.offer(new int[]{s,0,0});
		int answer = 0;
		while(!pq.isEmpty()){
			int[] c = pq.poll();
			int curr = c[0];
			int dist = c[1];
			int prevv = c[2];
			if(visited[curr]) continue;
			visited[curr] = true;
			prev[curr] = prevv;
			if(curr == e){
				answer = dist;
				break;
			}
			List<int[]> nxt = graph.get(curr);
			for(int[] edge : nxt){
				if(visited[edge[0]]) continue;
				pq.offer(new int[]{edge[0], dist+edge[1], curr});
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		int curr = e;
		// list.add(e);
		while(true){
			if(curr == s) break;
			list.add(curr);
			curr = prev[curr];
		}
		list.add(s);
		// Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(answer).append("\n").append(list.size()).append("\n");
		for(int i = list.size() - 1; i >= 0; i--){
			sb.append(list.get(i)).append(" ");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
