package alpagoStudy;

import java.io.*;
import java.util.*;

public class Main_bj_5052_전화번호목록 {
	static class TrieNode{
		private Map<Character, TrieNode> childNode = new HashMap<>();
		private boolean isLast;
		
		public boolean isLast() {
			return this.isLast;
		}
		
		public void setIsLast(boolean isLast) {
			this.isLast = isLast;
		}
		
		public Map<Character, TrieNode> getChildNode(){
			return this.childNode;
		}
	}
	static class Trie{
		private TrieNode root = new TrieNode();
		
		private void insert(String key) {
			TrieNode tmp =  this.root;
			for(int i = 0; i < key.length(); i++) {
				tmp = tmp.getChildNode().computeIfAbsent(key.charAt(i), c -> new TrieNode());
			}
			tmp.setIsLast(true);
		}
		private boolean find(String key) {
			TrieNode tmp = this.root;
			
			for(int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				TrieNode node = tmp.getChildNode().get(c);
				if(node == null) return false;
				tmp = node;
			}
			if(tmp.isLast()) {
				if(tmp.getChildNode().isEmpty()) return false;
			}
			return true;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			int size = sb.length();
			int n = Integer.parseInt(br.readLine());
			
			String[] arr = new String[n];
			Trie trie = new Trie();
			for(int i = 0; i < n; i++) {
				String tmp = br.readLine();
				trie.insert(tmp);
				arr[i] = tmp;
			}
			for(String cur: arr) {
				if(trie.find(cur)) {
					sb.append("NO\n");
					break;
				}
			}
			if(sb.length() == size) sb.append("YES\n");
		}
		System.out.println(sb);
	}
}
