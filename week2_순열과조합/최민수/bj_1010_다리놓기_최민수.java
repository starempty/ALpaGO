package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[실버5] 다리놓기
//https://www.acmicpc.net/problem/1010
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1010_다리놓기_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1010"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//M C N, 30까지
		int tc = Integer.parseInt(br.readLine());
		for (int T = 0; T < tc; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long answer = 1;
			if(n > m/2) n = m-n;
			
			for (int i = m; i > m-n; i--) {
				answer *= i;
			}
			for (int i = n; i > 0; i--) {
				answer /= i;
			}
			System.out.println(answer);
		}
		
	
		br.close();
	}
}
