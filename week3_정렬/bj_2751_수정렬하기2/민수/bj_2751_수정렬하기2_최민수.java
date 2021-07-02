package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//[실버 5] 수 정렬하기2
//https://www.acmicpc.net/problem/2751
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2751_수정렬하기2_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2751"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> answer = new ArrayList<>();
		// 모든 원소 삽입
		for (int i = 0; i < n; i++) {
			answer.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(answer);

		StringBuilder sb = new StringBuilder();
		for (Integer i : answer) {
			sb.append(i + "\n");

		}
		System.out.println(sb.toString());

		br.close();
	}
}
