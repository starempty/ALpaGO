package bj;

import java.util.Scanner;

public class Main_bj_16395_파스칼의삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] tri = new int[31][31];
		maketri(tri);
		System.out.println(tri[n-1][k-1]);
		sc.close();
	}

	private static void maketri(int[][] tri) {
		for(int i = 0; i < 31; i++) {
			tri[i][0] = tri[i][i] = 1;
		}
		
		for(int i = 2; i < 31; i++) {
			for(int j = 1; j < i; j++) {
				tri[i][j] = tri[i-1][j-1]+tri[i-1][j];
			}
		}
	}
}
