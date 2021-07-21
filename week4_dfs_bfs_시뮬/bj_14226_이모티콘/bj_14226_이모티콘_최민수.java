package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//[골드 5] 이모티콘
//https://www.acmicpc.net/problem/14226
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_14226_이모티콘_최민수 {
	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_14226"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// BFS로 3가지 경우를 무한 반복한다.
		int s = Integer.parseInt(br.readLine());

		Queue<Emo> q = new LinkedList<>();
		int dp[] = new int[2001];
		dp[1] = 0;

		q.offer(new Emo(1, 0, 0));

		while (true) {
			Emo temp = q.poll();
			if (temp.emotes == s) {
				bw.write(String.valueOf(temp.time));
				break;
			}

			if (temp.emotes > 2000 || temp.emotes <= 0)
				continue;
			// 값이 갱신된적이 없고,
			if (dp[temp.emotes] == 0) {
				dp[temp.emotes] = temp.time;
			}
			// 해당 값에 도달하는데 이미 기록된 시간보다 지금이 길면
			// copy 상태도 다르다. copy를 고려해서 +1까지 허용
			else if (dp[temp.emotes] + 1 < temp.time) {
				continue;
			}

			// 클립보드에 복사
			q.offer(new Emo(temp.emotes, temp.emotes, temp.time + 1));

			// 클립보드 붙여넣기
			q.offer(new Emo(temp.emotes + temp.clip, temp.clip, temp.time + 1));
			// 화면 한개 삭제
			q.offer(new Emo(temp.emotes - 1, temp.clip, temp.time + 1));
		}
		// System.out.println(Arrays.toString(dp));

		bw.flush();
		bw.close();
		br.close();
	}

	static public class Emo {
		int emotes;
		int clip;
		int time;

		public Emo(int emotes, int clip, int time) {
			this.emotes = emotes;
			this.clip = clip;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Emo [clip=" + clip + ", emotes=" + emotes + ", time=" + time + "]";
		}

	}
}

// 그냥 BFS돌리니까 터진다. dp요소를 추가하자.