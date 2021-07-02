package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//[브론즈 1] 수 정렬하기
//https://www.acmicpc.net/problem/2750
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2750_수정렬하기_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2750"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> answer = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			// a를 알맞은 곳에 삽입한다.
			// 단, 0번째 원소는 바로 삽입
			if (i == 0) {
				answer.add(a);
			} else {
				// 처음부터 자신이 비교값보다 커질때까지 탐색
				for (int j = 0; j < answer.size(); j++) {
					// 시작부터 작으면
					if (answer.get(j) > a) {
						answer.add(j, a);
						break;
					}

					if (answer.get(j) < a) {
						// 그런데 다음원소도 나보다 작으면 한번더 탐색하자.
						if (j + 1 < answer.size() && answer.get(j + 1) < a)
							continue;
						else {
							answer.add(j + 1, a);
							break;

						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Integer i : answer) {
			sb.append(i).append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
