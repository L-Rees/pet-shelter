package petShelter;

import java.util.Scanner;

public class PetShelterApp {

	public static void main(String[] args) {
		PetShelter petShelter = new PetShelter();
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome To Lisa's Home for Helpless Pets!");
		System.out.println("Please admit a pet to begin.");
		System.out.println("What is the pet's name?");
		String petName = input.nextLine().trim();
		System.out.println("Please enter a description for " + petName + ".");
		String petDescription = input.nextLine();
		System.out.println(
				"Would you like to enter any stats for " + petName + ", like hunger, thirst, or boredom? (y/n)");
		String entryChoice = input.nextLine();
		boolean validHunger = false;
		int hungerEntry = 0;
		int thirstEntry = 0;
		int boredomEntry = 0;
		if (entryChoice.equalsIgnoreCase("y")) {
			while (!validHunger) {
				System.out
						.println("Please enter the hunger level, on a scale of 1-10, with 10 being extremely hungry.");
				hungerEntry = input.nextInt();
				if (hungerEntry >= 1 && hungerEntry <= 10) {
					validHunger = true;
				} else {
					System.out.println("Please enter a valid number");
				}
			}
			boolean validThirst = false;
			while (!validThirst) {
				System.out
						.println("Please enter the thirst level, on a scale of 1-10, with 10 being extremely thirsty.");
				thirstEntry = input.nextInt();
				if (thirstEntry >= 1 && thirstEntry <= 10) {
					validThirst = true;
				} else {
					System.out.println("Please enter a valid number");
				}
			}
			boolean validBoredom = false;
			while (!validBoredom) {
				System.out
						.println("Please enter the boredom level, on a scale of 1-10, with 10 being extremely bored.");
				boredomEntry = input.nextInt();
				if (boredomEntry >= 1 && boredomEntry <= 10) {
					validBoredom = true;
				} else {
					System.out.println("Please enter a valid number");
				}
			}
			input.nextLine();
			petShelter.put(petName, new VirtualPet(petName, petDescription, hungerEntry, thirstEntry, boredomEntry));
		} else if (entryChoice.equalsIgnoreCase("n")) {
			petShelter.put(petName, new VirtualPet(petName, petDescription));
		}
		System.out.println(petShelter.shelterStatus());
		generalMenu();
		String menuChoice = input.nextLine();
		if (menuChoice.equalsIgnoreCase("1")) {
			petShelter.feedAllPets();
			System.out.println("All the pets have been fed.");
		}else if (menuChoice.equalsIgnoreCase("2")) {
			petShelter.waterAllPets();
			System.out.println("All the pets have been watered.");
		}else if (menuChoice.equalsIgnoreCase("3")) {
			System.out.println("Which pet would you like to play with?");
			String petChoice = input.nextLine();
			while (!petShelter.checkDupe(petChoice)) {
				System.out.println("Please enter a valid pet");
				petChoice = input.nextLine();
			}
			petShelter.playWith(petChoice);
			System.out.println(petChoice + " was very happy to spend time with you!");
		}else if (menuChoice.equalsIgnoreCase("4")) {
			
		}
		
		
		input.close();
	}
	
	public static String generalMenu() {
		return "What would you like to do next?\n" + "1  Feed all the pets\n" + "2  Water all the pets\n" + "3  Play with an individual pet\n" +
				"4  Admit another pet to the shelter\n" + "5  Adopt a pet out of the shelter\n";
				
	}

}
