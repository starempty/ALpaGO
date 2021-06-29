/*
좌표 정렬하기
https://www.acmicpc.net/problem/11650
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	
    	ArrayList<int[]> arr = new ArrayList<>();
    	
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		arr.add(new int[] {stoi(stk.nextToken()), stoi(stk.nextToken())});
    	}
    	
    	Collections.sort(arr, (o1,o2)->{
    		// y축을 기준으로 정렬
    		int comp = Integer.compare(o1[1], o2[1]);
    		// y값이 같으면, x축을 기준으로 정렬
    		if(comp == 0)
    			return Integer.compare(o1[0], o2[0]);
    		return comp;
    	});
    	
    	StringBuilder sb = new StringBuilder();
    	for(int[] op : arr)
    		sb.append(op[0] + " " + op[1] + "\n");
    	
    	System.out.println(sb.toString());
    	
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}