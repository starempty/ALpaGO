import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];

		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			for(int y = y1; y <= y2; y++) {
				for(int x = x1; x <= x2; x++) {
					map[y][x] = -1;
				}
			}
		}
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int count = 0;
		for(int j = 0; j < M; j++) {
			for(int i = 0; i < N; i++) {
				if(map[j][i]==-1) continue;
				map[j][i] = -1;
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
						if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[ny][nx] == -1) {
							continue;
						}
						map[ny][nx] = -1;
						q.offer(new int[] {nx,ny});
					}
				}
				pq.offer(size);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(count+"\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+" ");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}