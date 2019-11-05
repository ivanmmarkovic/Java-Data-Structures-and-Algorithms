package ivanmarkovic.algorithms.hashtable.openadressing;

import java.util.ArrayList;
/*
Important:
When deleting, just remove from keys.
If your hash table has size of 11.
If you put(11, "String 11"), it will be index 0 (11 % 11 = 0).
If you later put(22, "String 22"), it will be index 1, because 0 is taken.
If you delete key 11 and value at index 0("String 11"), and later search for key 22,
you will get null or false, because 22 % 11 = 0.
 */

public class HashTableImpl<K extends Number, V> implements HashTable<K, V> {

    private int size;
    private ArrayList<K> keys;
    private ArrayList<V> values;
    public HashTableImpl(int size){
        this.size = size;
        this.keys = new ArrayList<>(size);
        this.values = new ArrayList<>(size);
    }
    @Override
    public void put(K key, V value) {
        int index = this.hash(key);
        if (this.keys.get(index) == null || this.keys.get(index).equals(key)){
            this.keys.add(index, key);
            this.values.add(index, value);
        }
        else {
            int newIndex = this.rehash(index);
            while(newIndex != index && this.keys.get(newIndex) != null && !this.keys.get(newIndex).equals(key)){
                newIndex = this.rehash(newIndex);
            }
            if (this.keys.get(newIndex) == null || this.keys.get(newIndex).equals(key)){
                this.keys.add(newIndex, key);
                this.values.add(newIndex, value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = this.hash(key);
        if (this.keys.get(index) == null && this.values.get(index) == null)
            return null;
        else if(this.keys.get(index).equals(key))
            return this.values.get(index);
        else {
            int newIndex = this.rehash(index);
            while(newIndex != index && !(this.keys.get(newIndex) == null && this.values.get(newIndex) == null) && !this.keys.get(newIndex).equals(key)){
                newIndex = this.rehash(newIndex);
            }
            if (this.keys.get(newIndex).equals(key))
                return this.values.get(newIndex);
            else
                return null;
        }
    }

    @Override
    public void delete(K key) {
        int index = this.hash(key);
        if (this.keys.get(index) == null && this.values.get(index) == null)
            return;
        else if(this.keys.get(index).equals(key))
            this.keys.add(index, null);
        else {
            int newIndex = this.rehash(index);
            while(newIndex != index && !(this.keys.get(newIndex) == null && this.values.get(newIndex) == null) && !this.keys.get(newIndex).equals(key)){
                newIndex = this.rehash(newIndex);
            }
            if (this.keys.get(newIndex).equals(key))
                this.values.add(newIndex, null);
        }
    }

    @Override
    public int length() {
        int count = 0;
        for(K key: this.keys)
            if(key != null)
                count++;
        return count;
    }

    @Override
    public boolean contains(K key) {
        int index = this.hash(key);
        if (this.keys.get(index) == null && this.values.get(index) == null)
            return false;
        else if(this.keys.get(index).equals(key))
            return true;
        else {
            int newIndex = this.rehash(index);
            while(newIndex != index && !(this.keys.get(newIndex) == null && this.values.get(newIndex) == null) && !this.keys.get(newIndex).equals(key)){
                newIndex = this.rehash(newIndex);
            }
            if (this.keys.get(newIndex).equals(key))
                return true;
            else
                return false;
        }
    }

    private int hash(K key){
        return key.intValue() % this.size;
    }

    private int rehash(int hash){
        return (hash + 1) % this.size;
    }
}
