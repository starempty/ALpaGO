import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	static int N = 5;
	static char[][] map;
	static boolean[][] visited;
	static int answer = 0;
	static Set<Integer> s;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		s = new HashSet<>();
		int[] picks = new int[7];
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < N; i++) {
				char c = getMap(j*5+i);
				int S = (c == 'S' ? 1 : 0);
				int Y = (c == 'Y' ? 1 : 0);
				picks[0] = j*5+i;
				comb(1, j*5+i,picks ,S,Y);
			}
		}
		System.out.println(answer);
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void comb(int cnt, int curr, int[] picks, int som, int yeon) {
		if(cnt == 7) {
			int hash = 0;
			for(int p : picks) {
				hash |= (1<<p);
			}
			if(som > yeon && !s.contains(hash) && bfs(picks[0], picks)) {
//				System.out.println(Arrays.toString(picks));
				++answer;
				s.add(hash);
			}
			return;
		}
		for(int i = curr+1; i <= 25 - (7-cnt); i++) {
			char c = getMap(i);
			int S = som + (c == 'S' ? 1 : 0);
			int Y = yeon + (c == 'Y' ? 1 : 0);
			if((7-1)-cnt + S < Y) {
				continue;
			}
			picks[cnt] = i;
			comb(cnt+1, i, picks, S,Y);
		}
	}
	
	private static boolean bfs(int hashh, int[] picks) {
		boolean[] visited = new boolean[7];
		boolean ret = false;
		int sx = hashh%5;
		int sy = hashh/5;
		int cnt = 0;
		Queue<int[]> q = new ArrayDeque<int[]>(7);
		q.offer(new int[] {sx,sy});
		visited[0] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			int hash = x+y*5;
			cnt++;
			for(int i = 0; i < 4; i++) {
				int nx = x+di[i];
				int ny = y+dj[i];
				if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
					continue;
				}
				int newHash = nx+ny*5;
				boolean flag = false;
				for(int k = 0; k < 7; k++) {
					if(visited[k]) continue;
					int p = picks[k];
					if(p==newHash) {
						flag = true;
						visited[k] = true;
						break;
					}
				}
				if(flag) {
					q.offer(new int[] {nx,ny});
				}
			}
		}
		if(cnt == 7) ret = true; 
		return ret;
		
	}
	
	private static char getMap(int hash) {
		return map[hash/5][hash%5];
	}
	private static boolean isAdjacent(int h1, int h2) {
		int x1 = h1%5;
		int y1 = h1/5;
		int x2 = h2%5;
		int y2 = h2/5;
		if((Math.abs(x1-x2)==1 && Math.abs(y1-y2)==0) || (Math.abs(x1-x2)==0 && Math.abs(y1-y2)==1)) {
			return true;
		}
		return false;
	}
}