package ivanmarkovic.algorithms.trie;

public class Main {
	
	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert("java");
		trie.insert("javascript");
		trie.insert("javaee");
		trie.insert("scala");
		trie.insert("scalable");
		
		System.out.println("Contains javascript : " + trie.contains("javascript"));
		System.out.println("Contains java : " + trie.contains("java"));
		System.out.println("Any word starts with javasc : " + trie.startsWith("javasc"));
		System.out.println("Any word starts with scal : " + trie.startsWith("scal"));
		
		System.out.println("Words starts with java : " + trie.startsWithList("java"));
		System.out.println("Words starts with py : " + trie.startsWithList("py"));
		
		System.out.println("Count words : " + trie.countWords());
		trie.deleteWord("java");
		System.out.println("Words starts with java : " + trie.startsWithList("java"));
		System.out.println("Count words : " + trie.countWords());
		
	}

}
