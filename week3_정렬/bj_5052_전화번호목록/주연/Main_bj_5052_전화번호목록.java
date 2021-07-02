import java.util.*;
import java.io.*;

public class Main {
	static int tc, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	tc = stoi(br.readLine());

    	boolean isOk = true;
    	while(tc-- != 0) {
    		int n = stoi(br.readLine());

    		List<String> arrS = new ArrayList<>();
    		for(int i = 0; i < n; i++) {
    			arrS.add(br.readLine());
    		}
			// 길이 순으로 문자열 정렬
    		Collections.sort(arrS, (o1, o2)->{
    			return Integer.compare(o1.length(), o2.length());
    		});

    		isOk = true;
    		Set<String> phone = new HashSet<>();
    		String str;
    		for(int idx = 0; idx < n; idx++) {
    			str = arrS.get(idx);
				// 처음 들어온 문자열(제일 짧은)
    			if(phone.isEmpty()) {
    				phone.add(str);
    				continue;
    			}

    			for(int i = 1; i <= str.length(); i++) {
					// Set에 존재하는 문자열 중에 접두어가 있는지 확인
    				if(phone.contains(str.substring(0, i))) {
    					isOk = false;
    				}
    			}
    			phone.add(str);
    		}
    		if(isOk)
    			System.out.println("YES");
    		else
    			System.out.println("NO");
    	}


    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}