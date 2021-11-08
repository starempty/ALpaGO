package baekjoon_20001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//[실버 1] 상어 초등학교
//https://www.acmicpc.net/problem/21608
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_21608_상어초등학교_최민수 {

	static int N;
	static int[][] map;//교실
	static int[][] bestCouple; //각 학생 별 최고의 짝궁
	static int[][] bestCoupleSortNum; //각 학생 별 최고의 짝궁
	static boolean[] placement; //이 학생이 배치되었나
	static int maxCouple; //placement에 따라 이 학생이 현재 최대로 배스트 짝궁을 만날 수 있는가
	static int answer;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_21608"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		bestCouple = new int[N * N + 1][5]; //[x][0]: x번째 순서의 학생 번호 [1~4]: x번째 순서 학생의 베스트 커플
		bestCoupleSortNum = new int[N * N + 1][5];  // [x][0]: x 번호인 학생의 번호, [1~4] x 번호인 학생의 베스트 커플
		placement = new boolean[N*N+1];

		for (int i = 1; i <= N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int student = Integer.parseInt(st.nextToken());
			bestCouple[i][0] = student;
			bestCoupleSortNum[student][0] = student;
			for (int j = 1; j <= 4; j++) {
				bestCouple[i][j] = Integer.parseInt(st.nextToken());
				bestCoupleSortNum[student][j] = bestCouple[i][j];
			}
		}

		// 순서에 따른 1번쨰 학생부터 배치
		for (int i = 1; i <= N*N; i++) {
			int studentNum = bestCouple[i][0];
			maxCouple = 0;
			for (int j = 1; j <= 4; j++) {
				// 이미 최고의 짝궁이 배치되어 있으면 최대 가능 수 ++
				if (placement[bestCouple[i][j]]) {
					maxCouple++;
				}
			}

			// 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
			// 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
			// 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
			findPlace(studentNum, i);
		}
		
		//값 계산
		answer = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				calcHappy(i, j);
			}
			
		}

		bw.write(answer + "");

		bw.flush();
		bw.close();
		br.close();
	}

	private static void calcHappy(int i, int j) {
		int countCouple = 0;
		// 4방향 탐색
		for (int dir = 0; dir < 4; dir++) {
			int nx = i + dx[dir];
			int ny = j + dy[dir];

			if (nx <= 0 || nx > N || ny <= 0 || ny > N) {
				continue;
			}
			// System.out.println("내 번호"+map[i][j]);
			// System.out.println("내 옆자리 학생 번호"+map[nx][ny]);
			for (int k = 1; k <= 4; k++) {
				// System.out.println("나의 선호 학생 "+bestCoupleSortNum[map[i][j]][k]);
				if (map[nx][ny] == bestCoupleSortNum[map[i][j]][k]) {
					countCouple++;
				}
			}
		}
		
		switch (countCouple) {
			case 1:
				answer += 1;
				break;
			case 2:
				answer += 10;
				break;
			case 3:
				answer += 100;
				break;
			case 4:
				answer += 1000;
				break;
		}
	}

	private static void findPlace(int studentNum, int num) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();

		// 모든 원소 방문
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 0) {
					addElement(i, j, pq, studentNum, num);
					
				}

			}
		}

		Point thisPoint = pq.poll();
		// System.out.println(num+" "+thisPoint.toString() + " "+studentNum);
		map[thisPoint.x][thisPoint.y] = studentNum;

	}

	public static void addElement(int i, int j, PriorityQueue<Point> pq, int studentNum, int num) {
		int friend = 0;
		int blank = 0;
		
		// 4방향 탐색
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx <= 0 || nx > N || ny <= 0 || ny > N) {
				continue;
			}

			if (map[nx][ny] == 0) {
				blank++;
			} else {
				for (int l = 1; l <= 4; l++) {
					// 인접한 곳 map[nx] ny
					if (bestCouple[num][l] == map[nx][ny]) {
						friend++;
					}
				}
			}
		}

		pq.add(new Point(i, j, friend, blank));
	}

	public static class Point implements Comparable<Point> {
		int x, y;
		int nearCouple; //인접한 좋아하는 학생 수
		int blankSpace; //인접한 비어있는 칸 수

		public Point(int x, int y, int nearCouple, int blankSpace) {
			this.x = x;
			this.y = y;
			this.nearCouple = nearCouple;
			this.blankSpace = blankSpace;
		}

		@Override
		public int compareTo(Point o) {
			int priority1 = Integer.compare(o.nearCouple, this.nearCouple);
			if (priority1 == 0) {
				int priority2 = Integer.compare(o.blankSpace, this.blankSpace);
				if (priority2 == 0) {
					int priority3 = -Integer.compare(o.x, this.x);
					if (priority3 == 0) {
						return -Integer.compare(o.y, this.y);
					} else {
						return priority3;
					}
				} else {
					return priority2;
				}
			} else {
				return priority1;
			}
		}

		@Override
		public String toString() {
			return "Point [blankSpace=" + blankSpace + ", nearCouple=" + nearCouple + ", x=" + x + ", y=" + y + "]";
		}

		
	}
}
