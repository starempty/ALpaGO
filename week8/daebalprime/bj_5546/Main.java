// package bj_17841;
package bj_5546;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int _ = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[N][3][3];
        /*
        dp [day][color][streak]
        day : 일수
        color : 내가 먹은 파스타 종류
        streak : 이걸 몇일 연속으로 먹었나

        검색으로 본 다른 DP 아이디어
        dp[day][D-2 color][D-1 color]
        D-2 color : 이틀 전 먹은 파스타 종류
        D-1 color : 하루 전 먹은 파스타 종류.
        이게 가능한 이유 = day-1일까지 3일 연속 먹은 파스타 케이스가 포함되지 않으면
        day일 계산 시 적당한 처리를 할 경우 3일 연속 먹은 파스타 케이스는 포함되지 않음
        */
        int[] fixed = new int[N];
        // 고정된 파스타 날짜
        Arrays.fill(fixed,-1);
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            fixed[A]= B;
        }

        // 초기값 설정
        if(fixed[0] != -1){
            //고정 케이스
            int f = fixed[0];
            dp[0][f][1] = 1;
        }else{
            // 고정 아닌 케이스. 모든 파스타를 1번 연속으로 먹는 경우는 1번씩 있다.
            dp[0][0][1] = 1;
            dp[0][1][1] = 1;
            dp[0][2][1] = 1;
        }
        for(int i = 1; i < N; i++){
            int f = fixed[i];
                for(int c = 0; c < 3; c++){
                    if(f != -1 && c != f) continue;
                    /*
                    만약 오늘 1번 파스타를 먹을 경우 계산해야 하는 경우의수
                    (color)/(streak)
                    2/1 ---\
                    2/2     \ ==> 1/1
                    3/1     /
                    3/2 ---/

                    1/1 => 1/2
                    */
                    dp[i][c][1] = 
                        (dp[i-1][(c+1)%3][1] +
                        dp[i-1][(c+1)%3][2] +
                        dp[i-1][(c+2)%3][1] +
                        dp[i-1][(c+2)%3][2])%10000;
                    
                    dp[i][c][2] = dp[i-1][c][1];
                }
            
        }
        int answer = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 1; j <= 2; j++){
                answer += dp[N-1][i][j];
            }
        }
        System.out.println(answer%10000);

    }
}