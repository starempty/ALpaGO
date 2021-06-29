package bj_silver;

import java.io.*;
import java.util.*;

public class Main_bj_1427_소트인사이드 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int n = num.length();
		Integer [] arr = new Integer[n];
		for(int i = 0; i < n; i++) {
			arr[i] = num.charAt(i)-'0';
		}
		Arrays.sort(arr, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int a: arr) {
			sb.append(a);
		}
		System.out.println(sb);
	}
}
