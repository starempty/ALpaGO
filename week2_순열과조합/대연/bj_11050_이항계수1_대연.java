import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if(K==0 || K==N) {
			System.out.println("1");
			return;
		}
		int answer = 1;
		for(int i = 0; i < K; i++) {
			answer *= (N-i);
			answer /= (1+i);
		}
		System.out.println(answer);
	}

}
