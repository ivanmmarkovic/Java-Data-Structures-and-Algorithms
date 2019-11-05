package ivanmarkovic.hashtable.chaining;

import java.util.ArrayList;
import java.util.List;

public class HashTableImpl<K extends Number, V> implements HashTable<K, V> {

    private int size;
    private ArrayList<List<K>> keys;
    private ArrayList<List<V>> values;

    public HashTableImpl(int size){
        this.size = size;
        this.keys = new ArrayList<>(this.size);
        this.values = new ArrayList<>(this.size);
    }

    @Override
    public void put(K key, V value) {
        int index = this.hash(key);
        if(this.keys.get(index) == null) {
            this.keys.add(index, new ArrayList<K>());
            this.values.add(index, new ArrayList<V>());
        }
        this.keys.get(index).add(key);
        this.values.get(index).add(value);
    }

    @Override
    public V get(K key) {
        int index = this.hash(key);
        if(this.keys.get(index) == null)
            return null;
        else{
            int count = 0;
            boolean found = false;
            while (count < this.keys.get(index).size() && !found){
                if(this.keys.get(index).get(count).equals(key))
                    found = true;
                else
                    count++;
            }
            return this.values.get(index).get(count);
        }
    }

    @Override
    public void delete(K key) {
        int index = this.hash(key);
        if(this.keys.get(index) == null)
            return;
        else{
            int count = 0;
            boolean found = false;
            while (count < this.keys.get(index).size() && !found){
                if(this.keys.get(index).get(count).equals(key))
                    found = true;
                else
                    count++;
            }
            this.keys.get(index).remove(count);
            this.values.get(index).remove(count);
        }
    }

    @Override
    public int length() {
        int count = 0;
        for(List<K> lists: this.keys){
            if(lists != null){
                for(K key: lists)
                    if(key != null)
                        count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(K key) {
        int index = this.hash(key);
        if(this.keys.get(index) == null)
            return false;
        else{
            int count = 0;
            boolean found = false;
            while (count < this.keys.get(index).size() && !found){
                if(this.keys.get(index).get(count).equals(key))
                    found = true;
                else
                    count++;
            }
            return found;
        }
    }

    private int hash(K key){
        return key.intValue() % this.size;
    }
}
