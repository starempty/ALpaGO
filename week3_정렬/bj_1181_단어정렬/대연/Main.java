package bj_1181;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		List<String> strs = new ArrayList<String>(N);
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(!set.contains(str)) {
				strs.add(str);
				set.add(str);
			}
		}
		Collections.sort(strs, (s1,s2)->s1.length()==s2.length()? s1.compareTo(s2) : Integer.compare(s1.length(), s2.length()));
		StringBuilder sb = new StringBuilder();
		for(String s : strs) {
			sb.append(s+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
