package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[브론즈1] 이항계수
//https://www.acmicpc.net/problem/11050
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_11050_이항계수1_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_11050"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//N이 10이면 다 곱해도 1억이 안됨
		int answer = 1;
		for (int i = n; i > n-k ; i--) {
			answer *= i;
		}
		for (int i = k; i > 0; i--) {
			answer /= i;
		}
		System.out.println(answer);
	
		br.close();
	}
}
