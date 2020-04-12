package ivanmarkovic.algorithms.trie;


import java.util.ArrayList;
import java.util.List;

public class Trie {
	
	TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	
    public void insert(String word) {
    	TrieNode current = this.root;
        for(char c: word.toCharArray()) {
        	if(!current.children.containsKey(c)) {
        		current.children.put(c, new TrieNode(c, current));
        	}
        	current = current.children.get(c);
        }
        current.terminating = true;
    }
    
    public boolean search(String word) {
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
        else
        	return current.terminating;
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
    
    public List<String> allWords() {
		List<String> words = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		this.helper(this.root, sb, words);
		return words;
	}
    
    public void helper(TrieNode node, StringBuilder sb, List<String> words) {
		if(node == null)
			return;
		if(node.key != null)
			sb.append(node.key);
		if(node.terminating) {
			words.add(sb.toString());
		}
		StringBuilder cloned;
		for(Character c: node.children.keySet()) {
			cloned = new StringBuilder(sb.toString());
			helper(node.children.get(c), cloned, words);
		}
	}
    
    public List<String> allWordsWithPrefix(String prefix) {
		List<String> words = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		TrieNode current = this.root;
		for(Character c: prefix.toCharArray()) {
			if(!current.children.containsKey(c)) {
				current = null;
				break;
			}
			sb.append(c);
			current = current.children.get(c);
		}
		if(current == null)
			return words;
		
		sb.deleteCharAt(sb.length() - 1);
		this.helper(current, sb, words);
		return words;
	}
    
    public void remove(String word) {
		TrieNode current = this.root;
		for(Character c: word.toCharArray()) {
			if(!current.children.containsKey(c)) {
				current = null;
				break;
			}
			current = current.children.get(c);
		}
		if(current == null)
			return;
		current.terminating = false;
		TrieNode parent = current.parent;
		while (parent != null && !current.terminating && current.children.size() == 0) {
			parent.children.remove(current.key);
			current = parent;
			parent = current.parent;
		}
	}
}