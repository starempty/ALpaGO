package bj_silver;

import java.io.*;
import java.util.*;

public class Main_bj_9375_패션왕신혜빈 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			for(int i = 0; i < n; i++){
				String[] in = br.readLine().split(" ");
				if(map.containsKey(in[1])) {
					int val = map.get(in[1]);
					map.put(in[1], val+1);
				}else {
					map.put(in[1], 2);
				}
			}
			int ans = 1;
			for(String key: map.keySet()) {
				ans *= map.get(key);
			}
			sb.append(ans-1+"\n");
		}
		System.out.println(sb);
	}
}
