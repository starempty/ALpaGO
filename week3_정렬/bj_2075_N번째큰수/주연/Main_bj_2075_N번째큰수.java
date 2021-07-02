import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());

    	PriorityQueue<Integer> pq = new PriorityQueue<>();


    	int num;
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
			// 첫번째 줄일 때, N개만큼 값을 받는다.
    		if(i == 0) {
    			for(int j = 0; j < n; j++)
    				pq.add(stoi(stk.nextToken()));
    		}
			// 이후 하나씩 확인하여 pq의 최소 값보다 크면, 가장 작은 것 하나를 버리며 추가
    		else {
    			for(int j = 0; j < n; j++) {
	    			num = stoi(stk.nextToken());
	    			if(pq.peek() < num) {
	    				pq.poll();
	    				pq.add(num);
	    			}
    			}
    		}
    	}

    	System.out.println(pq.peek());
    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}