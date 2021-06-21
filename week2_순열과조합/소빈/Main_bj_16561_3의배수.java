package bj;

import java.util.Scanner;

public class Main_bj_16561_3의배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = n/3;
		int ans = 0;
		for(int i = 1; i < num; i++) {
			for(int j = 1; j < num; j++) {
				if(i+j >= num) continue;
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}