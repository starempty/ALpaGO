package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//[골드 3] 소문난 칠공주
//https://www.acmicpc.net/problem/1941
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1941_소문난칠공주_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1941"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		answer = 0;

		for (int i = 0; i < 5; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 5; j++) {
				map[i][j] = temp[j];
			}

		}

		// 25개 중에 7개를 뽑는다. 25 c 7 = 48만
		// 그 중에 S가 4개 이상 포함되지 않은 것은 제외한다.
		// 남은 것 중에 DFS를 돌려서 살아남은 것은 정답 개수에 추가한다.

		comb(0, 0);

		bw.write(String.valueOf(answer));

		bw.flush();
		bw.close();
		br.close();
	}

	private static void comb(int selectedNum, int startPoint) {
		if (selectedNum == 7) {
			// System.out.println(Arrays.toString(selected));

			// 현재 뽑은 조합에 S가 4개 이상 포함되어있는지 확인
			if (checkFourS(selected)) {
				// && DFS 돌려서 다 갈 수 있는지 체크
				if (connected(selected)) {
					// 되면 answer ++
					answer++;
				}
			}
			// 다 끝나면 => 다음 조합 뽑기
			return;
		}

		for (int i = startPoint; i < 25; i++) {
			if (visited[i])
				continue;

			selected[selectedNum] = i;
			visited[i] = true;
			comb(selectedNum + 1, i + 1);
			visited[i] = false;
			selected[selectedNum] = 0; // 필요없나?
		}

	}

	private static boolean connected(int[] selected2) {
		// dfs를 돌면서 저기에 속하지 않았으면 컷

		boolean visit[] = new boolean[7];
		int x = selected2[0] / 5;
		int y = selected2[0] % 5;

		connect = false;
		dfs(visit, x, y, 0);

		return connect;
	}

	private static void dfs(boolean[] visit, int x, int y, int visitPoint) {

		visit[visitPoint] = true;
		// 7개 모두 방문했으면
		int visitCount = 0;
		for (int i = 0; i < visit.length; i++) {
			if (visit[i])
				visitCount++;
		}
		if (visitCount == 7) {
			connect = true;
			return;
		}

		// dfs돌린다.
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위 밖인가?
			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
				continue;

			// 이게 selected 원소가 아닌가?
			int nnum = 5 * nx + ny;
			for (int j = 0; j < 7; j++) {
				if (selected[j] == nnum) { // 있다.
					// 방문한적이 없는가
					if (!visit[j])
						dfs(visit, nx, ny, j);
				}
			}

		}

	}

	private static boolean checkFourS(int[] selected2) {
		int Scount = 0;

		for (int i = 0; i < 7; i++) {
			int x = selected2[i] / 5;
			int y = selected2[i] % 5;
			if (map[x][y] == 'S')
				Scount++;

			if (Scount >= 4)
				return true;
		}

		return false;
	}

	static char[][] map = new char[5][5];

	static boolean connect;

	static boolean visited[] = new boolean[25];
	static int selected[] = new int[7];
	static int answer;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
}
