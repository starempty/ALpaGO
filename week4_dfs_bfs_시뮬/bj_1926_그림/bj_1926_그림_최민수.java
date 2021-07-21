package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[실버 1] 그림
//https://www.acmicpc.net/problem/1926
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1926_그림_최민수 {

	static int number, area, temp_area;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1926"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// DFS로 방문하면서 1을 2로 바꾸는 방문처리를 한다.
		// DFS인 이유: 카운팅하기 좀 더 수월해서

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
			}
		}

		number = 0;
		area = 0;
		temp_area = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					temp_area = 0;
					number++;
					dfs(arr, i, j);
				}
			}
		}

		bw.write(number + "\n");
		bw.write(area + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int[][] arr, int i, int j) {
		// 방문 처리
		arr[i][j] = 2;
		temp_area++;
		area = Math.max(area, temp_area);

		// 상하좌우 이동가능한지 체크
		int nx, ny;
		for (int k = 0; k < 4; k++) {
			nx = i + dx[k];
			ny = j + dy[k];

			// 범위 체크
			if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length)
				continue;

			if (arr[nx][ny] == 1)
				dfs(arr, nx, ny);
		}

	}
}
