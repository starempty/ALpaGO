package bj_5022;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	static int X,Y;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken())+1;
		Y = Integer.parseInt(st.nextToken())+1;

		int[][] ap = new int[2][2];
		int[][] bp = new int[2][2];
		for(int i = 0; i < 2; i++){
			st = new StringTokenizer(br.readLine());
			ap[i][0] = Integer.parseInt(st.nextToken());
			ap[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < 2; i++){
			st = new StringTokenizer(br.readLine());
			bp[i][0] = Integer.parseInt(st.nextToken());
			bp[i][1] = Integer.parseInt(st.nextToken());
		}
		int r1 = bfs(ap,bp);
		int r2 = bfs(bp,ap);
		if(r1 < 0 && r2 < 0){
			System.out.println("IMPOSSIBLE");
		}
		else{
			int answer = 0;
			if(r1 < 0){
				answer = r2;
			}
			else if (r2 < 0){
				answer = r1;
			}
			else{
				answer = Math.min(r1,r2);
			}
			System.out.println(answer);
		}
	}
	static int bfs(int[][] fp, int[][] lp){
		int d1 = 0;
		int d2 = -50000;
		Queue<int[]> q = new ArrayDeque<int[]>();
		int[][] map = new int[Y][X];
		boolean[][] visited = new boolean[Y][X];
		q.offer(new int[]{fp[0][0], fp[0][1], 0});
		map[fp[0][1]][fp[0][0]] = -1;
		visited[fp[0][1]][fp[0][0]] = true;
		visited[lp[0][1]][lp[0][0]] = true;
		visited[lp[1][1]][lp[1][0]] = true;
		while(!q.isEmpty()){
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			int w = c[2];
			if(x == fp[1][0] && y == fp[1][1]){
				d1 = w;
				q.clear();
				break;
			}
			for(int k = 0; k < 4; k++){
				int nx = x+di[k];
				int ny = y+dj[k];
				if(nx < 0 || nx >= X || ny < 0 || ny >= Y || visited[ny][nx]){
					continue;
				}
				q.offer(new int[]{nx,ny,w+1});
				visited[ny][nx] = true;
				map[ny][nx] = (k+2)%4 + 10;
			}
		}
		visited = new boolean[Y][X];
		int sx = fp[1][0];
		int sy = fp[1][1];
		while(true){
			visited[sy][sx] = true;
			if(map[sy][sx] == -1) {
				break;
			}
			int ori = map[sy][sx]-10;
			sy = sy+dj[ori];
			sx = sx+di[ori];
		}
		q.offer(new int[]{lp[0][0], lp[0][1], 0});
		visited[lp[0][1]][lp[0][0]] = true;
		while(!q.isEmpty()){
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			int w = c[2];
			if(x == lp[1][0] && y == lp[1][1]){
				d2 = w;
				break;
			}
			for(int k = 0; k < 4; k++){
				int nx = x+di[k];
				int ny = y+dj[k];
				if(nx < 0 || nx >= X || ny < 0 || ny >= Y || visited[ny][nx]){
					continue;
				}
				q.offer(new int[]{nx,ny,w+1});
				visited[ny][nx] = true;
			}
		}

		return d1+d2;
	}

}
