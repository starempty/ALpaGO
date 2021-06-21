package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[실버3] 패션왕 신해빈
//https://www.acmicpc.net/problem/9375
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_9375_패션왕신해빈_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_9375"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//각각의 파츠별+1 * 다 한다음에 다 벗은 경우인 1을 빼준다.
		int tc = Integer.parseInt(br.readLine());
		for (int T = 0; T < tc; T++) {
			
			//옷 종류 저장할 배열
			String clothes[] = new String[30];
			//옷 종류 개수
			int type = 0;
			//옷 종류별 옷 수
			int num[] = new int[30];
			
			//의상 입력
			int cloth = Integer.parseInt(br.readLine());
			for (int i = 0; i < cloth; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken(); //옷 이름 필요없음
				String clothType = st.nextToken();
				
				//이미 있는 옷 타입인지 확인
				boolean alreadyRegist = false;
				for (int j = 0; j < type; j++) {
					if(clothes[j].equals(clothType)) {
						num[j]++;
						alreadyRegist = true;
						break;
					}
				}
				//등록된 적이 없다.
				if(!alreadyRegist) {
					num[type]++; //이 종류 새옷 등록
					clothes[type] = clothType;
					type++; //종류 1개 추가됨
				}
			}
			
//			System.out.println(Arrays.toString(clothes));
			int answer = 1;
			for (int i = 0; i < type; i++) {
				answer *= num[i]+1;
			}
			System.out.println(answer-1);
			
		}
	
		br.close();
	}
}
