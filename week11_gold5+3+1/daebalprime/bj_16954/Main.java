package bj_16954;
import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1,1,1,-1,-1,0};
	static int[] dj = {1,0,-1,0,1,-1,1,-1,0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[][] map = new boolean[8][8];
		for(int i = 0; i < 8; i++) {
			String m = br.readLine();
			for(int j = 0; j < 8; j++){
				if(m.charAt(j)=='#'){
					map[i][j] = true;
				}
			}
		}
		boolean[][][] visited = new boolean[9][8][8];
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {0,7,0});
		int answer = 0;
		int time = 0;
		while(!q.isEmpty()){
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			int d = curr[2];
			if(x == 7 && y == 0 || d > 8) {
				answer = 1;
				break;
			}
			if(time != d && d < 9){
				time = d;
				for(int i = 6; i >= 0; i--){
					map[i+1] = map[i];
				}
				map[0] = new boolean[8];
			}
			if(map[y][x]){
				continue;
			}
			if(d > 8){
				if(visited[Math.min(d,8)][y][x]) continue;
				visited[Math.min(d,8)][y][x] = true;
			}
			for(int k = 0; k < 9; k++){
				int nx = x+ di[k];
				int ny = y + dj[k];
				if(nx < 0 || nx >= 8 || ny >= 8 || ny < 0 || map[ny][nx] || visited[Math.min(d,8)][ny][nx]) continue;
				visited[Math.min(d,8)][ny][nx] = true;
				q.offer(new int[] {nx,ny,d+1});
			}
		}
		System.out.println(answer);		
		br.close();
	}

}
