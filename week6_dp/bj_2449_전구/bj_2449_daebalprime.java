package bj_2449;

import java.io.BufferedReader;

/**
 * Main
 */
import java.io.*;
import java.util.*;
public class Main {
    static int[] bulbs;
    static int[][] dp;
    static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bulbs = new int[N];
        dp = new int[N][N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            bulbs[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], INF);
        }

        for(int e = 0; e < N; e++){
            for(int s = 0; s < N-e; s++){
                if(e == 0){
                    dp[s][s+e] = 0;
                // }else if(e==0){
                    // dp[s][s+e] = 0;
                }
                else{
                    for(int m = s+1; m <= s+e; m++){
                        int x = bulbs[s] == bulbs[m] ? 0 : 1;
                        dp[s][s+e] = Math.min(dp[s][s+e], dp[s][m-1] + dp[m][s+e]+x);
                    }
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
}