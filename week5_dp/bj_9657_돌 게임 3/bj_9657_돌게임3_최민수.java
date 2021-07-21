package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//[실버 3] 돌 게임 3
//https://www.acmicpc.net/problem/9657
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_9657_돌게임3_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_9657"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		boolean stone[] = new boolean[1001];
		stone[1] = true; // SK
		stone[2] = false;
		stone[3] = true;
		stone[4] = true;
		// 뺀 값이 false가 나오면 무조건 내가 이김
		for (int i = 5; i <= 1000; i++) {
			if (!stone[i - 4]) {
				stone[i] = true;
			} else if (!stone[i - 3]) {
				stone[i] = true;
			} else if (!stone[i - 1]) {
				stone[i] = true;
			} else {
				stone[i] = false;
			}
			if (n == i)
				break;
		}

		if (stone[n])
			bw.write("SK");
		else
			bw.write("CY");

		bw.flush();
		bw.close();
		br.close();
	}
}
