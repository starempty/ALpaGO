package bj_1584;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	static final int DANGER = 1;
	static final int DEATH = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new int[501][501];
		int N = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j = Math.min(y1,y2); j <= Math.max(y1,y2); j++){
				for(int i = Math.min(x1,x2); i <= Math.max(x1,x2); i++){
					map[j][i] = DANGER;
				}
			}
		}
		int M = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < M; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j = Math.min(y1,y2); j <= Math.max(y1,y2); j++){
				for(int i = Math.min(x1,x2); i <= Math.max(x1,x2); i++){
					map[j][i] = DEATH;
				}
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2],o2[2]));
		pq.offer(new int[] {0,0,0});
		boolean[][] visited = new boolean[501][501];
		int answer = -1;
		while(!pq.isEmpty()){
			int[] c = pq.poll();
			int x = c[0];
			int y = c[1];
			int depth = c[2];
			if(x == 500 && y == 500){
				answer = depth;
				break;
			}
			if(visited[y][x]) continue;
			visited[y][x] = true;
			for(int k = 0; k < 4; k++){
				int nx = x+di[k];
				int ny = y+dj[k];
				if(nx < 0 || nx >= 501 || ny < 0 || ny >= 501 || visited[ny][nx] || map[ny][nx] == DEATH){
					continue;
				}
				if(map[ny][nx] == DANGER){
					pq.offer(new int[]{nx,ny,depth+1});
				}else{
					pq.offer(new int[]{nx,ny,depth});
				}
			}
		}

		System.out.println(answer);
		br.close();
		
	}

}
