package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[실버 2] 잃어버린 괄호
//https://www.acmicpc.net/problem/1541
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1541_잃어버린괄호_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1541"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 한 번이라도 음수가 나오면 그 뒤는 다 괄호를 쳐서 뺴기로 만들 수 있다.
		boolean minusState = false;

		String formula = br.readLine();
		char[] cf = formula.toCharArray();
		// 숫자만 짜르는 것은 구분자 2개를 써서 자르면 된다.

		// - 찾는 것은 처음부터 끝까지 조회하면서 '-'있는지 확인하고
		// 그 과정에서 '+'갯수 세아리기
		int count = 0;
		for (int i = 0; i < cf.length; i++) {
			if (cf[i] == '+')
				count++;
			else if (cf[i] == '-') {
				count++;
				minusState = true;
				break;
			}
		}
		// 음수가 없었다 = 마지막까지 더해야함
		if (!minusState)
			count++;

		// 1번~count번째까지 수까지 더하면 됨.
		StringTokenizer st = new StringTokenizer(formula, "+|-");
		int answer = 0;
		int finishOperation = 0;
		while (st.hasMoreTokens()) {
			if (finishOperation < count) {
				answer += Integer.parseInt(st.nextToken());
			} else {
				answer -= Integer.parseInt(st.nextToken());
			}
			finishOperation++;
		}

		bw.write(answer + "");

		bw.flush();
		bw.close();
		br.close();
	}
}
