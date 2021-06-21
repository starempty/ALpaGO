import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] colors = new int[N];
		int total = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			total += colors[i] = Integer.parseInt(st.nextToken());
		}
		int K = Integer.parseInt(br.readLine());
		double answer = 0.0;
		for(int color : colors) {
			if(color < K) continue;
			double local = 1;
			for(int i = 0; i < K; i++) {
				local *= color-i;
				local /= (total - i);
			}
			answer += local;
		}
		System.out.println(answer);
		br.close();
	}

}
