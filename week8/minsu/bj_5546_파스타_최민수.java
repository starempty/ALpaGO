package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[골드 5] 파스타
//https://www.acmicpc.net/problem/5546
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
//참고: https://codersbrunch.blogspot.com/2017/04/5546-pasta.html
public class bj_5546_파스타_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_5546"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][4][2]; // [a][b][c]: a턴에 1턴 전 값이 b이고, 2턴 전 값이 c인 경우 가능한 경우의 수

		eat = new int[n + 1];

		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int day = Integer.parseInt(st.nextToken());
			int pasta = Integer.parseInt(st.nextToken());
			eat[day] = pasta;
		}

		int answer = dynamic(0, 0, 1); // a날에 b를 먹으면서 연속으로 먹었다(c==1)

		bw.write(answer + "");

		bw.flush();
		bw.close();
		br.close();
	}

	static int[] eat;
	static int[][][] dp;
	static int n;

	// staright == 0: 연속해서 먹었다.
	// ==1: 불연속하게 먹었다.
	private static int dynamic(int day, int pasta, int straight) {

		// 이미 이 날에 먹을 것이 정해져 있고, 재귀로 들어온 값이 그 값이 아니면
		if (eat[day] != 0 && eat[day] != pasta) {
			return 0;
		}
		// n일차면 1 반환
		if (day == n) {
			return 1;
		}
		// 기존의 dp 값이 있으면
		if (dp[day][pasta][straight] != 0) {
			return dp[day][pasta][straight];
		}
		// 연속해서 먹었으면 0을 반환
		// 연속해서 먹는 경우
		int temp = (straight == 1) ? 0 : dynamic(day + 1, pasta, 1);

		for (int i = 1; i <= 3; i++) {
			// 비연속해서 먹는 경우
			if (pasta != i) {
				temp = (temp + dynamic(day + 1, i, 0)) % 10000;
			}
		}

		return dp[day][pasta][straight] = temp;
	}

}
