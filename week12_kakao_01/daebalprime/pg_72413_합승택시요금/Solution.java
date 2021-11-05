import java.util.*;

class Solution {
    static final long INF = Long.MAX_VALUE/3-100;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // graph init
        s--;
        a--;
        b--;
        long[][] graph = new long[n][n];
        for(long[] ia : graph){
            Arrays.fill(ia, INF);
        }
        for(int i = 0; i < n; i++){
            graph[i][i] = 0;
        }
        for(int[] fare : fares){
            int from = fare[0]-1;
            int to = fare[1]-1;
            int weight = fare[2];
            graph[from][to] = weight;
            graph[to][from] = weight;
        }
        for(int m = 0; m < n; m++){
            for(int st = 0; st < n; st++){
                if(m==st) continue;
                for(int e = 0; e < n; e++){
                    if(st==e || e==m) continue;
                    graph[st][e] = Math.min(graph[st][e], graph[st][m] + graph[m][e]);
                }
            }
        }
        long answer = graph[s][a] + graph[s][b];
        for(int i = 0; i < n; i++){
            long cand = graph[s][i] + graph[i][a] + graph[i][b];
            answer = Math.min(answer, cand);
        }
        return (int)answer;
    }
}