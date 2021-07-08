package bj_2075;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] matrix = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k = 0; k < N; k++) {
				matrix[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[0], o2[0]));
		for(int i = 0; i < N; i++) {
			pq.offer(new int[] {matrix[0][i], 0,i});
		}
		int order = 0;
		while(++order != N*N-N+1) {
			int[] curr = pq.poll();
			int row = curr[1]+1;
			int col = curr[2];
			if(row >= N) continue;
			pq.offer(new int[] {matrix[row][col], row, col});
		}
		System.out.println(pq.poll()[0]);
		br.close();
	}

}
