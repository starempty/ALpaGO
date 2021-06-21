import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < N; tc++) {
			String str = br.readLine();
			char[] arr = new char[str.length()];
			for(int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}
			int i = arr.length-1;
			while(i>0 && arr[i-1] >= arr[i]) --i;
			if(i == 0) {
				sb.append(str+"\n");
				continue;
			}
			int  j = arr.length-1;
			while(arr[i-1]>=arr[j]) --j;
			
			// swap
			char tmp = arr[i-1];
			arr[i-1] = arr[j];
			arr[j] = tmp;
			
			int k = str.length()-1;
			while(i < k) {
				char tmp2 = arr[i];
				arr[i] = arr[k];
				arr[k] = tmp2;
				++i; --k;
			}
			for(char ch : arr) {
				sb.append(ch);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}