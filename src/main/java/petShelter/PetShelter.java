package petShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetShelter {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	Map<String, VirtualPet> adoptedPets = new HashMap<String, VirtualPet>();

	private int dupeCount = 1;

	// returns all the VirtualPet objects
	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	// returns all the adopted VirtualPet objects
	public Collection<VirtualPet> getAllAdpotedPets() {
		return adoptedPets.values();
	}

	public void adoptPet(String name) {
		if (adoptedPets.containsKey(name)) {
			name = name + dupeCount;
			dupeCount++;
		}
		adoptedPets.put(name, pets.get(name));
		removePet(name);
	}

	public void removePet(String name) {
		pets.remove(name);
	}

	public void feedAllPets() {
		for (VirtualPet pet : pets.values()) {
			pet.feed();
		}
	}

	public int getHungerLevel(String name) {
		int hungerLevel = pets.get(name).getHunger();
		return hungerLevel;
	}

	public String getDescription(String name) {
		return (pets.get(name).getDescription());
	}

	public void put(String name, VirtualPet virtualPet) {
		pets.put(name, virtualPet);
	}

	public void waterAllPets() {
		for (VirtualPet pet : pets.values()) {
			pet.water();
		}
	}

	public int getThirstLevel(String name) {
		int thirstLevel = pets.get(name).getThirst();
		return thirstLevel;
	}

	public void playWith(String name) {
		pets.get(name).play();
	}

	public int getBoredomLevel(String name) {
		int boredomLevel = pets.get(name).getBoredom();
		return boredomLevel;
	}

	public void tick() {
		increaseHunger();
		increaseThirst();
		increaseBoredom();
	}

	private void increaseThirst() {
		for (VirtualPet pet : pets.values()) {
			pet.thirstier();
		}
	}

	private void increaseBoredom() {
		for (VirtualPet pet : pets.values()) {
			pet.boreder();
		}
	}

	private void increaseHunger() {
		for (VirtualPet pet : pets.values()) {
			pet.hungrier();
		}
	}

	public boolean nameCheck(String name) {
		return pets.containsKey(name);
	}

	public String shelterStatus() {
		String status = "\n\t\t Lisa's Home For Helpless Pets\n\n\t\t\t\tPET STATUS\n" + "\t\tHunger\t\tThirst\t\tBoredom\n";
		for (VirtualPet pet : pets.values()) {
			String name = pet.getName();
			status += "\n" + name + "\t\t " + showLevel(getHungerLevel(name)) + "\t" + showLevel(getThirstLevel(name))
					+ "\t" + showLevel(getBoredomLevel(name));
		}

		return status;

	}

	public String showLevel(int quality) {
		String level = "";
		for (int i = 0; i < quality; i++) {
			level = level + "|";
		}
		for (int i = 0; i < 10 - quality; i++) {
			level = level + ".";
		}
		return level;

		// good-||||......-bad
	}

	public String suggestion() {
		String suggestion = "";
		int hungerMax = 0;
		for (VirtualPet pet : pets.values()) {
			if (pet.getHunger() > hungerMax) {
				hungerMax = pet.getHunger();
			}
		}
		int thirstMax = 0;
		for (VirtualPet pet : pets.values()) {
			if (pet.getThirst() > thirstMax) {
				thirstMax = pet.getThirst();
			}
		}
		int boredomMax = 0;
		String boredestPet = "";
		for (VirtualPet pet : pets.values()) {
			if (pet.getBoredom() > boredomMax) {
				boredomMax = pet.getBoredom();
				boredestPet = pet.getName();
			}
		}
		if (hungerMax >= 8) {
			suggestion += "At least one pet is very hungry. You should feed them.";
		}
		if (thirstMax >= 8) {
			suggestion += "\nAt least one pet is very thirsty. You should give them water.";
		}
		if (boredomMax >= 8) {
			suggestion += "\n" + boredestPet + " is very bored and wants to play.";
		}
		return suggestion;
	}

	public String petList() {
		String list = "";
		for (VirtualPet pet : pets.values()) {
			list += (pet.getName() + "\t\t" + pet.getDescription() + "\n");
		}
		return list;
	}

}
