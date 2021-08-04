/*
문제이름
https://www.acmicpc.net/problem/123

1. 만약 문자열의 길이보다 알파벳의 종류가 더 많으면?
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = stoi(br.readLine());
    	String str = br.readLine();
    	
    	
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	char[] arrC = str.toCharArray();
    	int len = str.length();
    	
    	int	s = 0, e = 0, num, lastS = 0;
    	while(s <= e && e <= len - 1) {
    		if((s!= e || e == 0) && lastS == s)
    			map.put(arrC[e], map.getOrDefault(arrC[e], 0) + 1);
    		
    		if(map.size() <= n) {
    			result = Math.max(result, e - s + 1);
    			e++;
    			lastS = s;
    		}
    		else {
    			num = map.get(arrC[s]) - 1;
    			if(num == 0) {
    				map.remove(arrC[s]);
    			}
    			else {
    				map.replace(arrC[s], num);
    			}
    			s++;
    		}
    	}
    	
    	System.out.println(result);
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}