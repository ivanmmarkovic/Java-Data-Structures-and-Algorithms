package ivanmarkovic.algorithms.trie;

public class App 
{
    public static void main( String[] args ){
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cats");
        trie.insert("java");
        trie.insert("javascr"); // need for removing
        trie.insert("javascript");
        trie.insert("javaee");
        trie.insert("scala");
        
        System.out.println("All words : " + trie.allWords());
        System.out.println("All words with prefix 'py' : " + trie.allWordsWithPrefix("py"));
        System.out.println("All words with prefix 'ca' : " + trie.allWordsWithPrefix("ca"));
        System.out.println("All words with prefix 'java' : " + trie.allWordsWithPrefix("java"));
        
        trie.remove("javascr");
        System.out.println("All words with prefix 'java' : " + trie.allWordsWithPrefix("java"));
        
    }
}
