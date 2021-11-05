package a0814;

import java.io.*;
import java.util.*;

public class Main_bj_11404_플로이드 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		double[][] arr = new double[n+1][n+1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == j) continue;
				arr[i][j] = Double.MAX_VALUE;
			}
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = Double.min(arr[a][b], c);
		}
//		for(double[] a: arr) System.out.println(Arrays.toString(a));
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				for(int k = 1; k <= n; k++) {
					if(j == k) continue;
					arr[j][k] = Double.min(arr[j][i]+arr[i][k], arr[j][k]);
				}
			}
		}
		System.out.println();
//		for(double[] a: arr) System.out.println(Arrays.toString(a));
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(arr[i][j] == Double.MAX_VALUE) sb.append("0 ");
				else sb.append((int)arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
