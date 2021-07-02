package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//[실버 5] 소트 인사이드
//https://www.acmicpc.net/problem/1427
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1427_소트인사이드_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1427"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int number[] = new int[10]; // 0~9 각 자리수
		String target[] = br.readLine().split("");

		for (String s : target) {
			number[Integer.parseInt(s)]++;
		}

		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < number[i]; j++) {
				bw.write(String.valueOf(i));
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
