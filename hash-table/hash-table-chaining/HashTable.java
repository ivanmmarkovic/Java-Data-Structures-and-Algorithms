import java.util.ArrayList;

public class HashTable<T extends Number, V> {

	ArrayList<List<T>> keys;
	ArrayList<List<V>> values;
	int size;
	public HashTable(int size) {
		this.size = size;
		this.keys = new ArrayList<List<T>>(this.size);
		this.values = new ArrayList<List<V>>(this.size);
		
		for(int i = 0; i < this.size; i++) {
			this.keys.add(i, new List<T>());
			this.values.add(i, new List<V>());
		}
	}
	
	public void put(T key, V value) {
		int hash = this.hash(key, size);
		if(this.keys.get(hash).contains(key)) {
			int index = this.keys.get(hash).getIndex(key);
			this.values.get(hash).insertValueOnIndex(index, value);
		}
		else {
			this.keys.get(hash).addToHead(key);
			this.values.get(hash).addToHead(value);
		}
		
	}	
	
	public V get(T key) {
		int hash = this.hash(key, size);
		if(this.keys.get(hash).contains(key)) {
			int index = this.keys.get(hash).getIndex(key);
			return this.values.get(hash).returnNodeOnIndex(index).info;
		}
		else 
			return null;
		
	}
	
	public void delete(T key) {
		int hash = this.hash(key, size);
		if(this.keys.get(hash).contains(key)) {
			int index = this.keys.get(hash).getIndex(key);
			this.keys.get(hash).deleteOnIndex(index);
			this.values.get(hash).deleteOnIndex(index);
		}
	}
	
	public boolean containsKey(T key){
		int hash = this.hash(key, this.keys.size());
		return this.keys.get(hash).contains(key);
	}
	
	public int hash(T key, int size) {
		return key.intValue() % size;
	}
	
}


