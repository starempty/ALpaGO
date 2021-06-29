/*
소트인사이드
https://www.acmicpc.net/problem/1427
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	
    	int len = str.length();
    	List<Integer> nums = new ArrayList<>();;
    	
    	for(int i = 0; i < len; i++)
    		nums.add(str.charAt(i) - '0');
    	
    	Collections.sort(nums, (o1,o2)->{
    		return -Integer.compare(o1,o2); 
    	});
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < len; i++)
    		sb.append(nums.get(i));
    	System.out.println(sb.toString());
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}