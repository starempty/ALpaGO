package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//[브론즈2] 일곱 난쟁이
//https://www.acmicpc.net/problem/2309
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2309_일곱난쟁이_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2309"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 조합으로 두개씩 빼면서 계산
		int[] dwarf = new int[9];
		int sum = 0;
		for (int i = 0; i < dwarf.length; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}

		loop: for (int i = 0; i < dwarf.length; i++) {
			for (int j = i + 1; j < dwarf.length; j++) {
				if (sum - dwarf[i] - dwarf[j] == 100) {
					dwarf[i] = 0;
					dwarf[j] = 0;
					break loop;
				}

			}
		}

		Arrays.sort(dwarf);
		for (int i = 2; i < dwarf.length; i++) {
			bw.write(dwarf[i] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
