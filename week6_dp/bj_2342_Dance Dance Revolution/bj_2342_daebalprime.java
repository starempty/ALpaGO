package bj_2342;

/**
 * Main
 */
import java.io.*;
import java.util.*;
public class Main {
    static int[] steps;
    static int[][][] dp;
    static int cnt;
    static int[][] energy = { // [from][to]
        {2,2,2,2,2},
        {-1,1,3,4,3},
        {-1,3,1,3,4},
        {-1,4,3,1,3},
        {-1,3,4,3,1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        steps = new int[100000];
        cnt = 0;
        while(true){
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            steps[cnt++] = N;
        }
        dp = new int[cnt][5][5];
        for(int[][] matrix : dp){
            for(int[] ia : matrix){
                Arrays.fill(ia,-1);
            }
        }

        int answer=  dfs(0,0,0);
        System.out.println(answer);
        

        /*
        0->others = 2;
        other->others = 3;
        opposite = 4;
        same = 1;
        */
    }
    static int dfs(int a, int b, int idx){
        if(idx == cnt){
            return 0;
        }
        int lf = Math.min(a,b);
        int rf = Math.max(a,b);
        if(dp[idx][lf][rf] != -1) return dp[idx][lf][rf];
        int nxt = steps[idx];
        int ret = Integer.MAX_VALUE;
        if(nxt == lf || nxt == rf){
            ret = Math.min(1+dfs(lf,rf,idx+1),ret);
        }
        else{
            ret = Math.min(energy[lf][nxt]+dfs(nxt,rf,idx+1),ret);
            ret = Math.min(energy[rf][nxt]+dfs(nxt,lf,idx+1),ret);
        }
        return dp[idx][lf][rf] = ret;
    }
}