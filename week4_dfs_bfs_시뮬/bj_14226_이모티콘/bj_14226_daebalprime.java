import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int[] dp = new int[4000];
		Arrays.fill(dp, 1000000000);
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1,0,0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int emojis = curr[0];
			int clip = curr[1];
			int depth = curr[2];
			dp[emojis] = Math.min(dp[emojis], depth);
			if(emojis == N) {
				System.out.println(depth);
				break;
			}
			if(clip != 0 && clip + emojis < 4000 && dp[clip + emojis] > depth+1) {
				q.offer(new int[] {clip+emojis, clip, depth+1});
			}
			if(emojis > 0 && dp[emojis-1] > depth+1) {
				q.offer(new int[] {emojis-1, clip, depth+1});
			}
			q.offer(new int[] {emojis, emojis, depth+1});
		}
	}
}