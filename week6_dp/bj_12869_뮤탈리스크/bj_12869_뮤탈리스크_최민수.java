package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[골드 4] 뮤탈리스크
//https://www.acmicpc.net/problem/12869
//참고: https://100100e.tistory.com/172
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_12869_뮤탈리스크_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_12869"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		scv = new int[61][61][61];
		int[] start = new int[3];
		for (int i = 0; i < n; i++) {
			start[i] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;
		min = recursive(start[0], start[1], start[2]);

		bw.write(min + "");

		bw.flush();
		bw.close();
		br.close();
	}

	// 소요된 횟수를 리턴
	private static int recursive(int a, int b, int c) {

		if (a < 0)
			return recursive(0, b, c);
		if (b < 0)
			return recursive(a, 0, c);
		if (c < 0)
			return recursive(a, b, 0);
		if (a == 0 && b == 0 && c == 0) {
			return 0;
		}
		// 저장된 값이 있으면 이것을 리턴
		if (scv[a][b][c] != 0) {
			return scv[a][b][c];
		}

		// dp를 계산한 적이 없다.
		int count = Integer.MAX_VALUE;
		count = Math.min(count, recursive(a - 9, b - 3, c - 1) + 1);
		count = Math.min(count, recursive(a - 9, b - 1, c - 3) + 1);
		count = Math.min(count, recursive(a - 3, b - 9, c - 1) + 1);
		count = Math.min(count, recursive(a - 1, b - 9, c - 3) + 1);
		count = Math.min(count, recursive(a - 3, b - 1, c - 9) + 1);
		count = Math.min(count, recursive(a - 1, b - 3, c - 9) + 1);

		scv[a][b][c] = count;
		return count;
	}

	static int min;
	static int[][][] scv;
}
