package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//[실버 2] 캡틴 이다솜
//https://www.acmicpc.net/problem/1660
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1660_캡틴이다솜_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1660"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int superlength = 123; // 121번째부터 30만 넘어감

		int subsum[] = new int[superlength];
		for (int i = 1; i < subsum.length; i++) {
			subsum[i] = (i + 2) * (i + 1) / 2;
		}

		int tetra[] = new int[superlength];
		tetra[1] = 1;
		for (int i = 2; i < tetra.length; i++) {
			tetra[i] = tetra[i - 1] + subsum[i - 1];
		}

		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[300001];
		dp[1] = 1;
		for (int i = 2; i < 300001; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; j < tetra.length; j++) {
				if (tetra[j] > i)
					break;
				dp[i] = Math.min(dp[i], dp[i - tetra[j]] + 1);
			}
			if (i == n)
				break;
		}

		bw.write(String.valueOf(dp[n]));

		bw.flush();
		bw.close();
		br.close();
	}
}
