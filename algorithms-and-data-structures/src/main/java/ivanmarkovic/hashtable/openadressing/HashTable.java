package ivanmarkovic.hashtable.openadressing;

public interface HashTable<K extends Number, V> {

    void put(K key, V value);

    V get(K key);

    void delete(K key);

    int length();

    boolean contains(K key);
}
