import java.util.*;
import java.io.*;

public class Main {
	static int n, result, m;
	static int[][] vis;
	static int[][] wall;
	static int totalRoomCnt;
	static int maxSize;
	static int twoMaxSize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	m = stoi(stk.nextToken());
    	n = stoi(stk.nextToken());
    	vis = new int[n][m];
    	wall = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			wall[i][j] = stoi(stk.nextToken());
    		}
    	}
    	int idx = 1, size;
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
				// 처음 방문하는 방이면, 총 방의 개수를 늘리고, 그 방의 인덱스를 다 부여한다.
    			if(vis[i][j] == 0) {
    				totalRoomCnt++;
    				size = BFS(i,j, idx);
    				maxSize = Math.max(size, maxSize);
    				map.put(idx, size);
    				idx++;
    			}
    		}
    	}
    	System.out.println(totalRoomCnt);	// 최대 방의 개수
    	System.out.println(maxSize);		// 최대 방의 크기
		// 인접한 2개의 방 크기의 합 중 최대를 구한다.
    	int ny, nx, curR;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			curR = vis[i][j];
				// 상하좌우 인접한 방 탐색
    			for(int k = 0; k < 4; k++) {
    				ny = i + dy[k];
    				nx = j + dx[k];
					// 서로 다른 방이면, 크기를 더하고 최대 크기를 갱신한다.
    				if(isIn(ny,nx) && curR != vis[ny][nx]) {
    					twoMaxSize = Math.max(twoMaxSize, map.get(curR) + map.get(vis[ny][nx]));
    				}
    			}
    		}
    	}
    	System.out.println(twoMaxSize);
    	br.close();
	}
	
	// 주어진 범위 안에 있는가
    public static boolean isIn(int y, int x){
        if(y < 0 || y >= n || x < 0 || x >= m)
            return false;
        return true;
    }
    // 서, 북, 동, 남
    static int dy[] = {0,-1,0,1};
	static int dx[] = {-1,0,1,0};
	private static int BFS(int y, int x, int idx) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y,x});
		vis[y][x] = idx;
		int size = 1;
		int[] q;
		int ny, nx;
		while(!queue.isEmpty()) {
			q = queue.poll();
			y = q[0];
			x = q[1];
			
			for(int i = 0; i < 4; i++) {
				// 현재 가려는 방향에 벽이 없으면 이동이 가능하다.
				if((wall[y][x] >> i & 1) == 0) {
					ny = y + dy[i];
					nx = x + dx[i];
					// 아직 방문하지 않은 방이면 방문하고 방 크기 측정 값을 증가시킨다.
					if(isIn(ny,nx) && vis[ny][nx] == 0) {
						size++;
						queue.add(new int[] {ny,nx});
						vis[ny][nx] = idx;
					}
				}
			}
		}
		return size;
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}