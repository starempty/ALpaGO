import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken())-1;
		int C = Integer.parseInt(st.nextToken())-1;
		int W = Integer.parseInt(st.nextToken());
		long answer = 0;
		for(int j = 0; j < W; j++) {
			for(int i = 0; i < j+1; i++) {
//				System.out.println((R+j) +" " + (C+i));
				answer += combination(R+j, C+i);
			}
		}
//		System.out.println(combination(5,4));
		System.out.println(answer);
		br.close();
	}
	
	private static int combination(int M, int N) {
		int answer = 1;
		N = Math.min(N, M-N);
		for(int i = 0; i < N; i++) {
			answer *= (M-i);
			answer /= (i+1);
		}
		return answer;
	}

}
