import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String expr = br.readLine();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> stack = new Stack<Double>();
        for(int i = 0; i < expr.length(); i++){
            char curr = expr.charAt(i);
            if(curr >= 'A' && curr <= 'Z'){
                int idx = (int) curr-'A';
                double num = nums[idx];
                stack.push(num);
            }
            else{
                double n2 =stack.pop();
                double n1 =stack.pop();
                switch (curr) {
                    case '*':
                        stack.push(n1*n2);
                        break;
                    case '/':
                        stack.push(n1/n2);
                        break;
                    case '+':
                        stack.push(n1+n2);
                        break;
                    case '-':
                        stack.push(n1-n2);
                        break;
                    default:
                        break;
                }
            }
        }
        double answer = stack.pop();
        System.out.println(String.format("%.2f", answer));
    }
}
