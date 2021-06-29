package bj_silver;

import java.io.*;
import java.util.*;

public class Main_bj_2108_통계학 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		double sum = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);

		Map<Integer, Integer> map = new HashMap<>();
		int max = -1;
		for(int a: arr) {
			if(map.containsKey(a)) {
				int cur = map.get(a);
				map.put(a, cur+1);
				max = Integer.max(max, cur+1);
			}
			else {
				map.put(a, 1);
			}
		}
		
//		System.out.println(max);
//		System.out.println(map);
		System.out.println(Math.round(sum/n));
		System.out.println(arr[n/2]);
		if(max == -1) {
			if(n == 1) System.out.println(arr[0]);
			else System.out.println(arr[1]);
		}
		else {
			List<Integer> li = new ArrayList<>();
			for(int key: map.keySet()) {
				if(map.get(key) == max) {
					li.add(key);
				}
			}
			Collections.sort(li);
			if(li.size() == 1) System.out.println(li.get(0));
			else System.out.println(li.get(1)); //두번째로 작은값에서 걸렸다.
		}
		System.out.println(arr[n-1]-arr[0]);
	}
}
