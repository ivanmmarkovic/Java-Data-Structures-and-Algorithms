
public class HashTable {

	Integer keys[];
	String values[];
	public HashTable(int size) {
		this.keys = new Integer[size];
		this.values = new String[size];
	}
	
	public void put(Integer key, String value) {
		int hash = this.hash(key, this.keys.length);
		if(this.keys[hash] == null) {
			this.keys[hash] = key;
			this.values[hash] = value;
		}
		else if(this.keys[hash] == key) {
			this.values[hash] = value;
		}
		else {
			int newHash = this.rehash(hash, this.keys.length);
			while(newHash != hash && this.keys[newHash] != null && this.keys[newHash] != key) {
				newHash = this.rehash(newHash, this.keys.length);
			}
			if(this.keys[newHash] == null) {
				this.keys[newHash] = key;
				this.values[newHash] = value;
			}
			else if(this.keys[newHash] == key) {
				this.values[newHash] = value;
			}
		}
	}
	
	public String get(Integer key) {
		int hash = this.hash(key, this.keys.length);
		if(this.keys[hash] == null) {
			return null;
		}
		else if(this.keys[hash] == key) {
			return this.values[hash];
		}
		else {
			int newHash = this.rehash(hash, this.keys.length);
			while(newHash != hash && this.keys[newHash] != null && this.keys[newHash] != key) {
				newHash = this.rehash(newHash, this.keys.length);
			}
			if(this.keys[newHash] == key) 
				return this.values[newHash];
			else 
				return null;
		}
	}
	
	public void delete(Integer key) {
		int hash = this.hash(key, this.keys.length);
		if(this.keys[hash] == null) {
			return;
		}
		else if(this.keys[hash] == key) {
			this.keys[hash] = null;
			this.values[hash] = null;
		}
		else {
			int newHash = this.rehash(hash, this.keys.length);
			while(newHash != hash && this.keys[newHash] != null && this.keys[newHash] != key) {
				newHash = this.rehash(newHash, this.keys.length);
			}
			if(this.keys[newHash] == key) {
				this.keys[newHash] = null;
				this.values[newHash] = null;
			}
			else 
				return;
		}
	}
	
	public boolean contains(Integer key){
		int hash = this.hash(key, this.keys.length);
		if(this.keys[hash] == null) {
			return false;
		}
		else if(this.keys[hash] == key) {
			return true;
		}
		else {
			int newHash = this.rehash(hash, this.keys.length);
			while(newHash != hash && this.keys[newHash] != null && this.keys[newHash] != key) {
				newHash = this.rehash(newHash, this.keys.length);
			}
			if(this.keys[newHash] == key)
				return true;
			else 
				return false;
		}
	}
	
	public int hash(int key, int size) {
		return key % size;
	}
	
	public int rehash(int oldHash, int size) {
		return (oldHash + 1) % size;
	}
}


