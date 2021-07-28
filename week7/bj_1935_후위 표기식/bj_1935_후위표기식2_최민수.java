package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

//[실버 3] 후위 표기식2
//https://www.acmicpc.net/problem/1935
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1935_후위표기식2_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1935"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Double> stack = new Stack<>();

		int num = Integer.parseInt(br.readLine());

		char[] str = br.readLine().toCharArray();
		int[] alpha = new int[num];
		for (int i = 0; i < num; i++) {
			alpha[i] = Integer.parseInt(br.readLine());
		}
		// System.out.println(str);
		// System.out.println(Arrays.toString(alpha));
		for (int i = 0; i < str.length; i++) {
			if (str[i] >= 65 && str[i] <= 90) { // 숫자이면 스택에 넣고
				stack.push((double) alpha[(int) str[i] - 65]);
			} else {
				double a = stack.pop();
				double b = stack.pop();
				double result = 0;
				if (str[i] == '+') {
					result = a + b;
				} else if (str[i] == '-') {
					result = b - a;
				} else if (str[i] == '*') {
					result = a * b;
				} else if (str[i] == '/') {
					result = b / a;
				}
				stack.push(result);
			}
		}

		bw.write(String.format("%.2f", stack.pop()));
		// bw.write(Math.round(stack.pop() * 100) / 100.0 + "");

		bw.flush();
		bw.close();
		br.close();
	}
}
