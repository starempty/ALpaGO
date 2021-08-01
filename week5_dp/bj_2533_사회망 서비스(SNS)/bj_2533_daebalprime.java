package bj_2533;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static boolean[] visited;
    static Map<Integer,List<Integer>> hm;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hm = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!hm.containsKey(a)){
                hm.put(a, new ArrayList<Integer>());
            }
            if(!hm.containsKey(b)){
                hm.put(b, new ArrayList<Integer>());
            }
            hm.get(a).add(b);
            hm.get(b).add(a);
        }
        dp = new int[N+1][2];
        for(int[] ia : dp){
            Arrays.fill(ia,-1);
        }
        br.close();
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1,true); 
        dfs(1,false);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    static int dfs(int n, boolean isEarly){
        int e = (isEarly? 1: 0);
        if(dp[n][e] != -1) return dp[n][e];
        if(!hm.containsKey(n)) return dp[n][e] = e;
        List<Integer> nxts = hm.get(n);
        boolean isLeaf = true;
        int local = 0;
        for(int nxt : nxts){
            if(visited[nxt]) continue;
            isLeaf = false;
            visited[nxt]= true;
            int r1 = 2000000;
            int r2 = 2000000;
            if(isEarly){
                r1 = dfs(nxt,false);
            }
            r2 = dfs(nxt,true);
            local += Math.min(r1, r2);
            visited[nxt]= false;
        }
        if(isLeaf) return dp[n][e] = e ;
        return dp[n][e] = local + e;
    }
}