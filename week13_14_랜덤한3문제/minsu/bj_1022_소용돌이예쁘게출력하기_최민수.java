package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[골드 4] 소용돌이 예쁘게 출력하기
//https://www.acmicpc.net/problem/1022
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
//참고: https://leveloper.tistory.com/80
public class bj_1022_소용돌이예쁘게출력하기_최민수 {
	static int[][] answerMap;
	static int r1, c1, r2, c2, R, C;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1022"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		R = r2 - r1 + 1;
		C = c2 - c1 + 1;
		answerMap = new int[R][C];

		// 전체 배열 만들기
		makeTotal();
		
		//배열 추출하기
		makeAnswer(bw);

		bw.flush();
		bw.close();
		br.close();
	}

	private static void makeAnswer(BufferedWriter bw) throws IOException {
		//최대 자릿수
		int maxSpace = (int) Math.max(Math.log10(answerMap[0][0]),
				Math.log10(answerMap[R-1][C-1])) + 1;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int diffSpace = maxSpace - (int) Math.log10(answerMap[i][j]) - 1;
				for (int k = 0; k < diffSpace; k++) {
					bw.write(" ");
				}
				bw.write(answerMap[i][j] + " ");
			}
			bw.write("\n");
		}
	}

	private static void makeTotal() {
		int moveSpace = 2;
		int x = 5000;
		int y = 5000;
		int value = 1;
		int r15 = r1 + 5000;
		int c15 = c1 + 5000;
		int r25 = r2 + 5000;
		int c25 = c2 + 5000;
		
		if (5000 >= r15 && 5000 <= r25 && 5000 >= c15 && 5000 <= c25) {
			answerMap[x-r15][y-c15] = 1;
		}
		LOOP: while (true) {
			for (int dir = 0; dir < 4; dir++) { //0: 위쪽, 1: 왼쪽, 2: 아래쪽, 3: 오른쪽
				if (dir == 0) { //현재 자기 위치에서 오른쪽으로 한칸 가서 기록 -> moveSpace-1칸만큼 방향으로 이동하고 기록
					//일단 오른쪽로 한칸 이동
					y++;
					if (y == 10001) {
						break LOOP;
					}
					if (x >= r15 && x <= r25 && y >= c15 && y <= c25) {
						answerMap[x-r15][y-c15] = ++value;
					} else {
						value++;
					}
					for (int i = 1; i < moveSpace; i++) {
						x--;
						if (x >= r15 && x <= r25 && y >= c15 && y <= c25) {
							answerMap[x-r15][y-c15] = ++value;
						} else {
							value++;
						}
					}
				} else { //현재 자기 위치에서 moveSpace칸만큼 방향으로 이동하고 기록
					int nx = -1;
					int ny = -1;
					for (int i = 1; i <= moveSpace; i++) {
						nx = x + dx[dir] * i;
						ny = y + dy[dir] * i;
						if (nx >= r15 && nx <= r25 && ny >= c15 && ny <= c25) {
							answerMap[nx-r15][ny-c15] = ++value;
						} else {
							value++;
						}
					}
					x = nx;
					y = ny;
				}
			}
			moveSpace += 2;
		}

	}
}
