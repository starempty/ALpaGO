package a0814;

import java.io.*;
import java.util.*;
public class Main_bj_1584_∞‘¿” {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static class Node implements Comparable<Node>{
		int x, y, life;
		Node(int x, int y, int l){
			this.x = x;
			this.y = y;
			life = l;
		}
		@Override
		public int compareTo(Node o) {
			return this.life-o.life;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] arr = new int[501][501];
		int ni, nj, nl, x1, y1, x2, y2;
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(ni = Integer.min(x1, x2); ni <= Integer.max(x1, x2); ni++) {
				for(nj = Integer.min(y1, y2); nj <= Integer.max(y1, y2); nj++) {
					arr[ni][nj] = 1;
				}
			}
		}
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(ni = Integer.min(x1, x2); ni <= Integer.max(x1, x2); ni++) {
				for(nj = Integer.min(y1, y2); nj <= Integer.max(y1, y2); nj++) {
					arr[ni][nj] = 2;
				}
			}
		}
		
		int min = 9999;
		int[][] visit = new int[501][501];
		Queue<Node> q = new PriorityQueue<>();
		q.offer(new Node(0,0,1));
		visit[0][0] = 1;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.x == 500 && cur.y == 500) {
				min = Math.min(min, cur.life);
				continue;
			}
			for(int i = 0; i < 4; i++) {
				ni = cur.x+dx[i];
				nj = cur.y+dy[i];
				if(0>ni||ni>500 || 0>nj||nj>500 || arr[ni][nj] == 2) continue;
				
				nl = cur.life+arr[ni][nj];
				if(visit[ni][nj] != 0 && visit[ni][nj] <= nl) continue;
				visit[ni][nj] = nl;
				q.offer(new Node(ni, nj, nl));
			}
		}
		if(min != 9999) System.out.println(--min);
		else System.out.println(-1);
	}
}
