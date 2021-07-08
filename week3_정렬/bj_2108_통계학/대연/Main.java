import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int avg = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int freq = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(Integer.compare(o1, o2)));
		HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<Integer> ar = new ArrayList<>(N);
		int[] csort = new int[8002];
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			avg += tmp;
			ar.add(tmp);
			min = Math.min(tmp, min);
			max = Math.max(tmp, max);
			csort[tmp+4000]++;
			int c = hm.getOrDefault(tmp, 0);
			if(c == 0) {
				hm.put(tmp, 1);
				c = 1;
			}
			else {
				hm.replace(tmp, ++c);
			}
			if(c > freq) {
				pq.clear();
				pq.offer(tmp);
				freq = c;
			}
			else if(c == freq) {
				pq.offer(tmp);
			}
		}
		Collections.sort(ar);
		StringBuilder sb = new StringBuilder();
		avg = ((int)Math.round((double)avg/N));
		int frequently = pq.poll();
		if(pq.size() >= 1) {
			frequently = pq.poll();
		}
		int range = max - min;
		int median = ar.get(N/2);
		sb.append(avg + "\n")
		.append(median + "\n")
		.append(frequently+"\n")
		.append(range + "\n");
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}