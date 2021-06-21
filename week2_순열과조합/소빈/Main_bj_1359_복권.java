package bj_silver;

import java.util.Scanner;

public class Main_bj_1359_복권 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		double[][] memo = new double[10][10];
		for(int i = 0; i < 10; i++) memo[i][0] = memo[i][i] = 1;
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < i; j++) {
				memo[i][j] = memo[i-1][j-1]+memo[i-1][j];
			}
		}
		
		double ans = 0;
		for(int i = 0; i < k; i++) {
			ans += memo[m][i]*memo[n-m][m-i]/memo[n][m];
		}
		System.out.println(1-ans);
		
		sc.close();
	}
}
