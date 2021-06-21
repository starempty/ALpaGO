package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[실버5] 파스칼 삼각형
//https://www.acmicpc.net/problem/15489
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_15489_파스칼삼각형_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_15489"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		//최대 삼각형의 높이 R+W-1
		//[층][칸]
		long[][] triangle = new long[31][31];
		
		long answer = 0;
		
		//삼각형 위에서부터 채우기
		for (int i = 1; i < 31; i++) { //층
			if(i >= r+w) break;
			for (int j = 1; j <= i; j++) { //j번째 수
				if(j == 1 || j == i) triangle[i][j] = 1;
				else triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
				
				//층 && 칸
				if(i >= r && i < r+w && j >= c && j <= c+i-r) {
					answer += triangle[i][j];
//					System.out.print(triangle[i][j] + " ");
				}
				
			}
//			System.out.println();
		}
		
//		for(long[] ii:triangle) System.out.println(Arrays.toString(ii));
		
		System.out.println(answer);
		br.close();
	}
}
