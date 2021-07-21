package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//[실버 1] 영역 구하기
//https://www.acmicpc.net/problem/2583

//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2583_영역구하기_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2583"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 사각형이 있다 = 왼쪽아래 점에 1로 체크
		int arr[][] = new int[m][n];

		// 왼쪽아래, 오른 위
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int ly = Integer.parseInt(st.nextToken());
			int lx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			int hx = Integer.parseInt(st.nextToken());
			for (int j = lx; j < hx; j++) {
				for (int l = ly; l < hy; l++) {
					arr[j][l] = 1;
				}
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					area = 0;
					dfs(i, j, arr);
					pq.add(area);
				}
			}
		}

		bw.write(String.valueOf(pq.size() + "\n"));
		while (!pq.isEmpty()) {
			bw.write(String.valueOf(pq.poll() + " "));
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int area;

	static void dfs(int x, int y, int[][] arr) {
		arr[x][y] = 1;
		area++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length || arr[nx][ny] == 1)
				continue;

			dfs(nx, ny, arr);
		}

	}
}
