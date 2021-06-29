package bj_silver;

import java.io.*;
import java.util.*;
public class Main_bj_2751_수정렬하기2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int a: arr) {
			sb.append(a);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
