/*
문제이름
https://www.acmicpc.net/problem/123
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, k, result = 9999999, count;
	static boolean[] vis;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	n = stoi(stk.nextToken());
    	k = stoi(stk.nextToken());
    	
    	vis = new boolean[100001];
    	
    	BFS();
    	if(n == k) {
    		result = 0;
    		count = 1;
    	}
    	System.out.println(result);
    	System.out.println(count);
    	
    	br.close();
	}
	
	static void BFS() {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {n, 0});
		int[] q;
		int curN, time;
		vis[n] = true;
		while(!queue.isEmpty()) {
			q = queue.poll();
			curN = q[0];
			time = q[1];
			
			// 방문 처리를 나중에 해준다.
			vis[curN] = true;
			
			//결과에 도달
			if(curN == k) {
				// 더 짧은 결과가 존재 할 시
				if(time < result) {
					count = 1;
					result = time;
				}
				// 똑같은 시간대에 도달 했을 때
				else if(time == result){
					count++;
				}
			}
			
			// 앞으로 한 칸 이동
			if(curN + 1 <= 100000 && !vis[curN + 1]) 
				queue.add(new int[] {curN + 1, time + 1});
			// 뒤로 이동
			if(curN - 1 >= 0 && !vis[curN - 1])
				queue.add(new int[] {curN - 1, time + 1});
			// * 2
			if(curN * 2 <= 100000 && !vis[curN * 2])
				queue.add(new int[] {curN * 2, time + 1});
		}
	} 
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}