import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());
		int[][] map = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		for(int j = 0; j < R; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < C; i++) {
				map[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new ArrayDeque<int[]>();
		int count = 0;
		int max = 0;
		for(int j = 0; j < R; j++) {
			for(int i = 0; i < C; i++) {
				if(visited[j][i] || map[j][i]==0) continue;
				visited[j][i] = true;
				++count;
				q.offer(new int[] {i,j});
				int size = 0;
				while(!q.isEmpty()) {
					int[] curr = q.poll();
					int x = curr[0];
					int y = curr[1];
					++size;
					for(int k = 0; k < 4; k++) {
						int nx = x+di[k];
						int ny = y+dj[k];
						if(nx < 0 || nx >= C || ny < 0 || ny >= R || visited[ny][nx] || map[ny][nx] == 0) {
							continue;
						}
						visited[ny][nx] = true;
						q.offer(new int[] {nx,ny});
					}
				}
				max = Math.max(size, max);
			}
		}
		System.out.println(count);
		System.out.println(max);
	}

}