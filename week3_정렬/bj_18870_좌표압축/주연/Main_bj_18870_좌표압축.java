/*
좌표 압축 
https://www.acmicpc.net/problem/18870
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = stoi(br.readLine());
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	
    	List<int[]> arr = new ArrayList<int[]>();
    	for(int i = 0; i < n; i++) {
    		arr.add(new int[] {stoi(stk.nextToken()), i});
    	}
    	// 수를 기준으로 정렬, 만약 같으면 순서를 기준으로 정렬
    	Collections.sort(arr, (o1,o2)->{
    		int comp = Integer.compare(o1[0], o2[0]);
    		if(comp == 0) {
    			return Integer.compare(o1[1], o2[1]);
    		}
    		return comp;
    	});
    	
    	// 앞에서 부터 좌표를 압축한다.
    	int idx = -1, curN = -1000000001;
    	for(int i = 0; i < n; i++) {
    		if(curN != arr.get(i)[0]) {
    			idx++;
    			curN = arr.get(i)[0];
    			arr.get(i)[0] = idx;
    		}
    		else {
    			arr.get(i)[0] = idx;
    		}
    	}
    	// 다시 순서대로 정렬
    	Collections.sort(arr, (o1,o2)->{
    		return Integer.compare(o1[1], o2[1]);
    	});
    	
    	StringBuilder sb = new StringBuilder();
    	for(int[] op : arr) {
    		sb.append(op[0] + " ");
    	}
    	
    	System.out.println(sb.toString());
    	
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}