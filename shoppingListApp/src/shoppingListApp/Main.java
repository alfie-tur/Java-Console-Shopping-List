package shoppingListApp;

import java.util.ArrayList; //for creating the shopping list
import java.io.BufferedWriter; //for writing the file
import java.util.Scanner; //for user input

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to the shopping list program");
		System.out.println("This program will take inputs for your shopping list");
		System.out.println("The program will then put the list into a text file for the user");
		//come to think of it this is a useless project other than showing off skills, because surely you'd just create a text file...
		
		

	}
	
	public static void list() {
		Scanner input = new Scanner(System.in);
		ArrayList<String> shopList = new ArrayList<String>();
		
		boolean listFinished = false;
		
		while (!listFinished) {
			System.out.println("When you have finished inputting to the list please enter Q instead of an item");
			System.out.println("Please input what you would like to add to the list");
			String item = input.nextLine().toUpperCase();
			
			if (item.equals("Q")) {
				listFinished = true;
			}
			else {
				shopList.add(item);
			}
		}
		
	}

}
