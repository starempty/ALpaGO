import java.util.*;
import java.io.*;
/**
 * Main
 */
public class Main {
    static int[][] price;
    static int N;
    static int[][] last = {{0,1,2},{},{},{},{},{}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int [N][3];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken().trim());
            price[i][1] = Integer.parseInt(st.nextToken().trim());
            price[i][2] = Integer.parseInt(st.nextToken().trim());
        }
        int answer = Integer.MAX_VALUE;
        for(int k = 0; k < 3; k++){
            int[][] dp = new int[N][3];
            for(int i = 0; i < 3; i++){
                if(i==k){
                    dp[0][i] = price[0][i];
                }else{
                    dp[0][i] = Integer.MAX_VALUE/2;
                }
            }
            for(int i = 1; i < N; i++) {
                dp[i][0] = price[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);			
                dp[i][1] = price[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);			
                dp[i][2] = price[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
                //색을 먼저 정하고 이전 집의 최솟값 가져오기
            }
            for(int i = 0; i < 3; i++) {
                if(i==k) continue;
                answer = Math.min(dp[N-1][i], answer);
            }
        }
		System.out.println(answer);
		br.close();
        
        
        
    }

}