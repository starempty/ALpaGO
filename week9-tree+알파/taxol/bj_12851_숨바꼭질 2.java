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
			
			vis[curN] = true;
			
			if(curN == k) {
				if(time < result) {
					count = 1;
					result = time;
				}
				else if(time == result){
					count++;
				}
			}
			
			
			if(curN + 1 <= 100000 && !vis[curN + 1]) 
				queue.add(new int[] {curN + 1, time + 1});
				
			if(curN - 1 >= 0 && !vis[curN - 1])
				queue.add(new int[] {curN - 1, time + 1});
			
			if(curN * 2 <= 100000 && !vis[curN * 2])
				queue.add(new int[] {curN * 2, time + 1});
		}
	} 
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}