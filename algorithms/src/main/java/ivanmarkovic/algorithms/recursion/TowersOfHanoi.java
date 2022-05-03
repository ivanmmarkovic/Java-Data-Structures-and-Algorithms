package ivanmarkovic.algorithms.recursion;

/*
Towers of Hanoi: 
In the classic problem of the Towers of Hanoi, 
you have 3 towers and N disks of
different sizes which can slide onto any tower. 
The puzzle starts with disks sorted in ascending order
of size from top to bottom 
(i.e., each disk sits on top of an even larger one).
You have the following constraints:
*/

public class TowersOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		towers(3, "start", "spare", "end");
	}
	
	public static void printMove(String start, String end) {
		System.out.println("Moving from " + start + " to " + end);
	}
	
	public static void towers(int number, String start, String spare, String end) {
		if(number == 1)
			printMove(start, end);
		else {
			towers(number - 1, start, end, spare);
			towers(1, start, spare, end);
			towers(number - 1, spare, start, end);
		}
	}
}
