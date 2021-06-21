package bj_gold;

import java.io.*;

public class Main_bj_9081_단어맞추기 {
	static String str;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			str = br.readLine();
			nextPerm();
			sb.append(str);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static boolean nextPerm() {
		int i = str.length()-1;
		while(i > 0 && str.charAt(i-1) >= str.charAt(i)) --i;
		
		if(i == 0) return false;
		
		int j = str.length()-1;
		while(str.charAt(i-1) >= str.charAt(j)) --j;
		
		swap(i-1, j);
		
		int k = str.length()-1;
		while(i < k) {
			swap(i++, k--);
		}
		return true;
	}
	private static void swap(int i, int j) {
		char tmpi = str.charAt(i);
		char tmpj = str.charAt(j);
		String tmp = "";
		for(int idx = 0; idx < str.length(); idx++) {
			if(idx == i) tmp += tmpj;
			else if(idx == j) tmp += tmpi;
			else tmp += str.charAt(idx);
		}
		str = tmp;
	}
}
