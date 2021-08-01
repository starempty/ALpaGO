import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,-1,-1,-1,0,1,1,1};
	static int[] dj = {-1,-1,0,1,1,1,0,-1};
	static char[] o = {'↑', '↖', '←', '↙', '↓', '↘', '→', '↗'};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = 4;
		Fish[][] map = new Fish[N][N];
		int[][] alive = new int[N*N][2];
		for(int j = 0; j < N; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int id = Integer.parseInt(st.nextToken())-1;
				int ori = Integer.parseInt(st.nextToken())-1;
				map[j][i] = new Fish(id,ori, false);
				alive[id][0] = i;
				alive[id][1] = j;
			}
		}
		int answer = simulation(0,0,16,map,alive);
		System.out.println(answer);
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int simulation(int x, int y, int remained, Fish[][] map, int[][] alive) throws Exception {
//		if(remained == 0) {
//			return 0;
//		}
		int ori = map[y][x].getOri();
		int id = map[y][x].getId();
		alive[id] = null;
		int curr = id+1;
//		System.out.println("+"+curr);
		map[y][x] = null;
		--remained;
		move(map,alive,x,y);
		
		int dx = di[ori];
		int dy = dj[ori];
		int ret = 0;
		boolean flag = false;
		for(int k = 1; k <= 3; k++) {
			int nx = x + dx*k;
			int ny = y + dy*k;
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
				break;
			}
			if(map[ny][nx] != null) {
				flag = true;
				Fish[][] newMap = new Fish[4][4];
				int[][] newAlive = new int[16][];
				for(int j = 0; j < 4; j++) {
					for(int i = 0; i < 4; i++) {
						if(map[j][i]!=null) {
							newMap[j][i] = (Fish) map[j][i].clone();
						}
						if(alive[i*4+j]!=null) {
							int[] arr = {alive[i*4+j][0], alive[i*4+j][1]};
							newAlive[i*4+j] = arr;
						}
					}
				}
				ret = Math.max(simulation(nx,ny,remained-1, newMap,newAlive),ret);
			}
		}
//		if(!flag)System.out.println("stop");

		// 먹음 
		return ret + curr;
	}
	
	
	
	private static void move(Fish[][] map, int[][] alive, int sx, int sy){
		for(int i = 0; i < 16; i++) {
			if(alive[i] != null) {
				int x = alive[i][0];
				int y = alive[i][1];
				if(map[y][x] == null) continue;
				int o = map[y][x].getOri();
				for(int k = 0; k < 8; k++) {
					int nx = x+di[(o+k)%8];
					int ny = y+dj[(o+k)%8];
					if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (sx==nx) && (sy==ny)) {
						continue;
					}
					if(map[ny][nx] != null) {
						int nid = map[ny][nx].getId();
						map[y][x].setOri((o+k)%8);
						swap(i,nid,map,alive);
					}else {
						map[ny][nx] = map[y][x];
						map[y][x] = null;
						map[ny][nx].setOri((o+k)%8);
						alive[i][0] = nx;
						alive[i][1] = ny;
					}
					break;
				}
			}
		}
//		for(int j = 0; j < 4; j++) {
//			for(int x = 0; x < 4; x++) {
//				if(j==sy&&x==sx){
//					System.out.print("[SHARK]\t");
//				}else if(map[j][x] == null) { 
//					System.out.print("[X/X]\t");
//				}
//				else {					
//					System.out.print("["+(map[j][x].getId()+1)+"/"+o[map[j][x].getOri()]+"]\t");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("-------------------");
//		System.out.println("********************");
	}
	
	private static void swap(int a, int b, Fish[][] map, int[][] alive) {
		int ax = alive[a][0];
		int ay = alive[a][1];
		int bx = alive[b][0];
		int by = alive[b][1];
		Fish fa = map[ay][ax];
		Fish fb = map[by][bx];
		map[by][bx] = fa;
		map[ay][ax] = fb;
		alive[a][0] = bx;
		alive[a][1] = by;
		alive[b][0] = ax;
		alive[b][1] = ay;
	}
	
	
	private static class Fish{
		int id, ori;
		boolean isShark;

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Fish [id=").append(id).append(", ori=").append(ori).append(", isShark=").append(isShark)
					.append("]");
			return builder.toString();
		}

		public Fish(int id, int ori, boolean isShark) {
			super();
			this.id = id;
			this.ori = ori;
			this.isShark = isShark;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getOri() {
			return ori;
		}

		public void setOri(int ori) {
			this.ori = ori;
		}

		public boolean isShark() {
			return isShark;
		}

		public void setShark(boolean isShark) {
			this.isShark = isShark;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return new Fish(this.id, this.ori, this.isShark);
		}
	}
}
/*
7 6 2 6 15 7 9 3
3 5 1 4 14 1 10 6
6 4 13 3 4 6 11 1
16 5 8 7 5 2 12 2
->88

7 6 2 1 15 1 9 1
3 1 1 1 14 7 10 3
6 1 13 6 4 3 11 4
16 3 8 7 5 2 12 2
->42

12 6 14 5 4 5 6 7
15 1 11 3 3 7 7 5
10 3 8 2 16 6 1 1
5 8 2 7 13 6 9 4
->76
*/
