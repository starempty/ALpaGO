/*
문제이름
https://www.acmicpc.net/problem/1541
*/

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		String str = br.readLine();
    	StringTokenizer stk = new StringTokenizer(str , "-|+");
    	List<Integer> list = new ArrayList<>();
    	while(stk.hasMoreTokens()) {
    		list.add(stoi(stk.nextToken()));
    	}
    	char[] arr = str.toCharArray();
    	int len = arr.length, idx = 1;
    	// 최소 값을 만들기 위해, -가 처음 나오는 기점을 찾는다.
    	for(int i = 0; i < len; i++) {
    		if(arr[i] == '+') {
    			idx++;
    		}
    		else if(arr[i] == '-'){
    			break;
    		}
    	}
    	
    	int plusSum = 0, minusSum = 0;
    	for(int i = 0; i < idx; i++) {
    		plusSum += list.get(i);
    	}
    	int size = list.size();
    	for(int i = idx; i < size; i++) {
    		minusSum += list.get(i);
    	}
    	
    	System.out.println(plusSum - minusSum);
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}