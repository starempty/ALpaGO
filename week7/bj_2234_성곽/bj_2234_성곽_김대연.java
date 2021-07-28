import java.util.*;
import java.io.*;

public class Main {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 
        int[][] map = new int[M][N];
        int[][] newMap = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        int[] size = new int[2501];
        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 1;
        Queue<int[]> q = new ArrayDeque<int[]>();
        int max = 0;
        for(int j = 0; j < M; j++){
            for(int i = 0; i < N; i++){
                if(visited[j][i]) continue;
                visited[j][i] = true;
                int sz = 0;
                q.offer(new int[] {i,j});
                while(!q.isEmpty()){
                    sz++;
                    int[] curr = q.poll();
                    int x = curr[0];
                    int y = curr[1];
                    int wall = map[y][x];
                    newMap[y][x] = idx;
                    for(int k = 0; k < 4; k++){
                        if((wall & (1 << k)) > 0){
                            continue;
                        }
                        int nx = x+di[k];
                        int ny = y+dj[k];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[ny][nx]){
                            continue;
                        }
                        visited[ny][nx] = true;
                        q.offer(new int[] {nx,ny});
                    }
                }
                size[idx++] = sz;
                max = Math.max(max,sz);
            }
        }
        List<Set<Integer>> adj = new ArrayList<>(idx);
        for(int i = 0; i < idx; i++){
            adj.add(new HashSet<Integer>());
        }
        int answer = 0;
        for(int j = 0; j < M; j++){
            for(int i = 0; i < N; i++){
                int curr = newMap[j][i];
                answer = Math.max(answer,size[curr]);
                for(int k = 0; k < 4; k++){
                    int nx = i+di[k];
                    int ny = j+dj[k];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                        continue;
                    }
                    if(newMap[ny][nx] != curr){
                        answer = Math.max(answer,size[curr]+size[newMap[ny][nx]]);
                    }
                }
            }
        }
        // for(int[] ia : newMap){
        //     System.out.println(Arrays.toString(ia));
        // }
        
        System.out.println(idx-1);
        System.out.println(max);
        System.out.println(answer);
    }
}
