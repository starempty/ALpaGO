package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//[실버 5] 좌표 정렬하기
//https://www.acmicpc.net/problem/11650
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_11650_좌표정렬하기_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_11650"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// class를 만들고 comparator를 활용하자
		PriorityQueue<Point> pq = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new Point(a, b));
		}

		while (pq.size() > 0) {
			Point point = pq.poll();
			bw.write(String.valueOf(point.x) + " " + String.valueOf(point.y) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			int com = Integer.compare(this.x, o.x);
			if (com == 0)
				return Integer.compare(this.y, o.y);
			else
				return com;
		}
	}
}
