package petShelter;

import static org.junit.Assert.assertEquals;


import java.util.Collection;

import org.junit.Test;

public class PetShelterTest {
	PetShelter underTest = new PetShelter();

	@Test
	public void shouldAddAPet() {
		underTest.addPet("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(1, allPets.size());
	}
	
	@Test
	public void shouldAddTwoPets() {
		underTest.addPet("Steve", new VirtualPet("Steve", "A little lumpy", 4,4,4));
		underTest.addPet("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(2, allPets.size());
	}
	
	@Test 
	public void shouldDeleteAPet() {
		underTest.addPet("Steve", new VirtualPet("Steve", "A little lumpy", 4,4,4));
		underTest.addPet("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.removePet("Boris");
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(1, allPets.size());
	}
	
	@Test
	public void allPetsHungerDecreasesFrom5To4WithFeeding() {
		underTest.addPet("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.addPet("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
		underTest.feedAllPets();
		ArrayList <int> allHunger = underTest.getHungerLevels();
		assert(allHunger.contains(4));
		
	}
	
	//feed to decrease hunger, increase thirst
	//water to decrease thirst
	//play to decrease boredom, increase thirst
	
	
}
