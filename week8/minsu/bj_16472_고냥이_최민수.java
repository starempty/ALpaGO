package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//[골드 3] 고냥이
//https://www.acmicpc.net/problem/16472
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_16472_고냥이_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_16472"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 문자열 길이가 K일때 K/2 -> K/4 ~ 이렇게 이분탐색을 한다.
		// 주어진 알파벳이 N개일 때 N개로 K길이 만들 수 있어?
		// N/2개는 만들 수 있나?

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char[] arr = str.toCharArray();
		// 최대 문자열 길이
		int high = str.length();
		int answer = high / 2;
		int low = 1;
		int[] size = new int[str.length() + 1]; // -1 실패, 0 미방문, 1 성공

		Loop1: while (low <= high) {
			// System.out.println(high + " " + answer + " " + low);
			if (high - answer <= 1 && size[answer] == 1 && size[high] == -1) {
				break;
			}
			if (size[answer] == -1 && size[answer - 1] == 1) {
				answer--;
				break;
			}
			answer = (low + high) / 2;

			// 알파벳 길이를 저장.
			int[] alphabet = new int[26];
			// 알파벳 종류
			int kind = 0;
			// answer 길이만큼을 n 종류의 문자열로 만들 수 있는지 확인
			for (int i = 0; i < answer; i++) {
				// alphabet에 기록된 적이 없다 == 새로운 종류다
				if (alphabet[(int) arr[i] - 'a'] == 0) {
					kind++;
				}
				// alphabet 추가
				alphabet[(int) arr[i] - 'a']++;
			}
			// 만약에 추가된 종류가 n보다 작다면 크기를 키워야 한다.
			if (kind <= n) {
				size[answer] = 1;
				low = answer + 1;
				continue Loop1;
			}

			// 슬라이딩 윈도우로 kind를 계속 확인
			for (int i = answer; i < str.length(); i++) {
				alphabet[(int) arr[i - answer] - 'a']--;
				if (alphabet[(int) arr[i - answer] - 'a'] == 0) {
					kind--;
				}
				if (alphabet[(int) arr[i] - 'a'] == 0) {
					kind++;
				}
				alphabet[(int) arr[i] - 'a']++;

				// 만약에 추가된 종류가 n보다 작다면 크기를 키워야 한다.
				if (kind <= n) {
					size[answer] = 1;
					low = answer + 1;
					continue Loop1;
				}
			}

			// 여기까지 내려왔으면 이제 answer 길이를 n 종류로 만들 수 없다.
			size[answer] = -1;
			high = answer;
		}

		// System.out.println(Arrays.toString(size));
		bw.write(answer + "");

		bw.flush();
		bw.close();
		br.close();
	}
}
