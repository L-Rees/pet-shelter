package petShelter;

import java.util.Scanner;

public class PetShelterApp {

	public static void main(String[] args) {
		PetShelter petShelter = new PetShelter();
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome To Lisa's Home for Helpless Pets!");
		System.out.println("Please admit a pet to begin.");
		System.out.println("What is the pet's name?");
		String petName = input.nextLine();
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
			petShelter.put(petName, new VirtualPet(petName, petDescription, hungerEntry, thirstEntry, boredomEntry));
		} else if (entryChoice.equalsIgnoreCase("n")) {
			petShelter.put(petName, new VirtualPet(petName, petDescription));
		}

	}

}
