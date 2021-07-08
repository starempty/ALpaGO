package bj_1427;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int[] arr = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i)-'0';
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length-1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
