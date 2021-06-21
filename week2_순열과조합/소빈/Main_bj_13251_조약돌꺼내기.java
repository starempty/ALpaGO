package bj_silver;

import java.io.*;
import java.util.*;

public class Main_bj_13251_조약돌꺼내기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int [] arr = new int[m];
		int n = 0;
		for(int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			n += arr[i];
		}
		int k = Integer.parseInt(br.readLine());
		
		double[][] memo = new double[n+1][n+1];
		for(int i = 0; i < n+1; i++) memo[i][0] = memo[i][i] = 1;
		for(int i = 2; i < n+1; i++) {
			for(int j = 1; j < i; j++) memo[i][j] = memo[i-1][j-1]+memo[i-1][j];
		}
		
		double ans = 0;
		for(int a: arr) {
			if(a >= k) ans += memo[a][k];
		}
		ans /= memo[n][k];
		
		System.out.println(ans);
	}
}
