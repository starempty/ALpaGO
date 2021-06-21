package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[실버5] 복권
//https://www.acmicpc.net/problem/1359
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1359_복권_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1359"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//당첨된 경우: k개 일치하는 경우 + k+1개 일치 + ... + m개 일치
		//m개 중에 k개를 뽑고 * 나머지 중에 m-k개 뽑기
		long win = makeWin(n, m, k);
		//전체 경우의 수: nCm
		long all = makeComb(n, m);
		
		System.out.println((double)win/all);
//		System.out.println(String.format("%.9f", (double)b/a));
	
		br.close();
	}

	private static long makeWin(int n, int m, int k) {
		long answer = 0;
		for (int i = k; i <= m; i++) {
			if(n-m < m-i) continue;
			answer += makeComb(m, i) * makeComb(n-m, m-i);			
		}
		return answer;
	}

	private static long makeComb(int n, int m) {
		if(m > (n/2)) m = n-m;
		long answer = 1;
		for (int i = n; i > n-m; i--) {
			answer *= i;
		}
		for (int i = m; i > 0; i--) {
			answer /= i;
		}
		
		return answer;
	}
}
