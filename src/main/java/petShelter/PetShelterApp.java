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
		String menuChoice = "0";
		while (!menuChoice.equals("6")) {
			System.out.println(petShelter.shelterStatus());
			System.out.println(petShelter.suggestion());
			System.out.println(generalMenu());
			menuChoice = input.nextLine();
			if (menuChoice.equals("1")) {
				petShelter.feedAllPets();
				System.out.println("All the pets have been fed.");
			} else if (menuChoice.equals("2")) {
				petShelter.waterAllPets();
				System.out.println("All the pets have been watered.");
			} else if (menuChoice.equals("3")) {
				System.out.println("These are the current pets in the Shelter\n");
				System.out.println(petShelter.petList());
				System.out.println("Which pet would you like to play with?");
				String petChoice = input.nextLine();
				while (!petShelter.nameCheck(petChoice)) {
					System.out.println("Please enter a valid pet");
					petChoice = input.nextLine();
				}
				petShelter.playWith(petChoice);
				System.out.println(petChoice + " was very happy to spend time with you!");
			} else if (menuChoice.equalsIgnoreCase("4")) {
				System.out.println("What is the pet's name?");
				petName = input.nextLine().trim();
				while (petShelter.nameCheck(petName)) {
					System.out.println("That name is already in use in the shelter. Please enter another name.");
					petName = input.nextLine().trim();
				}
				System.out.println("Please enter a description for " + petName + ".");
				petDescription = input.nextLine();
				System.out.println("Would you like to enter any stats for " + petName
						+ ", like hunger, thirst, or boredom? (y/n)");
				entryChoice = input.nextLine();
				validHunger = false;
				hungerEntry = 0;
				thirstEntry = 0;
				boredomEntry = 0;
				if (entryChoice.equalsIgnoreCase("y")) {
					while (!validHunger) {
						System.out.println(
								"Please enter the hunger level, on a scale of 1-10, with 10 being extremely hungry.");
						hungerEntry = input.nextInt();
						if (hungerEntry >= 1 && hungerEntry <= 10) {
							validHunger = true;
						} else {
							System.out.println("Please enter a valid number");
						}
					}
					boolean validThirst = false;
					while (!validThirst) {
						System.out.println(
								"Please enter the thirst level, on a scale of 1-10, with 10 being extremely thirsty.");
						thirstEntry = input.nextInt();
						if (thirstEntry >= 1 && thirstEntry <= 10) {
							validThirst = true;
						} else {
							System.out.println("Please enter a valid number");
						}
					}
					boolean validBoredom = false;
					while (!validBoredom) {
						System.out.println(
								"Please enter the boredom level, on a scale of 1-10, with 10 being extremely bored.");
						boredomEntry = input.nextInt();
						if (boredomEntry >= 1 && boredomEntry <= 10) {
							validBoredom = true;
						} else {
							System.out.println("Please enter a valid number");
						}
					}
					input.nextLine();
					petShelter.put(petName,
							new VirtualPet(petName, petDescription, hungerEntry, thirstEntry, boredomEntry));
				} else if (entryChoice.equalsIgnoreCase("n")) {
					petShelter.put(petName, new VirtualPet(petName, petDescription));
				}
			} else if (menuChoice.equalsIgnoreCase("5")) {
				System.out.println("These are the current pets in the Shelter\n");
				System.out.println(petShelter.petList());
				System.out.println("Which pet is being adopted?");
				String petChoice = input.nextLine();
				while (!petShelter.nameCheck(petChoice)) {
					System.out.println(
							"There is currently no pet by that name in the shelter. Please enter a valid name.");
					petChoice = input.nextLine().trim();
				}
				petShelter.adoptPet(petChoice);
				System.out.println(petChoice + " has found a forever home!");
			} else if (!menuChoice.equals("6")) {
				System.out.println("That is not a valid menu option.");
			}
			petShelter.tick();
		}
		System.out.println("Thank you for taking care of the pets in Lisa's Home for Helpless Pets! Goodbye.");
		System.exit(0);

		input.close();
	}

	public static String generalMenu() {
		return "What would you like to do next?\n" + "1  Feed all the pets\n" + "2  Water all the pets\n"
				+ "3  Play with an individual pet\n" + "4  Admit another pet to the shelter\n"
				+ "5  Adopt a pet out of the shelter\n" + "6  Exit";

	}

}
