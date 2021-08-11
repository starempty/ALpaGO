package bj_1991;

import java.io.*;
import java.util.*;

public class Main {
	static final int nullNode = '.'-'A';
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] tree = new int[N][];
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree[st.nextToken().charAt(0)-'A'] = new int[]{st.nextToken().charAt(0)-'A', st.nextToken().charAt(0)-'A'};
		}
		br.close();
		StringBuilder sb_pre = new StringBuilder();
		StringBuilder sb_in = new StringBuilder();
		StringBuilder sb_post = new StringBuilder();
		traversal(0,tree, sb_pre, sb_in, sb_post);
		bw.write(sb_pre.toString());
		bw.write('\n');
		bw.flush();
		bw.write(sb_in.toString());
		bw.write('\n');
		bw.flush();
		bw.write(sb_post.toString());
		bw.write('\n');
		bw.flush();
		bw.close();
	}
	static void traversal(int curr, int[][] tree, StringBuilder sb_pre, StringBuilder sb_in, StringBuilder sb_post){
		sb_pre.append((char)(curr+'A'));
		if(tree[curr][0] != nullNode){
			traversal(tree[curr][0], tree, sb_pre, sb_in, sb_post);
		}
		sb_in.append((char)(curr+'A'));
		if(tree[curr][1] != nullNode){
			traversal(tree[curr][1], tree, sb_pre, sb_in, sb_post);
		}
		sb_post.append((char)(curr+'A'));
	}

}
