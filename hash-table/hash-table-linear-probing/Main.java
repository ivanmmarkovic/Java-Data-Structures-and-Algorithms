
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable ht = new HashTable(11);
		
		ht.put(11, "string 11");
		ht.put(22, "string 22");
		ht.put(33, "string 33");
		ht.put(12, "string 12");
		
		System.out.println(ht.get(11)); // string 11
		System.out.println(ht.get(33)); // string 33
		System.out.println(ht.get(12)); // string 12
		System.out.println(ht.get(117)); //null
		
		System.out.println("Contains key 22 : " + ht.contains(22)); //  Contains key 22 : true
		System.out.println("Contains key 117 : " + ht.contains(117)); // Contains key 117 : false
		ht.delete(22);
		System.out.println("Contains key 22 : " + ht.contains(22)); // Contains key 22 : false
		
	}

}
