package a0828;

import java.io.*;
import java.util.*;

public class Main_bj_16954_움직이는미로탈출 {
	static int[] dx = {-1,-1,-1, 0,0,0, 1,1,1};
	static int[] dy = {-1, 0, 1,-1,0,1,-1,0,1};
	static char[][] arr = new char[8][8];
	static int ans = 0, wallCnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 8; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j = 0; j < 8; j++) {
				if(arr[i][j] == '#') wallCnt++;
			}
		}
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {7, 0});
		
		while(!q.isEmpty()) {
			int size = q.size();
			boolean[][] visit = new boolean[8][8];
			for(int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int x = cur[0], y = cur[1];
				if(arr[x][y] == '#') continue;
				if(x == 0 || wallCnt == 0) {
					System.out.println(1);
					return;
				}
				
				for(int d = 0; d < 9; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(0>nx||nx>=8 || 0>ny||ny>=8) continue;
					if(arr[nx][ny] == '#' || visit[nx][ny]) continue;
					
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
			if(wallCnt > 0) moving();
		}
		System.out.println(0);
	}
	private static void moving() {
		for(int i = 7; i >= 0; i--) {
			for(int j = 0; j < 8; j++) {
				if(arr[i][j] == '.') continue;
				if(i == 7) {
					arr[i][j] = '.';
					wallCnt--;
				}
				else {
					arr[i][j] = '.';
					arr[i+1][j] = '#';
				}
 			}
		}
	}
	//아래 코드는 visit 관리 실패로 사용하지 않음
	private static void dfs(int x, int y, boolean[][] visit) { 
		if(ans == 1) return;
		if(arr[x][y] == '#') return;
		if(x == 0 && y == 7) {
			ans = 1;
			return;
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		for(int i = 0; i < 9; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0>nx||nx>=8 || 0>ny||ny>=8) continue;
			if(visit[nx][ny] || arr[nx][ny] == '#') continue;

			q.offer(new int[] {nx, ny});
		}
		for(int i = 7; i >= 0; i--) {
			for(int j = 0; j < 8; j++) {
				if(arr[i][j] == '.') continue;
				if(i == 7) arr[i][j] = '.';
				else {
					arr[i][j] = '.';
					arr[i+1][j] = '#';
				}
 			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			visit[cur[0]][cur[1]] = true;
			dfs(cur[0], cur[1], visit);
			visit[cur[0]][cur[1]] = false;
		}
	}
}
