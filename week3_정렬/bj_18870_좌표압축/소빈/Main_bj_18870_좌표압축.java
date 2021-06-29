package alpagoStudy;

import java.io.*;
import java.util.*;
public class Main_bj_18870_좌표압축 {
	static class Set implements Comparable<Set>{
		int num, idx;
		public Set(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
		@Override
		public int compareTo(Set o) {
			return this.num-o.num;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set[] arr = new Set[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = new Set(Integer.parseInt(st.nextToken()), i);
		}
		
		Arrays.sort(arr);
		int[] answer = new int[n];
		
		int prev = arr[0].num;
		int idx = 0;
		
		answer[arr[0].idx] = idx;
		for(int i = 1; i < n; i++) {
			if(arr[i].num == prev) answer[arr[i].idx] = idx;
			else answer[arr[i].idx] = ++idx;
			
			prev = arr[i].num;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int a: answer) {
			sb.append(a+" ");
		}
		System.out.println(sb);
			
	}
}
