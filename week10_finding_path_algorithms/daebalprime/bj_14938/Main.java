package bj_14938;

import java.io.*;
import java.util.*;

public class Main {
	static final long INF = Long.MAX_VALUE/2-2;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] items = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] graph = new long[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				graph[i][j] = INF;
			}
			// graph[i][i] = 0;
		}
		for(int i = 0; i < R; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			graph[a][b] = w;
			graph[b][a] = w;
		}

		for(int m = 0; m < N; m++){
			for(int s = 0; s < N; s++){
				for(int e = 0; e < N; e++){
					if(m == s || s == e || m == e)continue;
					graph[s][e] = Math.min(graph[s][e],graph[s][m]+graph[m][e]);
				}
			}
		}
		int answer = 0;
		for(int j = 0; j < N; j++){
			int localAnswer = items[j];
			for(int i = 0; i < N; i++){
				if(graph[j][i] <= M){
					localAnswer += items[i];
				}
			}
			answer = Math.max(answer, localAnswer);
		}
		System.out.println(answer);
		
	}

}
