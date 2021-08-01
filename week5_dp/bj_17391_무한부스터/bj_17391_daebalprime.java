import java.io.BufferedReader;

/**
 * Main
 */
import java.io.*;
import java.util.*;
public class Main {
    static int[] di = {0,1};
    static int[] dj = {1,0};
    static int[][] dp, map;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp =  new int[N][M];
        for(int[] ia : dp){
            Arrays.fill(ia, Integer.MAX_VALUE/2);
        }
        for(int j = 0; j < N; j++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = dfs(0,0);
        System.out.println(answer);
    }

    private static int dfs(int x, int y){
        if(x == M-1 && y == N-1){
            return 0;
        }
        int boost = map[y][x];
        for(int i = 1; i <= boost; i++){
            for(int k = 0; k < 2; k++){
                int nx = x + di[k]*i;
                int ny = y + dj[k]*i;
                if(nx < 0 || nx >= M || ny < 0 || ny >= N){
                    continue;
                }
                int ret = 0;
                if(dp[ny][nx] != Integer.MAX_VALUE/2){
                    ret =  dp[ny][nx];
                }
                else{
                    ret = dfs(nx,ny);
                }
                dp[y][x] = Math.min(ret + 1, dp[y][x]);
            }
        }
        if(dp[y][x] >= Integer.MAX_VALUE){
            System.out.println();
        }
        return dp[y][x];
    }
}