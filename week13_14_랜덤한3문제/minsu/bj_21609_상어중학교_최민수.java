package baekjoon_20001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//[골드2] 상어 중학교
//https://www.acmicpc.net/problem/21609
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_21609_상어중학교_최민수 {
	static int N, M, answer;
	static int[][] map, groupMap;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_21609"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 0;
		// 블록 그룹이 존재하는 동안 계속해서 반복
		while (true) {
			// 현재 위치의 원소들이 그룹을 어떻게 짓고 있는지 표기하기 위한 맵
			// 반복할 때마다 초기화해주어야 함
			groupMap = new int[N][N];

			PriorityQueue<GroupBlock> pq = new PriorityQueue<>();
			if (findGroup(pq)) { // 블록이 적어도 한개는 있다.
				// for (int[] ii : map)
				// 	System.out.println(Arrays.toString(ii));
				// System.out.println("-------------------------------");
				GroupBlock targetBlock = pq.poll();
				// System.out.println(targetBlock.toString());
				answer += getPoint(targetBlock.flagBlockX, targetBlock.flagBlockY);

				gravity();
				ccwRotate();
				gravity();

			} else { //블록을 하나도 못찾았다.
				break;
			}
		}

		bw.write(answer + "");

		// for (int[] ii : map)
		// 	System.out.println(Arrays.toString(ii));

		bw.flush();
		bw.close();
		br.close();
	}

	// 반시계 방향 회전
	private static void ccwRotate() {
		// 맵 복사
		int[][] copyMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		// copyMap에서 반시계 돌린 값을 map에 저장할 것이다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = copyMap[j][N - i - 1];
			}
		}

	}

	private static void gravity() {
		// 열 별로 한줄씩 내릴껀데, 가장 밑에서부터 내려야 된다.
		for (int col = 0; col < N; col++) {
			for (int i = N-1; i >= 0; i--) {
				if (map[i][col] <= -1) { //공백이거나 검은 블록이면 무시
					continue;
				} else { //무지개 or 일반
					// 내 밑에 공간이 접근 가능하고, 공백이면 한칸 내린다. while
					int nowRow = i;
					while (true) {
						if (nowRow + 1 < N && map[nowRow+1][col] == -2) {
							map[nowRow + 1][col] = map[nowRow][col];
							map[nowRow][col] = -2;
							nowRow++;
						} else {
							break;
						}
					}
				}
			}
		}
	}

	private static int getPoint(int flagBlockX, int flagBlockY) {
		int removeBlock = 0;
		int blockVal = map[flagBlockX][flagBlockY];
		// 이 블록에 대해 bfs를 돌면서 삭제해야 한다.
		// 이미 그룹번호 붙인걸 쓰려고 생각해보니까 무지개 블록이 덮어씌어졌을 듯.
		boolean[][] visit = new boolean[N][N];


		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(flagBlockX);
		q.add(flagBlockY);

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();

			if (visit[x][y]) {
				continue;
			}
			visit[x][y] = true;
			map[x][y] = -2; //공백으로 바꿔줌.
			removeBlock++;

			// 인접 블록 탐색
			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				// 무지개이거나, 같은 블록이면 큐에 넣는다.
				if (map[nx][ny] == 0 || map[nx][ny] == blockVal) {
					q.add(nx);
					q.add(ny);
				}

			}
		}


		

		return removeBlock * removeBlock;
	}

	// 우선순위에 따라 그룹 찾기
	private static boolean findGroup(PriorityQueue<GroupBlock> pq) {
		int groupId = 1;
		// 모든 위치의 원소에서 탐색 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 이미 방문한 적이 있으면

				// 지금 방문한게 일반 블록이라면
				if (map[i][j] >= 1) {
					// 인접 공간을 탐색하면서 같은 일반 블록 or 무지개 블록을 찾아본다.
					// 있으면 블록의 조건은 갖췄다. 없으면 블록 조건을 갖추지 못함.
					if (canMakeBlock(i, j)) {
						// 블록의 조건을 갖췄으면 bfs나 dfs로 탐색을 시작하면서
						// groupMap에 groupId로 마킹을 하고난 이후 groupId++를 한다.
						// 그리고 다음 블록으로 넘어가기 전에 pq에다가 이번 그룹 정보를 넣는다.
						bfs(pq, groupId, i, j);
						groupId++;
					}

				} else if (map[i][j] == 0) { // 지금 방문한게 무지개 블록이라면 패스, (어차피 그룹에 들어갈 무지개면 일반 블록 dfs 돌다가 들어간다)

				}
				// 그 외(흑색 블록이거나 비어있는 공간)면 아무 행동도 안한다.
			}
		}
		if (groupId == 1) {
			return false;
		} else {
			return true;
		}
	}
	
	private static void bfs(PriorityQueue<GroupBlock> pq, int groupId, int i, int j) {
		boolean[][] visit = new boolean[N][N];
		int blockSize = 0;
		int rainbowBlock = 0;
		int flagBlockX = N+1;
		int flagBlockY = N+1;

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(i);
		q.add(j);

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();

			if (visit[x][y]) {
				continue;
			}
			visit[x][y] = true;
			groupMap[x][y] = groupId;
			blockSize++;
			if (map[x][y] == 0) {
				rainbowBlock++;
			} else if (flagBlockX > x) { // 기준 블록 갱신
				flagBlockX = x;
				flagBlockY = y;
			} else if (flagBlockX == x && flagBlockY > y) { // 기준 블록 갱신
				flagBlockY = y;
			}
			

			// 인접 블록 탐색
			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				// 무지개이거나, 같은 블록이면 큐에 넣는다.
				if (map[nx][ny] == 0 || map[nx][ny] == map[i][j]) {
					q.add(nx);
					q.add(ny);
				}

			}
		}

		// 탐색을 다했으면 이번에 생성한 블록을 pq에 넣어야 한다.
		pq.add(new GroupBlock(blockSize, rainbowBlock, flagBlockX, flagBlockY, groupId));

	}

	private static boolean canMakeBlock(int i, int j) {
		for (int dir = 0; dir < 4; dir++) {
			int x = i + dx[dir];
			int y = j + dy[dir];

			if (x < 0 || x >= N || y < 0 || y >= N) {
				continue;
			}

			// 무지개이면
			if (map[x][y] == 0) {
				return true;
			} else if (map[x][y] == map[i][j]) { //같은 일반 블록이면
				return true;
			}
		}
		return false;
	}

	public static class GroupBlock implements Comparable<GroupBlock> {
		int blockSize;
		int rainbowBlock;
		int flagBlockX;
		int flagBlockY;
		int groupId;
		
		public GroupBlock(int blockSize, int rainbowBlock, int flagBlockX, int flagBlockY, int groupId) {
			this.blockSize = blockSize;
			this.rainbowBlock = rainbowBlock;
			this.flagBlockX = flagBlockX;
			this.flagBlockY = flagBlockY;
			this.groupId = groupId;
		}

		

		@Override
		public String toString() {
			return "GroupBlock [blockSize=" + blockSize + ", flagBlockX=" + flagBlockX + ", flagBlockY=" + flagBlockY
					+ ", groupId=" + groupId + ", rainbowBlock=" + rainbowBlock + "]";
		}



		@Override
		public int compareTo(GroupBlock o) {
			// 크기가 가장 큰 블록
			int compareVal1 = Integer.compare(o.blockSize, this.blockSize);
			if (compareVal1 == 0) {
				// 무지개 블록 수
				int compareVal2 = Integer.compare(o.rainbowBlock, this.rainbowBlock);
				if (compareVal2 == 0) {
					// 기준 블록의 행이 가장 큰것 부터
					int compareVal3 = Integer.compare(o.flagBlockX, this.flagBlockX);
					if (compareVal3 == 0) {
						// 기준 블록의 열이 가장 큰 것 부터
						int compareVal4 = Integer.compare(o.flagBlockY, this.flagBlockY);
						return compareVal4;
					} else {
						return compareVal3;
					}
					
				} else {
					return compareVal2;
				}
			} else {
				return compareVal1;
			}
		}

		
	}
}
