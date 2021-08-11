package bj_12851;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {N,0});
		visited[N] = true;
		int answer = Integer.MAX_VALUE;
		int methods = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			visited[curr[0]] = true;
			if(curr[1] > answer) break;
			if(curr[0] == K) {
				answer = curr[1];
				methods++;
			}
			if(curr[0] - 1 >= 0 && !visited[curr[0]-1]) {
				q.offer(new int[] {curr[0]-1, curr[1]+1});
				// visited[curr[0]-1]= true;
			}
			if(curr[0] +1 <= 100000 && !visited[curr[0]+1]) {
				q.offer(new int[] {curr[0]+1, curr[1]+1});
				// visited[curr[0]+1]= true;
			}
			if(curr[0]*2 <= 100000 && !visited[curr[0]*2]) {
				q.offer(new int[] {curr[0]*2, curr[1]+1});
				// visited[curr[0]*2]= true;
			}
		}
		System.out.println(answer);
		System.out.println(methods);
	}

}
