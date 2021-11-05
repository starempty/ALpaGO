import java.util.*;
class Solution {
    static final char EMPTY = ' ';
    static final int[] di = {0,0,1,1};
    static final int[] dj = {0,1,0,1};
    public int solution(int m, int n, String[] input) {
        int answer = 0;
        char[][] map = new char[m][n];
        // for(char[] ca : map){
        //     Arrays.fill(ca, EMPTY);
        // }
        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                map[j][i] = input[j].charAt(i);
            }
        }
        while(true){
            int destroyed = pang(map,m,n);
            if(destroyed == 0) break;
            answer += destroyed;
            gravity(map,m,n);
        }
        return answer;
        // return pang(map,m,n);
    }
    private static int pang(char[][] map, int M, int N){
        boolean[][] mark = new boolean[M][N];
        for(int j = 0; j < M-1; j++){
            for(int i = 0; i < N-1; i++){
                int match = 1;
                if(map[j][i] == EMPTY) continue;
                for(int k = 1; k < 4; k++){
                    int nj = j + dj[k];
                    int ni = i + di[k];
                    if(map[nj][ni]==map[j][i]){
                        match++;
                    }
                    else{
                        break;
                    }
                }
                if(match==4){
                    // System.out.println(i+" " +j);
                    for(int k = 0; k < 4; k++){
                        int nj = j + dj[k];
                        int ni = i + di[k];
                        mark[nj][ni] = true;
                    }
                }
            }
        }
        int ret = 0;
        for(int j = 0; j < M; j++){
            for(int i = 0; i < N; i++){
                if(mark[j][i]){
                    ret++;
                    map[j][i] = EMPTY;
                }
            }
        }
        return ret;
    }
    private static void gravity(char[][] map, int M, int N){
        for(int i = 0; i < N; i++){
            int cursor = M-1;
            for(int j = M-1; j >= 0; j--){
                if(map[j][i] != EMPTY){
                    char temp = map[j][i];
                    map[j][i] = EMPTY;
                    map[cursor--][i] = temp;
                }
            }
        }
    }
}