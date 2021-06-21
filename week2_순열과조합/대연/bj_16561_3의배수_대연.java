import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N <= 6) {
			System.out.println(0);
			return;
		}
		int answer = 0;
		N /= 3;
		for(int i = 1; i <= N-2; i++) {
			answer += N-1-i;
		}
		System.out.println(answer);
	}
}