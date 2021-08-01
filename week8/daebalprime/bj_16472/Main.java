// package bj_17841;
package bj_16472;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int l = 0;
        int r = 0;
        int alpha = 1;
        int answer = 1;
        int[] alphas = new int[26];
        alphas[str.charAt(0)-'a'] = 1;
        while(true){
            if(alpha <= N){
                if(r == str.length()-1) break;
                char nxt = str.charAt(++r);
                int idx = nxt - 'a';
                if(alphas[idx] == 0){
                    alpha++;
                }
                alphas[idx]++;
            }else{
                char nxt = str.charAt(l++);
                int idx = nxt - 'a';
                if(alphas[idx] == 1){
                    alpha--;
                }
                alphas[idx]--;
            }
            if(alpha <= N){
                answer = Math.max(answer, r-l+1);
            }
        }
        System.out.println(answer);
    }
    private static int getIdx(char c){
        return c - 'a';
    }

}