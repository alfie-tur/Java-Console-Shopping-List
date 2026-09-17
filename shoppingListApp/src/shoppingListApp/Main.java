package shoppingListApp;

import java.util.ArrayList; //for creating the shopping list
import java.io.BufferedWriter; //for writing the file
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
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
		
		if (newOld.contains("OLD")) { //in here will need to do ArrayList = what's read in the text file so that removing items works in the later part of the code
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("Shopping List.txt", true))){
				for (String item : shopList) {
					bw.write(item);
					bw.newLine();
				}
				
			} catch (IOException e) {
				
				System.out.println("Error caused during file writing");
				e.printStackTrace();
				
			}
			
			try (BufferedReader br = new BufferedReader(new FileReader("Shopping List.txt"))){
				String line;
				shopList.clear();
				while ((line = br.readLine()) != null) {
					shopList.add(line);
				}
			} catch (Exception e) {
				System.out.println("Error in reading to output to ArrayList");
			}
			
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
		}
		
		System.out.println("Here is the current content of your list:");
		System.out.println(shopList);
		System.out.println("\nIs there anything you would like to remove from the list?");
		String yesNo = input.nextLine().toUpperCase();
		
		if (yesNo.contains("YE")) {
			System.out.println("How many items would you like to remove?\nPlease enter your answer as a number IE 1 rather than one");
			int amountRemove = input.nextInt();
			
			while (amountRemove >= 0) {
				System.out.println("What would you like to remove?");
				String remove = input.nextLine().toUpperCase();
				
				System.out.println(shopList);
				for (int i = 0; i < shopList.size(); i++) {
					if (shopList.get(i).equals(remove)) {
						shopList.remove(i);
					}
				}
				System.out.println(shopList);
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("Shopping List.txt"))){
					for (String item : shopList) {
						bw.write(item);
						bw.newLine();
					}
				} catch (Exception e) {
					System.out.println("Removing error");
				}
				amountRemove = amountRemove - 1;
			}
		}
		
	}

}
