import java.util.*;
public class Main {
	static int[] arr;
	static int sum;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		sum = 0;
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		sc.close();
		Arrays.sort(arr);
		flag = false;
		comb(0, 0, new boolean[9]);
	}
	private static void comb(int cnt, int num, boolean[] visit) {
		if(flag) return;
		if(cnt == 2) {
			if(sum - num == 100) {
				for(int i = 0; i < 9; i++) {
					if(!visit[i]) System.out.println(arr[i]);
				}
				flag = true;
			}
			return;
		}
		for(int i = 0; i < 9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				comb(cnt+1, num+arr[i], visit);
				visit[i] = false;
			}
		}
	}
}
