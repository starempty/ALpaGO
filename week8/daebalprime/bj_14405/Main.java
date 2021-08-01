// package bj_17841;
package bj_14405;

import java.util.*;
import java.io.*;

public class Main {
    static String[] sounds = {"pi", "ka", "chu"};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int ptr = 0;
        while(ptr < str.length()){
            boolean match = false;
            for(String s : sounds){
                int streak = 0;
                for(int i = ptr; i < Math.min(ptr+s.length(), str.length()); i++){
                    if(s.charAt(i-ptr) != str.charAt(i)){
                        break;
                    }else{
                        streak++;
                    }
                }
                if(streak == s.length()){
                    match = true;
                }
                if(match){
                    ptr += s.length();
                    break;
                }
            }
            if(!match){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}