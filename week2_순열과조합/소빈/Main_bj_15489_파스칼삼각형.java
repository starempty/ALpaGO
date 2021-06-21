package bj_silver;

import java.util.Scanner;

public class Main_bj_15489_파스칼삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt()-1;
		int c = sc.nextInt()-1;
		int w = sc.nextInt();
		int[][] tri = new int[33][33];
		maketri(tri);
		int ans = 0;
		for(int i = r, cnt = 1; cnt <= w; i++, cnt++) {
			for(int j = c; j-c < cnt; j++) {
				ans += tri[i][j];
			}
		}
		System.out.println(ans);
		sc.close();
	}

	private static void maketri(int[][] tri) {
		for(int i = 0; i < tri.length; i++) {
			tri[i][0] = tri[i][i] = 1;
		}
		for(int i = 0; i < tri.length; i++) {
			for(int j = 1; j < i; j++) {
				tri[i][j] = tri[i-1][j-1]+tri[i-1][j];
			}
		}
	}
}
