// package bj_17841;
package bj_15653;
import java.io.*;
import java.util.*;

public class Main {
	static int answer;
	static int[][] map;
    static boolean[][][][] visited;
	static int N, M;
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	static int[] cmd;
    static Set<Integer> set = new HashSet<Integer>();
    static int cccccc = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
        visited = new boolean[M][N][M][N];
		// for(int i = 0; i < M; i++){
		// 	for(int j = 0; j < N; j++){
		// 		for(int k = 0; k < M; k++){
		// 			for(int l = 0; l < N; l++){
		// 				visited[i][j][k][l] = Integer.MAX_VALUE;
		// 			}
		// 		}
		// 	}
		// }
		answer = Integer.MAX_VALUE/2;
		int rx, ry = rx = 0;
		int bx, by = bx = 0;
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = tmp.charAt(j);
				if(c == '#') {
					map[i][j] = 1;
				}
				else if (c=='O') {
					map[i][j] = -1;
				}
				else if (c=='R') {
					rx = j; 
					ry = i;
				}else if(c=='B') {
					bx = j;
					by = i;
				}
			}
		}
		br.close();
		Queue<int[][]> q = new ArrayDeque<>();
		q.offer(new int[][] {
			{0},
			{-1},
			{rx,ry}, 
			{bx,by}
		});
		visited[rx][ry][bx][by] = true;
		while(!q.isEmpty()){
			int[][] curr = q.poll();
			int cnt = curr[0][0];
			int prev = curr[1][0];
			int arx = curr[2][0];
			int ary = curr[2][1];
			int abx = curr[3][0];
			int aby = curr[3][1];
			int[][][] result = recur(cnt,prev, new int[] {arx, ary}, new int[] {abx, aby});
			for(int[][] info : result){
				if(info != null){
					int[] nr = info[2];
					int[] nb = info[3];
					if(!visited[nr[0]][nr[1]][nb[0]][nb[1]]){
						visited[nr[0]][nr[1]][nb[0]][nb[1]] = true;
						q.offer(info);
					} 
				}
			}
		}

		if(answer == Integer.MAX_VALUE/2) {
			System.out.println(-1);
		}else {
			System.out.println(answer+1);
		}
	}
	static int[][][] recur(int cnt, int previous, int[] rp, int[] bp) {
		int[][][] ret = new int[4][][];
		for(int i = 0; i < 4; i++) {
			if(cnt >= answer) break;
			if(previous == i) continue;
			int[] nr = new int[] {rp[0],rp[1]};
			int[] nb = new int[] {bp[0],bp[1]};
			boolean hr = false;
			boolean hb = false;
			
			if(i == 0) {
				if(nr[0] >= nb[0]) {
					hr = move(nr,nb,i,cnt);
					hb = move(nb,nr,i,cnt);
				}
				else {					
					hb = move(nb,nr,i,cnt);
					hr = move(nr,nb,i,cnt);
				}
			}
			else if(i == 1) {
				if(nr[0] <= nb[0]) {
					hr = move(nr,nb,i,cnt);
					hb = move(nb,nr,i,cnt);
				}
				else {					
					hb = move(nb,nr,i,cnt);
					hr = move(nr,nb,i,cnt);
				}
			}
			else if(i == 2) {
				if(nr[1] >= nb[1]) {
					hr = move(nr,nb,i,cnt);
					hb = move(nb,nr,i,cnt);
				}
				else {					
					hb = move(nb,nr,i,cnt);
					hr = move(nr,nb,i,cnt);
				}
			}
			else if(i == 3) {
				if(nr[1] <= nb[1]) {
					hr = move(nr,nb,i,cnt);
					hb = move(nb,nr,i,cnt);
				}
				else {					
					hb = move(nb,nr,i,cnt);
					hr = move(nr,nb,i,cnt);
				}
			}

			if(hb){
				ret[i] = null;
				continue;
			} 
			if(hr) {
				answer = Math.min(answer, cnt);
				// return null;
				ret[i] = null;
			}else{
                // if(visited[nr[0]][nr[1]][nb[0]][nb[1]] > cnt+1){
                    // recur(cnt+1, i, nr, nb);			
                // };
				ret[i] = new int[][] {{cnt+1},{i},{nr[0], nr[1]}, {nb[0], nb[1]}};
            }
		}
		return ret;
	}
	static boolean move(int[] moving, int[] stop, int ori, int cnt) {
        // if(cccccc++ % 1000 == 0){
        //     System.out.println(cccccc);
        // }
		int nx = moving[0];
		int ny = moving[1];
		int px = stop[0];
		int py = stop[1];
		
		while(true) {
			nx += di[ori];
			ny += dj[ori];
			if(map[ny][nx] == 1 || (ny == py && nx == px)) { // 벽이나 공에 의해 블락
				moving[0] = nx-di[ori];
				moving[1] = ny-dj[ori];
				return false;
			}
			if(map[ny][nx]==-1) { //홀인
				moving[0] = -1;
				moving[1] = -1;
				return true;
			}
		}
	}

}

/*
10 10
##########
#BR.#....#
#..##.#.##
#.##..#..#
#..#.#...#
##.#..##.#
#..##.#..#
#.##..#.##
#....#O..#
##########
*/