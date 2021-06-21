package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[브론즈1] 파스칼의 삼각형
//https://www.acmicpc.net/problem/16395
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_16395_파스칼의삼각형_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_16395"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken()) - 1;
		long k = Integer.parseInt(st.nextToken()) - 1;
		
		//4C1 == 4C3
		if(k > n/2) k = n - k;
		
		long answer = 1;
		for (long i = n; i > n-k; i--) {
			answer *= i;
		}
		for (long i = k; i > 0; i--) {
			answer /= i;
		}
		System.out.println(answer);
	
		br.close();
	}
}
