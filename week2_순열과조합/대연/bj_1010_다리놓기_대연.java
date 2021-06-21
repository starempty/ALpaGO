import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			if(M==0 || M==N) {
				System.out.println("1");
				continue;
			}
			int answer = 1;
			for(int i = 0; i < M; i++) {
				answer *= (N-i);
				answer /= (1+i);
			}
			System.out.println(answer);
		}
		br.close();
	}
}
