package bj;

import java.io.*;
import java.util.*;

public class Main_bj_1010_다리놓기 {
	static int[][] memo;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		memo = new int[31][31];
		makememo();
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(memo[m][n]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void makememo() {
		for(int i = 0; i < 31; i++) {
			memo[i][0] = memo[i][i] = 1;
		}
		for(int i = 2; i < 31; i++) {
			for(int j = 1; j < i; j++) {
				memo[i][j] = memo[i-1][j-1]+memo[i-1][j];
			}
		}
	}
}
