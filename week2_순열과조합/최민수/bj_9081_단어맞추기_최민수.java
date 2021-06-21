package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//[골드 5] 단어 맞추기
//https://www.acmicpc.net/problem/9081
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_9081_단어맞추기_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_9081"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//테케
		int tc = Integer.parseInt(br.readLine());
		for (int T = 0; T < tc; T++) {
			//하나의 단어 길이 최대 99
			//바로 다음 단어 출력
			//넥퍼 문제
			nextPerm(br.readLine().toCharArray());
			
		}//테케 끝
		
		br.close();
	}

	private static void nextPerm(char word[]) {
		
		//1. 오르막이 꺾이는 지점을 찾는다.
		int i = word.length - 1;
		while(i>0 && (int) word[i-1] >= (int) word[i]) i--;
		if(i==0) {
			print(word);
			return;
		}
		
		//2. 꺾인 다음 지점(i)보다 커지는 시점 찾기
		int j = word.length - 1;
		while((int) word[i-1] >= (int) word[j]) j--;
		
		swap(word, i-1, j);
		
		//스왑
		int k = word.length - 1;
		while(k > i) swap(word, i++, k--);
		
		print(word);
	}

	private static void print(char[] word) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length; i++) {
			sb.append(word[i]);			
		}
		System.out.println(sb.toString());
	}

	private static void swap(char[] word, int i, int j) {
		char temp = word[j];
		word[j] = word[i];
		word[i] = temp;
	}
}
