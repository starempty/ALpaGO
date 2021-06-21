import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String format = br.readLine();
		if(format.length() == 0) {
			System.out.println(0);
			return;
		}
		char prev = ' ';
		int answer = 1;
		int tmp = 1;
		for(int i = 0; i < format.length(); i++) {
			if(prev == format.charAt(i)) {
				if(format.charAt(i) == 'd') {
					tmp *= 9;
				}else {
					tmp *= 25;
				}
			}
			else {
				answer *= tmp;
				if(format.charAt(i) == 'd') {
					tmp = 10;
				}else {
					tmp = 26;
				}
				prev = format.charAt(i);
			}
		}
		answer*= tmp;
		System.out.println(answer);
		br.close();
	}
}