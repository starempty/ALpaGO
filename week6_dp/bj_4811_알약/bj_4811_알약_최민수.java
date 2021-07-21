package baekjoon_04001_05000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//[골드 5] 알약
//https://www.acmicpc.net/problem/4811
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_4811_알약_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_4811"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 남은 개수가 [a]W, [b]H 일 때경우의 수
		dp = new long[32][32];
		dp[1][0] = 1;
		for (int i = 0; i < 32; i++) {
			dp[1][i] = i + 1;
		}

		for (int i = 2; i < 31; i++) {
			for (int j = 0; j < 31; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j + 1];
				} else {
					dp[i][j] = dp[i - 1][j + 1] + dp[i][j - 1];
				}
			}
		}

		while (true) {
			int temp = Integer.parseInt(br.readLine());
			if (temp == 0)
				break;
			bw.write(String.valueOf(dp[temp][0]) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static long dp[][];
}
