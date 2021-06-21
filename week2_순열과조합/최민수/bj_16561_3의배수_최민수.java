package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//[브론즈3] 3의배수
//https://www.acmicpc.net/problem/16561
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_16561_3의배수_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_16561"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		
		//경우의 수가 없다.
		if(n <= 8) System.out.println(0);
		
		n = (n-9)/3 + 1;
		System.out.println(n * (n+1) / 2);

		br.close();
	}
}
