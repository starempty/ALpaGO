/*
통계학
https://www.acmicpc.net/problem/2108
*/

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	static int n, result;
	static long sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = stoi(br.readLine());
    	int[] arr = new int[n];
    	int[] cnt = new int[8001];
    	
    	for(int i = 0; i < n; i++) {
    		arr[i] = stoi(br.readLine());
    		sum += arr[i];
    		cnt[arr[i] + 4000]++;
    	}
    	Arrays.sort(arr);
    	// 산술 평균
    	double cal = Math.round((double)sum / (double)n);
    	System.out.printf("%.0f\n", cal);
    	
    	// 중앙 값
    	System.out.println(arr[n / 2]);
    	// 최빈 값
    	int first = arr[0], second = arr[0];
    	boolean isSec = false;	// 동일한 빈도수의 값이 여러개 있을 때 두번째로 작은 값 출력
    	int maxCnt = 0;
    	for(int i = 0; i <= 8000; i++) {
    		if(cnt[i] > maxCnt) {
    			first = i - 4000;
    			isSec = false;
    			maxCnt = cnt[i];
    		}
    		else if(cnt[i] == maxCnt && !isSec) {
    			isSec = true;
    			second = i - 4000;
    		}
    	}
    	
    	// 가장 빈도수가 큰 값이 하나만 있을 때
    	if(!isSec) {
    		System.out.println(first);
    	}
    	else {
    		System.out.println(second);
    	}
    	// 범위
    	System.out.println(arr[n - 1] - arr[0]);
    	
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}