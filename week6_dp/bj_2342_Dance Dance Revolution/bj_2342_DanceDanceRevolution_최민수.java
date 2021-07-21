package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//[골드 3] Dance Dance Revolution
//https://www.acmicpc.net/problem/2342
//참고: https://dev-room.tistory.com/30
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2342_DanceDanceRevolution_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2342"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		input = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while (true) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				break;
			}
			input.add(num);
		}
		size = input.size();
		dp = new int[5][5][size];

		bw.write(dfs(0, 0, 0) + ""); // L, R, 턴

		bw.flush();
		bw.close();
		br.close();
	}

	static int dp[][][];
	static int size;
	static ArrayList<Integer> input;

	private static int dfs(int L, int R, int turn) {
		if (turn == size) {
			return 0;
		}
		if (dp[L][R][turn] != 0) {
			return dp[L][R][turn];
		}

		int goal = input.get(turn);
		int moveLeft = dfs(goal, R, turn + 1) + move(L, goal);
		int moveRight = dfs(L, goal, turn + 1) + move(R, goal);

		return dp[L][R][turn] = Math.min(moveLeft, moveRight);
	}

	private static int move(int start, int num) {
		if (start == 0) {
			return 2;
		} else if (Math.abs(start - num) == 2) { // 대칭
			return 4;
		} else if (start == num) {
			return 1;
		} else {
			return 3;
		}
	}
}
