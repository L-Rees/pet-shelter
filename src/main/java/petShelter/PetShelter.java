package petShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetShelter {

	Map<String, VirtualPet> pets = new HashMap <String, VirtualPet>();
	Map<String, VirtualPet> adoptedPets = new HashMap <String, VirtualPet>();

	

		// returns all the VirtualPet objects
	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public Collection<VirtualPet> getAllAdpotedPets() {
		return adoptedPets.values();
	}
	public void adoptPet(String name) {
		adoptedPets.put(name, pets.get(name));
		removePet(name);
	}
	
	public void removePet(String name) {
		pets.remove(name);	
	}

	public void feedAllPets() {
		for (VirtualPet pet : getAllPets()) {
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

	public void put(String string, VirtualPet virtualPet) {
		pets.put(string, virtualPet);
	}

	public void waterAllPets() {
		for (VirtualPet pet : getAllPets()) {
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
		for (VirtualPet pet : getAllPets()) {
			pet.thirstier();
		}
	}

	private void increaseBoredom() {
		for (VirtualPet pet : getAllPets()) {
			pet.boreder();
		}
	}
	private void increaseHunger() {
		for (VirtualPet pet : getAllPets()) {
			pet.hungrier();
		}
	}




	

	

}
