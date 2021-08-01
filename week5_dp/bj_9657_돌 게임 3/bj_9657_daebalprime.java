import java.io.*;
import java.util.*;

/*
 * 상근 1/2/3/4/5/6/7
 *   패 / 승 / 패 / 승 / 승 /  
 * 
 * */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int idx = (int) (N%7);
		if(idx == 0 || idx == 2) {
			System.out.println("CY");
		}
		else {
			System.out.println("SK");
		}
	}
}