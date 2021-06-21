package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//[브론즈1] 나머지
//https://www.acmicpc.net/problem/16968
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_16968_차량번호판1_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_16968"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		char[] plate = br.readLine().toCharArray();
		
		int answer = 1;
		boolean isCharPrev = true;
		boolean isCharNow = true;
		for (int i = 0; i < plate.length; i++) {
			//문자인지 숫자인지 구분
			if(plate[i] == 'c') isCharNow = true;
			else isCharNow = false;				
			
			//연산
			if(i == 0) {
				if(isCharNow) answer *= 26;
				else answer *= 10;
			}else {
				//cd
				if(isCharPrev && !isCharNow) answer *= 10;
				//dc
				else if(!isCharPrev && isCharNow) answer *= 26;
				//dd
				else if(!isCharPrev && !isCharNow) answer *= 9;
				//cc
				else answer *= 25;
			}
			
			//이전 값 저장
			isCharPrev = isCharNow;
		}
		System.out.println(answer);
		
		br.close();
	}
}
