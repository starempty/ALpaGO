package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//[실버 5] 피카츄
//https://www.acmicpc.net/problem/14405
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_14405_피카츄_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_14405"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] pikachu = br.readLine().toCharArray();
		int start = 0;
		boolean isPi = false;

		while (start <= pikachu.length) {
			if (start == pikachu.length) {
				isPi = true;
				break;
			}
			if (pikachu[start] == 'p') {
				if (start + 1 == pikachu.length) {
					break;
				}
				if (pikachu[start + 1] == 'i') {
					start += 2;
				} else {
					break;
				}
			} else if (pikachu[start] == 'k') {
				if (start + 1 == pikachu.length) {
					break;
				}
				if (pikachu[start + 1] == 'a') {
					start += 2;
				} else {
					break;
				}
			} else if (pikachu[start] == 'c') {
				if (start + 1 == pikachu.length) {
					break;
				}
				if (pikachu[start + 1] == 'h') {
					if (start + 2 == pikachu.length) {
						break;
					}
					if (pikachu[start + 2] == 'u') {
						start += 3;
					} else {
						break;
					}
				} else {
					break;
				}
			} else {
				break;
			}
		}

		if (isPi)
			bw.write("YES");
		else
			bw.write("NO");

		bw.flush();
		bw.close();
		br.close();
	}
}
