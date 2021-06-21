import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int total = combination(N,M);
		
		if(M - (N-M) >= K) {
			System.out.println(1);
			return;
		}
		
		
		int get = 0;
		for(int i = K; i <= M; i++) {
			get += combination(M, i)*combination(N-M,M-i);
		}
		System.out.println(((double)get)/total);
		
		bw.flush();
		br.close();
		bw.close();
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
