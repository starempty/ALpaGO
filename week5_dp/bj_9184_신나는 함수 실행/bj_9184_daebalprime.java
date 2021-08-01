import java.io.*;
import java.util.*;

public class Main {
	static int[][][] dp ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		dp = new int[21][21][21];
		for(int[][] ia : dp) {
			for(int[] iaa : ia) {
				for(int i = 0; i < 21; i++) {
					iaa[i] = Integer.MIN_VALUE;
				}
			}
		}
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(A == -1 && B == -1 && C == -1) {
				break;
			}
			int ans = recursive(A,B,C);
			sb.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(") = ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static int recursive(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c<= 0) return 1;
		if(a > 20 || b > 20 || c > 20) {
			return recursive(20,20,20);
		}
		if(a < b && b < c) {
			int r1 = memo(a,b,c-1);
			int r2 = memo(a,b-1,c-1);
			int r3 = memo(a,b-1,c);
			return r1+r2-r3;
		}
		return memo(a-1,b,c) + memo(a-1,b-1,c) + memo(a-1,b,c-1) - memo(a-1,b-1,c-1);
	}
	static int memo(int a, int b, int c) {
		if(dp[a][b][c] != Integer.MIN_VALUE) return dp[a][b][c];
		return dp[a][b][c] = recursive(a,b,c);
	}

}
