/*
문제이름
https://www.acmicpc.net/problem/123
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	
    	Set<String> set = new HashSet<String>();
    	for(int i = 0; i < n; i++) {
    		set.add(br.readLine());
    	}
    	
    	List<String> word = new ArrayList<>(set);
    	
    	Collections.sort(word, (o1, o2)->{
    		int comp = Integer.compare(o1.length(), o2.length());
    		if(comp == 0) {
    			return o1.compareTo(o2);
    		}
    		return comp;
    	});
    	
    	for(int i = 0; i < word.size(); i++)
    		System.out.println(word.get(i));
    	
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}