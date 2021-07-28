package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//[골드 4] 성곽
//https://www.acmicpc.net/problem/2234
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2234_성곽_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2234"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n]; // 벽표시
		room = new int[m][n]; // 몇번방 표시
		roomSize = new int[2501]; // 방크기

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		roomNum = 0;
		largestRoom = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (room[i][j] == 0) {
					int count = 0;
					bfs(i, j, count);
				}
			}
		}

		// for (int[] c : map) {
		// System.out.println(Arrays.toString(c));

		// }
		// for (int[] c : room) {
		// System.out.println(Arrays.toString(c));

		// }

		int twoRoom = 0;
		// 오른, 위 아래 확인해서 방 확인
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (room[i][j] != room[i][j + 1]) {// 오른 방
					twoRoom = Math.max(twoRoom, roomSize[room[i][j]] + roomSize[room[i][j + 1]]);
				}
			}
		}
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n; j++) {
				if (room[i][j] != room[i + 1][j]) {// 오른 방
					twoRoom = Math.max(twoRoom, roomSize[room[i][j]] + roomSize[room[i + 1][j]]);
				}
			}
		}

		bw.write(roomNum + "\n"); // 방의 개수
		bw.write(largestRoom + "\n"); // 방의 넓이
		bw.write(twoRoom + "\n"); // 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기

		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int i, int j, int count) {

		roomNum++;
		// 방문할 방의 위치를 넣음, x, y 순
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(i);
		q.add(j);

		while (!q.isEmpty()) {
			int x = q.pop();
			int y = q.pop();
			// 범위 초과
			if (x < 0 || x >= m || y < 0 || y >= n) {
				continue;
			}
			// 방문한적이 있으면 스킵
			if (room[x][y] != 0) {
				continue;
			}
			// 방문처리를 한다.
			room[x][y] = roomNum; // roomNum 방이다.
			count++; // 방의 크기

			// 하 / 우 / 상 / 좌
			char[] way = String.format("%04d", Integer.parseInt(Integer.toBinaryString(map[x][y]))).toCharArray();

			for (int k = 0; k < 4; k++) {
				// 값이 1이면 벽이 있다는 것
				if (way[k] == '1') {
					continue;
				}

				// 벽이 없으면 이동 가능 하 / 우 / 상 / 좌
				if (k == 0) {
					q.add(x + 1);
					q.add(y);
				} else if (k == 1) { // 우
					q.add(x);
					q.add(y + 1);
				} else if (k == 2) { // 상
					q.add(x - 1);
					q.add(y);
				} else if (k == 3) { // 좌
					q.add(x);
					q.add(y - 1);
				}
			}

		}

		roomSize[roomNum] = count;
		largestRoom = Math.max(largestRoom, count);
	}

	static int m, n, largestRoom, roomNum;
	static int[][] map, room;
	static int[] roomSize;
}
