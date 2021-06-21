import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < 1; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Integer[] arr = new Integer[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int i = arr.length-1;
			while(i>0 && arr[i-1] < arr[i]) --i;
			if(i == 0) {
				System.out.println(-1);
				return;
			}
			int  j = arr.length-1;
			while(arr[i-1] < arr[j]) --j;
			
			// swap
			int tmp = arr[i-1];
			arr[i-1] = arr[j];
			arr[j] = tmp;
			Comparator<Integer> cmp = new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			};
			Arrays.sort(arr, i, arr.length, cmp);
			
//			int k = str.length()-1;
//			while(i < k) {
//				char tmp2 = arr[i];
//				arr[i] = arr[k];
//				arr[k] = tmp2;
//				++i; --k;
//			}
			for(int num : arr) {
				sb.append(num+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}