package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//[골드 2] 청소년 상어
//https://www.acmicpc.net/problem/19236
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_19236_청소년상어_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_19236"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] map = new int[4][8];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 8; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sum = map[0][0];
		deadFish[map[0][0]] = true;
		map[0][0] = -1; // 상어 위치는 -1

		// 물고기 1차 이동
		fishMove(map);

		// dfs
		dfs(map, 0, 0, sum);
		// 상어 몇칸 이동할지 결정
		// 물고기 n차 이동

		// 연산 끝
		bw.write(String.valueOf(sum));

		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int[][] map, int sx, int sy, int semiSum) {
		// 물고기의 이동이 모두 끝나면 상어가 이동
		// 물고기가 없는 칸으로는 이동할 수 없다
		// 상어가 이동할 수 있는 칸이 없으면 공간에서 벗어나 집으로 간다

		int way = map[sx][sy + 1];
		int fishSize = 0;
		// 상어가 몇칸 이동할지 정하고 1~3칸 이동가능하다.
		for (int i = 1; i <= 3; i++) {
			int nx = sx + dx[way] * i;
			int ny = sy + dy[way] * i;

			// 범위 초과
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 8) {
				sum = Math.max(sum, semiSum);
				// System.out.println("RING OUT");
				// for (int[] js : map) {
				// System.out.println(Arrays.toString(js));
				// }
				// continue;
				return;
			} else if (map[nx][ny] == 0) { // 물고기가 없거나
				// System.out.println("NO FISH" + nx + ", " + ny + "way" + way);
				// for (int[] js : map) {
				// System.out.println(Arrays.toString(js));
				// }
				sum = Math.max(sum, semiSum);
				return;
			} else { // 물고기가 있다.
				// 포식
				fishSize = map[nx][ny];
				map[nx][ny] = -1; // 상어이동

				map[sx][sy] = 0; // 물고기 사망
				deadFish[fishSize] = true;
				// 방향 전환
				map[sx][sy + 1] = 0;
			}

			dfs(map, nx, ny, semiSum + fishSize);
			// 재귀 끝나고 돌아오면
			deadFish[fishSize] = false; // 물고기 소생
			map[nx][ny] = fishSize;
			// map[nx][ny + 1] = map[sx][sy + 1]; //방향은 그대로니까?
			// 상어 원위치, 죽은 물고기 살리기
			map[sx][sy] = -1; // 상어 원위치
			map[sx][sy + 1] = way; // 상어 방향 복구

		}

	}

	private static void fishMove(int[][] map) {
		// 물고기는 한 칸을 이동할 수 있다.

		// 물고기는 번호가 작은 물고기부터 순서대로 이동한다.
		for (int i = 1; i <= 16; i++) {
			if (deadFish[i])
				continue;
			// 살아있으면 위치 찾는다.
			int x = 0, y = 0, way = 0;
			Find: for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 8; k = k + 2) { // 2칸씩 건너뛰어야함.
					if (map[j][k] == i) {
						x = j;
						y = k;
						way = map[j][k + 1];
						break Find;
					}
				}
			}

			// 이동할 위치, 8방향 체크
			// 각 물고기는 방향이 이동할 수 있는 칸을 향할 때까지 방향을 45도 반시계 회전시킨다.
			for (int j = 0; j < 8; j++) {
				int nx = x + dx[(way - 1 + j) % 8 + 1];
				int ny = y + dy[(way - 1 + j) % 8 + 1];

				// 이동할 수 없는 칸은 1. 상어가 있거나, 2. 공간의 경계를 넘는 칸이다.
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 8 || map[nx][ny] == -1)
					continue;

				// 빈칸이면 거기로 이동만
				if (map[nx][ny] == 0) {
					map[nx][ny] = map[x][y];
					map[nx][ny + 1] = way;
					map[x][y] = 0;
					map[x][y + 1] = 0;
					break;
				}

				// 물고기가 다른 물고기가 있는 칸으로 이동할 때는 서로의 위치를 바꾸는 방식으로 이동한다.
				if (map[nx][ny] >= 1) {
					// 옮길자리 백업
					int tempSize = map[nx][ny];
					int tempWay = map[nx][ny + 1];
					// 물고기를 옮길자리로 이동
					map[nx][ny] = map[x][y];
					map[nx][ny + 1] = way;
					// 원래 자리에 옮길 물고기 정보 붙여넣기
					map[x][y] = tempSize;
					map[x][y + 1] = tempWay;
					break;
				}

			}
			// 만약, 이동할 수 있는 칸이 없으면 이동을 하지 않는다

		}

		// System.out.println();
		// for (int[] js : map) {
		// System.out.println(Arrays.toString(js));
		// }

	}

	static int sum;
	// 물고기 사망여부
	static boolean deadFish[] = new boolean[17];

	// X, 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상 1~8
	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 0, -2, -2, -2, 0, 2, 2, 2 };
}
