package ivanmarkovic.algorithms.trie;

import java.util.HashMap;

class TrieNode {
	
	Character key;
	TrieNode parent;
	HashMap<Character, TrieNode> children;
	boolean endchar;
	
	public TrieNode() {
		// TODO Auto-generated constructor stub
		this.children = new HashMap<Character, TrieNode>();
	}
	
	public TrieNode(char key, TrieNode parent) {
		this();
		this.key = key;
		this.parent = parent;
	}
	
	
}