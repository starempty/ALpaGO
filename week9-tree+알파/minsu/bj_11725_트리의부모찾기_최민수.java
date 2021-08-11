package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//[실버 2] 트리의 부모 찾기
//https://www.acmicpc.net/problem/11725
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_11725_트리의부모찾기_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_11725"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		// 각 노드의 부모를 저장할 배열
		int[] parent = new int[N + 1];
		// 트리 구조를 저장할 것
		List<Integer>[] list = new ArrayList[N + 1];

		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		ArrayDeque<Integer> q = new ArrayDeque();
		q.add(1);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < list[now].size(); i++) {
				int connect = list[now].get(i);
				if (parent[connect] == 0) {
					q.add(connect);
					parent[connect] = now;
				}
			}
		}

		for (int i = 2; i < parent.length; i++) {
			bw.write(parent[i] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
