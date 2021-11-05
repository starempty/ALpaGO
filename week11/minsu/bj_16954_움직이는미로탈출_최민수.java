package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

//[골드 5] 움직이는 미로 탈출
//https://www.acmicpc.net/problem/16954
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_16954_움직이는미로탈출_최민수 {

	static char[][][] wallMap; // 벽이 0초일때, 1초일 때, ... 9초 이후일 때 상태
	static boolean[][][] visited; // x, y, time 시간에 방문한 적이 있는가?
	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 }; // 중앙, 위, 오른위, 시계방향
	static int[] dy = { 0, 0, 1, 1, 1, 0, -1, -1, -1 }; // 중앙, 위, 오른위, 시계방향

	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_16954"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		wallMap = new char[8][8][100];
		// 초기 입력
		for (int i = 0; i < 8; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				wallMap[i][j][0] = input[j];
			}
		}

		// 벽 상태 저장
		simulateWall(wallMap);

		// dfs가 맞을까 bfs가 맞을까
		visited = new boolean[8][8][100];
		bw.write(bfs() + "");

		bw.flush();
		bw.close();
		br.close();
	}

	private static int bfs() {

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(7);
		q.add(0);
		q.add(0);
		while (!q.isEmpty()) {
			int nowx = q.poll();
			int nowy = q.poll();
			int nowtime = q.poll();

			// time9이후부터는 wall map을 안만들어뒀다.
			if (nowtime >= 7 && wallMap[0][0][nowtime + 1] != '.') {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						wallMap[i][j][nowtime + 1] = '.';
					}

				}
			}

			if (nowx == 0 && nowy == 7) {
				return 1;
			}

			if (wallMap[nowx][nowy][nowtime] == '#') {
				continue;
			}
			if (visited[nowx][nowy][nowtime]) {
				continue;
			}
			visited[nowx][nowy][nowtime] = true;

			for (int i = 0; i < 9; i++) { // 9방향
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];

				if (nextx < 0 || nextx >= 8 || nexty < 0 || nexty >= 8) {
					continue;
				}
				if (visited[nextx][nexty][nowtime + 1]) {
					continue;
				}

				// 현재에 그 공간에 벽이 있다.
				if (wallMap[nextx][nexty][nowtime] == '#') {
					continue;
				}

				// 미래에 그 공간에 벽이 있다.
				if (wallMap[nextx][nexty][nowtime + 1] == '#') {
					continue;
				}

				q.add(nextx);
				q.add(nexty);
				q.add(nowtime + 1);
			}

		}
		return 0;
	}

	private static void simulateWall(char[][][] map) {

		// 이전 시간대에서 한칸씩 내리면 된다.
		for (int time = 1; time < 9; time++) {
			for (int i = 7; i > 0; i--) { // 맨밑
				for (int j = 0; j < 8; j++) {
					map[i][j][time] = map[i - 1][j][time - 1];
				}
			}
			for (int i = 0; i < 8; i++) {
				map[0][i][time] = '.';
			}
		}

	}
}
