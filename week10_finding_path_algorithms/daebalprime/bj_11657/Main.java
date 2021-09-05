package bj_11657;

import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] distance = new long[N];
		Arrays.fill(distance, INF);
		distance[0] = 0;
		// int N = Integer.parseInt(br.readLine());
		int[][] edges = new int[M][3];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken())-1;
			edges[i][1] = Integer.parseInt(st.nextToken())-1;
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		boolean isNegativeCycle = false;
		for(int i = 0; i < N; i++){
			for(int[] edge : edges){
				int s = edge[0];
				int e = edge[1];
				int w = edge[2];
				if(distance[s] != INF && distance[e] > distance[s]+w){
					distance[e] = distance[s]+w;
					if(i == N-1){
						isNegativeCycle = true;
						break;
					}
				}
				// if(distance[e] != INF && distance[s] > distance[e]+w){
				// 	distance[s] = distance[e]+w;
				// 	if(i == N-1){
				// 		isNegativeCycle = true;
				// 		break;
				// 	}
				// }
			}
		}
		StringBuilder sb = new StringBuilder();
		if(isNegativeCycle){
			sb.append(-1);
		}
		else{
			for(int i = 1; i < N; i++){
				long d = distance[i];
				sb.append(d == INF? -1 : d).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
