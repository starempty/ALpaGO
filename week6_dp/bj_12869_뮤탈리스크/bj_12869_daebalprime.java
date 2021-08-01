package bj_4811;

import java.util.*;
import java.io.*;

public class Main {
    static long[][] dp;
    static long[] answer = {
        0,
        1,
        2,
        5,
        14,
        42,
        132,
        429,
        1430,
        4862,
        16796,
        58786,
        208012,
        742900,
        2674440,
        9694845,
        35357670,
        129644790,
        477638700,
        1767263190,
        6564120420L,
        24466267020L,
        91482563640L,
        343059613650L,
        1289904147324L,
        4861946401452L,
        18367353072152L,
        69533550916004L,
        263747951750360L,
        1002242216651368L,
        3814986502092304L
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // dp = new long[31][31];
        // for(long[] ia : dp){
        //     Arrays.fill(ia,-1);
        // }
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            // sb.append(dp(N,N)).append("\n");
            sb.append(answer[N]).append("\n");
        }


        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();

        
    }
    static long dp(int W, int H){
        if(dp[W][H] != -1) return dp[W][H];
        if(H == 0) return dp[W][H] = 1;
        long answer = 0;
        if(W < H && H >= 0){
            answer += dp(W,H-1);
        }
        if(W > 0){
            answer += dp(W-1,H);
        }
        return dp[W][H] = answer;
    }
}