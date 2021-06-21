package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[실버3] 조약돌 꺼내기
//https://www.acmicpc.net/problem/13251
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_13251_조약돌꺼내기_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_13251"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//조약돌 색상 수
		int m = Integer.parseInt(br.readLine());
		
		//색상별 조약돌 수
		int[] color = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int temp = 0;
		int n = 0;
		while(st.hasMoreTokens()) {
			color[temp] = Integer.parseInt(st.nextToken());
			n += color[temp];
			temp++;
		}
		
		int k = Integer.parseInt(br.readLine());
		
		//a색상 조약돌만 뽑는 경우+ B만 + ... / 전체 경우
		double all = makeComb(n, k);
		double oneColor = 0;
		for (int i = 0; i < color.length; i++) {
			if(color[i] < k) continue;
			oneColor += makeComb(color[i], k);
		}
		
		System.out.println(oneColor / all);
		
		//조합 함수
	
		br.close();
	}

	private static double makeComb(int n, int k) {
		double answer = 1;
		
		if(k > n/2) k = n-k;
		for (int i = n; i > n-k; i--) {
			answer *= i;
		}
		for (int i = k; i > 0; i--) {
			answer /= i;
		}
		
		return answer;
	}
}
