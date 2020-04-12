package ivanmarkovic.algorithms.trie;


import java.util.HashMap;

public class TrieNode {
	
	TrieNode parent;
	Character key;
	HashMap<Character, TrieNode> children;
	boolean terminating;
	
	public TrieNode(Character key, TrieNode parent) {
		this.key = key;
		this.parent = parent;
		this.children = new HashMap<Character, TrieNode>();
	}

	public TrieNode(){
		this.children = new HashMap<Character, TrieNode>();
	}
}
