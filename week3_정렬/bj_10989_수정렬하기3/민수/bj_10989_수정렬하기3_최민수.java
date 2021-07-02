package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

//[실버5] 수 정렬하기 3
//https://www.acmicpc.net/problem/10989
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_10989_수정렬하기3_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_10989"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] number = new int[10001];

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			number[Integer.parseInt(br.readLine())]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10001; i++) {
			for (int j = 0; j < number[i]; j++) {
				bw.write(i + "\n");
				// sb.append(i + "\n");
			}
		}

		// System.out.println(answer.toString());
		// System.out.println(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}
}
