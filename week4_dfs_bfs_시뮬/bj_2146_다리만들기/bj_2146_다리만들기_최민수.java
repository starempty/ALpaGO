package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//[골드 3] 다리 만들기
//https://www.acmicpc.net/problem/2146
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2146_다리만들기_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2146"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = -Integer.parseInt(st.nextToken()); // -1로 저장
			}
		}

		// 섬 번호 입력, 1부터 시작
		int islandNum = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == -1) {
					// bfs
					dfs(map, i, j, islandNum++);

				}
			}
		}

		// for (int[] is : map) {
		// System.out.println(Arrays.toString(is));
		// }

		// 다리 건설
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					// bfs
					int[][] tempMap = copy(map);
					// for (int[] is : tempMap) {
					// System.out.println(Arrays.toString(is));
					// }
					bfs(tempMap, i, j);

				}
			}
		}

		bw.write(String.valueOf(min - 1));

		bw.flush();
		bw.close();
		br.close();
	}

	private static int[][] copy(int[][] map) {
		int n = map.length;
		int[][] temp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = map[i][j];
			}

		}

		return temp;
	}

	private static void bfs(int[][] map, int i, int j) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		q.offer(j);
		q.offer(0); // 거리

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			int len = q.poll();
			// 이미 방문했던 곳
			// if (map[x][y] == -9)
			// continue;

			// 다른 나라 찾았다.
			if (map[i][j] != map[x][y] && map[x][y] > 0) {
				// System.out.println(len);
				min = Math.min(min, len);
				break;
			}

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length)
					continue;

				// 사방에 같은 나라 아니고, 나라거나 바다이면
				if (map[nx][ny] != map[i][j] && map[nx][ny] >= 0) {
					// 방문표시
					if (map[nx][ny] == 0)
						map[nx][ny] = -9;
					q.offer(nx);
					q.offer(ny);
					q.offer(len + 1);
				}

			}
		}

		// for (int[] is : map) {
		// System.out.println(Arrays.toString(is));
		// }

	}

	private static void dfs(int[][] map, int i, int j, int num) {
		map[i][j] = num;

		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] != -1)
				continue;

			dfs(map, nx, ny, num);

		}

	}

	static int min = Integer.MAX_VALUE;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

}
