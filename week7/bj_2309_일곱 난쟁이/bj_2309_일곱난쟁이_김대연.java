import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int[] height;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height = new int[9];
        for(int i = 0; i < 9; i++){
            height[i] = Integer.parseInt(br.readLine());
        }
        pick7(0,0, new int[7]);
        // System.out.println(answer);
    }

    private static void pick7(int cnt, int curr, int[] picks){
        if(cnt == 7){
            if(calc(picks) == 100){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < 7; i++){
                    picks[i] = height[picks[i]];
                }
                Arrays.sort(picks);
                for(int h : picks){
                    sb.append(h).append("\n");
                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }
        for(int i = curr; i < 9-(7-1-cnt); i++){
            picks[cnt] = i;
            pick7(cnt+1, i+1, picks);
        }
    }

    private static int calc(int[] picks){
        int sum = 0;
        for(int p : picks){
            sum += height[p];
        }
        return sum;
    }


}
