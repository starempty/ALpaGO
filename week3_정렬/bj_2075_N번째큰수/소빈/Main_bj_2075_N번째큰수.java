package alpagoStudy;

import java.io.*;
import java.util.*;

public class Main_bj_2075_N번째큰수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j= 0; j < n; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i = 0; i < n-1; i++) {
			pq.poll();
		}
//		Arrays.sort(arr, Collections.reverseOrder());
//		Collections.reverseOrder()쓰고 싶으면 Integer배열일것!!!!!!!!!!!
		System.out.println(pq.poll());
	}
}
