package bj_14461;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		// int[][][] dp = new int[N][N][3];
		boolean[][][] visited = new boolean[N][N][3];
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++){
				map[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)->Integer.compare(o1[2],o2[2]));
		// 0-> x 1 -> y 2->weight 3->step?
		pq.offer(new int[]{0,0,0,0});
		visited[0][0][0] = true;
		int answer = 0;
		while(!pq.isEmpty()){
			int[] c = pq.poll();
			int x = c[0];
			int y = c[1];
			int w = c[2];
			int h = c[3];
			if(x == N-1 && y == N-1){
				answer = w;
				// if(h % 3 == 0){
					// answer += map[y][x];
				// }
				break;
			}
			for(int k = 0; k < 4; k++){
				int nx = x+di[k];
				int ny = y+dj[k];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx][(h+1)%3]){
					continue;
				}
				visited[ny][nx][(h+1)%3] = true;
				if((h+1) % 3 == 0){
					pq.offer(new int[] {nx,ny,w+T+map[ny][nx],h+1});
				}
				else{
					pq.offer(new int[] {nx,ny,w+T,h+1});
				}
				
			}
		}
		System.out.println(answer);
	}

}
