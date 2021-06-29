package bj_silver;

import java.io.*;
import java.util.*;

public class Main_bj_11650_좌표정렬하기 {
	static class Set implements Comparable<Set>{
		int x, y;
		public Set(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Set o) {
			int cmp = this.y - o.y;
			return cmp==0?this.x-o.x:cmp;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		Set[] sets = new Set[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sets[i] = new Set(a, b);
		}
		Arrays.sort(sets);
		
		StringBuilder sb = new StringBuilder();
		for(Set tmp: sets) {
			sb.append(tmp.x+" "+tmp.y+"\n");
		}
		System.out.println(sb);
	}
}
