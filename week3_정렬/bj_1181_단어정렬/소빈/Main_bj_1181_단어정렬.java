package alpagoStudy;

import java.io.*;
import java.util.*;

public class Main_bj_1181_단어정렬 {
	static class Set implements Comparable<Set>{
		int len;
		String word;
		public Set(int len, String word) {
			this.len = len;
			this.word = word;
		}
		@Override
		public int compareTo(Set o) {
			int cmp = this.len - o.len;
			return cmp == 0? this.word.compareTo(o.word):cmp;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Set[] sets = new Set[n];
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			sets[i] = new Set(tmp.length(), tmp);
		}
		
		Arrays.sort(sets);
		
		StringBuilder sb = new StringBuilder();
		String prev = "";
		for(Set tmp: sets) {
			if(! prev.equals(tmp.word)) sb.append(tmp.word+"\n");
			prev = tmp.word;
		}
		System.out.println(sb);
	}
}	
