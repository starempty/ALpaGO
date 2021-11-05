package bj_11404;

import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		long[][] distance = new long[N][N];
		for(long[] la : distance){
			Arrays.fill(la, INF);
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			distance[a][b] = Math.min(distance[a][b],w);
		}
		for(int m = 0; m < N; m++){
			for(int s = 0; s < N; s++){
				if(m==s) continue;
				for(int e = 0; e < N; e++){
					if(e == m || m== s) continue;
					distance[s][e] = Math.min(distance[s][e], distance[s][m]+distance[m][e]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < N; j++){
			for(int i = 0; i < N; i++){
				if(j == i){
					sb.append("0 ");
					continue;
				}
				sb.append(distance[j][i] == INF ? 0 : distance[j][i]).append(' ');
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
