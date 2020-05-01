package ivanmarkovic.algorithms.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	
	TrieNode root;
	public Trie() {
		// TODO Auto-generated constructor stub
		this.root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = this.root;
		for(int i = 0; i < word.length(); i++) {
			if(!current.children.containsKey(word.charAt(i)))
				current.children.put(word.charAt(i), new TrieNode(word.charAt(i), current));
			current = current.children.get(word.charAt(i));
		}
		current.endchar = true;
	}
	
	public boolean contains(String word) {
		TrieNode current = this.root;
		for(char c: word.toCharArray()) {
			if(!current.children.containsKey(c)) {
				current = null;
				break;
			}
			current = current.children.get(c);
		}
		if(current == null)
			return false;
		return current.endchar;
	}
	
	public boolean startsWith(String prefix) {
		TrieNode current = this.root;
		for(char c: prefix.toCharArray()) {
			if(!current.children.containsKey(c)) {
				current = null;
				break;
			}
			current = current.children.get(c);
		}
		if(current == null)
			return false;
		return true;
	}
	
	public List<String> startsWithList(String prefix) {
		TrieNode current = this.root;
		StringBuilder sb = new StringBuilder();
		List<String> words = new ArrayList<String>();
		for(char c: prefix.toCharArray()) {
			if(!current.children.containsKey(c)) {
				current = null;
				break;
			}
			sb.append(c);
			current = current.children.get(c);
		}
		if(current == null)
			return words;
		startsWithListHelper(current, sb, words);
		return words;
	}
	
	private void startsWithListHelper(TrieNode node, StringBuilder sb, List<String> list) {
		if(node.endchar)
			list.add(sb.toString());
		for(char c: node.children.keySet()) {
			StringBuilder sbCloned = new StringBuilder(sb);
			startsWithListHelper(node.children.get(c), sbCloned.append(c), list);
		}
	}
	
	public int countWords() {
		TrieNode current = this.root;
		int result = 0;
		for(char c: current.children.keySet()) {
			result += countWordsHelper(current.children.get(c));
		}
		return result;
	}
	
	private int countWordsHelper(TrieNode node) {
		int result = 0;
		if(node.endchar)
			result += 1;
		for(char c: node.children.keySet()) {
			result += countWordsHelper(node.children.get(c));
		}
		return result;
	}
	
	public void deleteWord(String word) {
		TrieNode current = this.root;
		for(char c: word.toCharArray()) {
			if(!current.children.containsKey(c)) {
				current = null;
				break;
			}
			current = current.children.get(c);
		}
		if(current == null)
			return;
		current.endchar = false;
		TrieNode parent = current.parent;
		while (parent != null && !current.endchar && !(current.children.size() > 0)) {
			parent.children.remove(current.key);
			current = parent;
			parent = current.parent;
		}
	}

}
