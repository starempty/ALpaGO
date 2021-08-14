package a0814;

import java.io.*;
import java.util.*;

public class Main_bj_11657_타임머신 {
	static class Node{
		int s, d, c;
		Node(int s, int d, int c){
			this.s = s;
			this.d = d;
			this.c = c;
		}
	}
	static double INF = Double.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node[] bus = new Node[m];
		
		for(int i = 0; i < m; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			bus[i] = new Node(a, b, c);
		}
		
		double[] dist = new double[n+1];
		for(int i = 0; i <= n; i++) dist[i] = INF;
		dist[1] = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < m; j++) {
				Node cur = bus[j];
				if(dist[cur.s] == INF) continue;
				dist[cur.d] = Double.min(dist[cur.d], dist[cur.s]+cur.c);
			}
		}
		
		boolean flag = false;
		for(int j = 0; j < m; j++) {
			Node cur = bus[j];
			if(dist[cur.d] > dist[cur.s]+cur.c) {
				flag = true;
				break;
			}
		}
		
		if(flag) System.out.println(-1);
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = 2; i <= n; i++) {
				if(dist[i] == INF) sb.append("-1\n");
				else sb.append((int)dist[i]+"\n");
			}
			System.out.print(sb);
		}
	}
}
