import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int answer = Integer.MAX_VALUE;
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())*Integer.MAX_VALUE;
			}
		}
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<int[]>(Math.max(10, N*N/8));
		int numbering = 0;
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < N; i++) {
				if(!visited[j][i] && map[j][i] == Integer.MAX_VALUE) {
					visited[j][i] = true;
					++numbering;
					map[j][i] = numbering;
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						int x = curr[0];
						int y = curr[1];
						
						for(int k = 0; k < 4; k++) {
							int nx = x+di[k];
							int ny = y+dj[k];
							if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] || map[ny][nx] != Integer.MAX_VALUE || map[ny][nx] == 0) {
								continue;
							}
							map[ny][nx] = numbering;
							visited[ny][nx] = true;
							q.offer(new int[] {nx,ny});
						}
					}
				}
			}
		}

		visited = new boolean[N][N];
		List<int[]> shell = new ArrayList<>();
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < N; i++) {
				if(!visited[j][i] && map[j][i] == 0) {
					visited[j][i] = true;
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						int x = curr[0];
						int y = curr[1];
						
						for(int k = 0; k < 4; k++) {
							int nx = x+di[k];
							int ny = y+dj[k];
							if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx]) {
								continue;
							}
							if(map[ny][nx] != 0) {
								shell.add(new int[] {nx, ny});
							}else {
								q.offer(new int[] {nx,ny});
							}
							visited[ny][nx] = true;
						}
					}
				}
			}
		}
		for(int[] starting : shell) {
			visited = new boolean[N][N];
			int i = starting[0];
			int j = starting[1];
			visited[j][i] = true;
			int base = map[j][i];
			
			q.offer(new int[] {i,j,0});
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				int x = curr[0];
				int y = curr[1];
				int depth = curr[2];
				for(int k = 0; k < 4; k++) {
					int nx = x+di[k];
					int ny = y+dj[k];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] || map[ny][nx] == base) {
						continue;
					}
					if(map[ny][nx] != base && map[ny][nx] != 0) {
						q.clear();
						answer = Math.min(answer, depth);
						break;
					}else {
						q.offer(new int[] {nx,ny,depth+1});
					}
					visited[ny][nx] = true;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
}
