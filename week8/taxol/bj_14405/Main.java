/*
문제이름
https://www.acmicpc.net/problem/123
pi, ka, chu의 [p,k,c]가 나올 때 마다 조건문으로 확인한다.
1. p,k,c의 다음에 나올 문자의 길이 [1,1,2]보다 짧으면 종료
2. p,k,c의 다음에 나올 문자들 [i,a,hu]가 아니면 종료
*/

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int len = str.length();
		boolean result = true; 
		
		char[] pika = str.toCharArray();
		end: for(int i = 0; i < len; i++) {
			switch(pika[i]) {
			case 'p':
				if(i + 1 >= len || pika[i + 1] != 'i') {
					result = false;
					break end;
				}
				i += 1;
				break;
			case 'k':
				if(i + 1 >= len || pika[i + 1] != 'a') {
					result = false;
					break end;
				}
				i += 1;
				break;
			case 'c':
				if(i + 2 >= len || pika[i + 1] != 'h' || pika[i + 2] != 'u') {
					result = false;
					break end;
				}
				i += 2;
				break;
			default:
				result = false;
				break end;
			}
			
		}
		if(result)
			System.out.println("YES");
		else
			System.out.println("NO");
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}