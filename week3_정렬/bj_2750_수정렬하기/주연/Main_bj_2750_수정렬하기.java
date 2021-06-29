import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	List<Integer> arr = new ArrayList<Integer>();
    	
    	for(int i = 0; i < n; i++) {
    		arr.add(stoi(br.readLine()));
    	}
    	
    	Collections.sort(arr);
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < n; i++) {
    		sb.append(arr.get(i));
    		sb.append("\n");
    	}
    	System.out.println(sb.toString());
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}