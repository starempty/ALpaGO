import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			hm.clear();
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String category = st.nextToken();
				if(!hm.containsKey(category)) {
					hm.put(category, 0);
				}
				hm.replace(category, hm.get(category)+1);
			}
			int ctgrys = hm.keySet().size();
			Object[] count = hm.values().toArray();
			int bit = (int) Math.pow(2, ctgrys)-1;
			long cal = 1;
			for(int j = 0; j < ctgrys; j++) {
				cal *= (Integer)count[j] + 1;
			}
			
		
			sb.append((cal-1)+"\n");
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
	}
}
