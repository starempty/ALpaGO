import java.util.*;
import java.io.*;

public class Main {
	static int total, result;
	static int[] man, sel;
	static boolean[] vis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		man = new int[9];
		sel = new int[2];
		vis = new boolean[9];
		for(int i = 0; i < 9; i++) {
			man[i] = stoi(br.readLine());
			total += man[i];
		}
		Arrays.sort(man);
		DFS(0, 0);
    	br.close();
	}
	
	private static boolean DFS(int lv, int idx) {
		if(lv == 2) {
			if(total - sel[0] - sel[1] == 100) {
				for(int i = 0; i < 9; i++) {
					if(!vis[i])
						System.out.println(man[i]);
				}
				return true;
			}
			return false;
		}
		for(int i = idx; i < 9; i++) {
			if(!vis[i]) {
				vis[i] = true;
				sel[lv] = man[i];
				if(DFS(lv + 1, i + 1))
					return true;
				vis[i] = false;
			}
		}
		return false;
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}