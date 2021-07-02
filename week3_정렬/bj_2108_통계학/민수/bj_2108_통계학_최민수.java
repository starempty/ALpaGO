package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

//[실버4] 통계학
//https://www.acmicpc.net/problem/2108
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2108_통계학_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2108"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 최반값을 알기위해선 숫자별로 배열을 선언해서 세아려야 한다.
		// 나머지는 linked list에 정렬하면 될 듯
		ArrayList<Integer> number = new ArrayList<>();
		int[] count = new int[8002]; // [0] = -4000, [4000]: 0, [8000]: +4000

		int n = Integer.parseInt(br.readLine());
		// 50만 * 4천 = 20억짜리. int 범위 안
		int sum = 0;
		// min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			number.add(a);

			// 최빈값용
			count[a + 4000]++;
			// 산술평균용
			sum += a;
			// 범위
			// min = Integer.min(min, a);
			// max = Integer.max(max, a);
		}

		Collections.sort(number);

		// 평균
		bw.write((int) Math.round((float) sum / n) + "\n");
		// 중앙값
		bw.write(number.get(n / 2) + "\n");
		// 최빈값, 같은게 많으면 두번째로 작은 값
		int mode = 0;
		int cnt = 0;
		int where = 0;
		for (int i = 0; i < count.length; i++) {
			if (mode < count[i]) {
				mode = count[i];
				where = i;
				cnt = 1;
			} else if (mode == count[i]) {
				cnt++;
				if (cnt == 2) {
					where = i;
				}
			}
		}
		bw.write(where - 4000 + "\n");
		// 범위
		bw.write(number.get(number.size() - 1) - number.get(0) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
