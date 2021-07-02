import java.io.*;
import java.util.*;

public class Main_bj_10800_컬러볼 {
	static class Set implements Comparable<Set>{
		int c, s, idx;
		public Set(int c, int s, int idx) {
			this.c = c;
			this.s = s;
			this.idx = idx;
		}
		@Override
		public int compareTo(Set o) {
			return this.s-o.s;
		}
		@Override
		public String toString() {
			return "Set [c=" + c + ", s=" + s + ", idx=" + idx + "]";
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		Set[] sets = new Set[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sets[i] = new Set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
		}
		
		Arrays.sort(sets);
		int[] ans = new int[n];
		int[] size = new int[n+1];
		int total = 0;
		int j = 0;
		for(int i = 0; i < n; i++) {
			while(sets[i].s > sets[j].s) {
				total+= sets[j].s;
				size[sets[j].c] += sets[j].s;
				j++;
			}
			ans[sets[i].idx] = total- size[sets[i].c];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int a: ans) sb.append(a+"\n");
		System.out.println(sb);
	}
}
