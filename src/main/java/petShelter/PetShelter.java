package petShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class PetShelter {

	Map<String, VirtualPet> pets = new HashMap <String, VirtualPet>();

	public void addPet(String name, VirtualPet virtualPet) {
		pets.put(name, new VirtualPet(name, name, 0, 0, 0));
		
		
	}

		// returns all the VirtualPet objects
	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void removePet(String name) {
		pets.remove(name);

		
	}

	public void feedAllPets() {


		
	}

	public Collection<VirtualPet> getHungerLevels() {
		return null;


	
	}

	

}
