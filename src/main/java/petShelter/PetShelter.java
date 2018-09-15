package petShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;



public class PetShelter {

	Map<String, VirtualPet> pets = new HashMap <String, VirtualPet>();

	

		// returns all the VirtualPet objects
	public Collection<VirtualPet> getAllPets() {
		return pets.values();
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



	

	

}
