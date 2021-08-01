package bj_1541;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String inp = br.readLine();
		StringTokenizer st = new StringTokenizer(inp, "-+");
//		int N = Integer.parseInt(st.nextToken());\
		int x = 0;
		int[] nums = new int[25];
		while(st.hasMoreTokens()) {
			nums[x++] = Integer.parseInt(st.nextToken());
		}
		boolean[] oper = new boolean[x];
		int j = 0;
		int answer = nums[0];
		for(int i = 0; i < inp.length(); i++) {
			if(inp.charAt(i)=='+') {
				answer += nums[++j];
			}
			else if (inp.charAt(i)=='-') {
				for(int k = j+1; k < x; k++) {
					answer -= nums[k];
				}
				break;
			}
		}
		System.out.println(answer);
		
//		for(int i = 0; i < N; i++) {
//		}
		br.close();
	}
}
