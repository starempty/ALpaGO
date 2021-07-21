package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[실버 2] 신나는 함수 실행
//https://www.acmicpc.net/problem/9184
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_9184_신나는함수실행_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_9184"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 값을 계속해서 저장하면서 가자
		arr = new int[102][102][102];
		// 0, 0, 0 = -50 -50 -50,
		// 50, 50, 50 = 0, 0, 0,
		// [100][100][100] = 50, 50, 50

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1)
				break;

			recursion(a, b, c);
			bw.write("w(" + String.valueOf(a) + ", " + String.valueOf(b) + ", " + String.valueOf(c) + ") = "
					+ arr[a + 50][b + 50][c + 50] + "\n");

		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static int recursion(int a, int b, int c) {
		if (arr[a + 50][b + 50][c + 50] != 0) {
			return arr[a + 50][b + 50][c + 50];
		} else if (a <= 0 || b <= 0 || c <= 0) {
			arr[a + 50][b + 50][c + 50] = 1;
			return 1;
		} else if (a > 20 || b > 20 || c > 20) {
			arr[a + 50][b + 50][c + 50] = recursion(20, 20, 20);
			return arr[a + 50][b + 50][c + 50];
		} else if (a < b && b < c) {
			arr[a + 50][b + 50][c + 50] = recursion(a, b, c - 1) + recursion(a, b - 1, c - 1) - recursion(a, b - 1, c);
			return arr[a + 50][b + 50][c + 50];
		} else {
			arr[a + 50][b + 50][c + 50] = recursion(a - 1, b, c) + recursion(a - 1, b - 1, c) + recursion(a - 1, b, c - 1)
					- recursion(a - 1, b - 1, c - 1);
			return arr[a + 50][b + 50][c + 50];
		}

	}

	static int arr[][][];
}
