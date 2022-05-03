package ivanmarkovic.algorithms.recursion;

import java.util.Stack;

public class Maze {
	
	public static void main(String args[]) {
		Stack<int []> stack = new Stack<>();
		int numbers[] = {0, 0};
		stack.push(numbers);
		
		int matrix[][] = new int[5][5];
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = 0;
		
		
		matrix[0][0] = 1; // Must be 1, it's starting position
		for(int i = 2; i < matrix[0].length; i++)
			matrix[0][i] = 2;
		matrix[1][0] = 2;
		for(int i = 0; i < matrix[2].length; i++)
			if(i != 2)
				matrix[2][i] = 2;
		for(int i = 0; i < matrix[4].length; i++)
			if(i != 4)
				matrix[4][i] = 2;
		
		
		move(matrix, stack);
	}
	
	public static void move(int matrix[][], Stack<int[]> stack) {
		if(stack.isEmpty())
			System.out.println("Path not found");
		else {
			int newCoords[] = new int[2];
			int coords[] = new int[2];
			coords = stack.peek();
			Integer x = coords[0];
			Integer y = coords[1];
			if(x == matrix.length - 1 && y == matrix[x].length - 1) {
				System.out.println("Path found");
			}
			else if(y < matrix[x].length - 1 && matrix[x][y + 1] == 0) { // can go right
				matrix[x][y + 1] = 1;
				newCoords[0] = x; 
				newCoords[1] = y + 1;
				stack.push(newCoords);
				move(matrix, stack);
			}
			else if(x - 1 >= 0 && matrix[x - 1][y] == 0) { // can go up
				matrix[x - 1][y] = 1;
				newCoords[0] = x - 1; 
				newCoords[1] = y;
				stack.push(newCoords);
				move(matrix, stack);
			}
			else if(y - 1 >= 0 && matrix[x][y - 1] == 0) { // can go left
				matrix[x][y - 1] = 1;
				newCoords[0] = x; 
				newCoords[1] = y - 1;
				stack.push(newCoords);
				move(matrix, stack);
			}
			else if(x < matrix.length - 1 && matrix[x + 1][y] == 0) { // can go down
				matrix[x + 1][y] = 0;
				newCoords[0] = x + 1; 
				newCoords[1] = y;
				stack.push(newCoords);
				move(matrix, stack);
			}
			else {
				stack.pop();
				move(matrix, stack);
			}
		}
	}
}
