package a0814;

import java.io.*;
import java.util.*;

public class Main_bj_14938_서강그라운드 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] item = new int[n];
		st=  new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		int[][] arr = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n;j++) {
				if(i == j) arr[i][j] = 0;
				else arr[i][j] = 99999;
			}
		}
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			arr[a][b] = Integer.min(arr[a][b], l);
			arr[b][a] = Integer.min(arr[b][a], l);
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n;j++) {
				for(int k = 1; k <= n; k++) {
					if(j == k) continue;
					arr[j][k] = Integer.min(arr[j][i]+arr[i][k], arr[j][k]);
				}
			}
		}
//		for(int[] a: arr) System.out.println(Arrays.toString(a));
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			for(int j = 1; j <= n; j++) {
				if(arr[i][j] > m) continue;
				sum += item[j-1];
			}
			max = Integer.max(max, sum);
		}
		
		System.out.println(max);
	}
}
