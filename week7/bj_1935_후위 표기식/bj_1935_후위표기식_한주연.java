import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = stoi(br.readLine());
    	String str = br.readLine();
    	double[] opnd = new double[n];
    	int len = str.length();
    	//문자열 중 피 연산자들만 분리
    	for(int i = 0; i < n; i++) {
    		opnd[i] = stoi(br.readLine());
    	}
    	char curC;
    	// 후위 연산자 계산
    	Stack<Double> stack = new Stack<>();
    	Double a, b;
    	for(int i = 0; i < len; i++) {
    		curC = str.charAt(i);
    		if('A' <= curC && curC <= 'Z') {
    			stack.push(opnd[curC - 'A']);
    		}
    		else {
    			b = stack.pop();
    			a = stack.pop();
    			switch(curC) {
    			case '+':
    				stack.push(a + b);
    				break;
    			case '-':
    				stack.push(a - b);
    				break;
    			case '/':
    				stack.push(a / b);
    				break;
    			case '*':
    				stack.push(a * b);
    				break;
    			}
    		}
    	}

    	System.out.printf("%.2f", stack.pop());
    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}