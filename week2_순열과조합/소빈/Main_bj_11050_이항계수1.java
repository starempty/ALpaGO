package bj;

import java.util.*;

public class Main_bj_11050_이항계수1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if (n == k) {
			System.out.println(1);
			return;
		}
		int ans = fact(n, k + 1) / fact((n - k), 1);
		System.out.println(ans);
		sc.close();
	}

	private static int fact(int num, int target) {
		if (num == target)
			return target;
		return num * fact(num - 1, target);
	}
}
