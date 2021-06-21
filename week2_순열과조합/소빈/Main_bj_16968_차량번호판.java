package bj;

import java.util.Scanner;

public class Main_bj_16968_차량번호판 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		
		int flag = 1, ans = 1;
		char prev = 0;
		for(int i = 0; i < in.length(); i++) {
			char cur = in.charAt(i);
			if(cur == prev) flag = 1;
			else flag = 0;
			
			if(cur == 'c') 		ans *= 26-flag;
			else if(cur == 'd') ans *= 10-flag;
			prev = cur;
		}
		
		System.out.println(ans);
		sc.close();
	}
}
