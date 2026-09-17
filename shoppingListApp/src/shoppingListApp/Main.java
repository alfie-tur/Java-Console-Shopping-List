package shoppingListApp;

import java.util.ArrayList; //for creating the shopping list
import java.io.BufferedWriter; //for writing the file
import java.io.FileWriter;
import java.util.Scanner; //for user input

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to the shopping list program");
		System.out.println("This program will take inputs for your shopping list");
		System.out.println("The program will then put the list into a text file for the user");
		//come to think of it this is a useless project other than showing off skills, because surely you'd just create a text file...
		
		list();

	}
	
	public static void list() {
		Scanner input = new Scanner(System.in);
		ArrayList<String> shopList = new ArrayList<String>();
		
		System.out.println("\nWould you like to make a new shopping list, or add to your current one? \nFor a new shopping list type new, to add to the current one type old");
		String newOld = input.nextLine().toUpperCase();
		
		boolean listFinished = false;
		
		while (!listFinished) {
			System.out.println("\nWhen you have finished inputting to the list please enter Q instead of an item");
			System.out.println("Please input what you would like to add to the list");
			String item = input.nextLine().toUpperCase();
			
			if (item.equals("Q")) {
				listFinished = true;
			}
			else {
				shopList.add(item);
			}
		}
		
		if (newOld.contains("OLD")) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("Shopping List.txt", true))){
				
				for (String item : shopList) {
					bw.write(item);
					bw.newLine();
				}
				
			} catch (IOException e) {
				
				System.out.println("Error caused during file writing");
				e.printStackTrace();
				
			}
			
			System.out.println(shopList);
		}
		else if (newOld.contains("NEW")) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("Shopping List.txt"))){
				
				for (String item : shopList) {
					bw.write(item);
					bw.newLine();
				}
				
			} catch (IOException e) {
				
				System.out.println("Error caused during file writing");
				e.printStackTrace();
				
			}
			
			System.out.println(shopList);
		}
	}

}
