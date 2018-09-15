package petShelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class PetShelterTest {
	PetShelter underTest = new PetShelter();

	@Test
	public void shouldAddAPet() {
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(1, allPets.size());
	}
	
	@Test
	public void shouldAddTwoPets() {
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 4,4,4));
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(2, allPets.size());
	}
	
	@Test 
	public void shouldDeleteAPet() {
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 4,4,4));
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.removePet("Boris");
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(1, allPets.size());
	}
	
	@Test
	public void steveHungerShouldBe5() {
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
		int check = underTest.getHungerLevel("Steve");
		assertEquals(5, check);
	}
	
	@Test
	public void getSteveDescription() {
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
		String check = underTest.getDescription("Steve");
		assertThat(check, is("A little lumpy"));
	}
	@Test
	public void aPetsHungerDecreasesFrom5To4WithFeeding() {
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
		underTest.feedAllPets();
		int check = underTest.getHungerLevel("Steve");
		assertEquals(4, check);
		
	}
	
	@Test
	public void allPetsThirstDecreasesWithWatering() {
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
		underTest.waterAllPets();
		int check = underTest.getThirstLevel("Boris");
		assertEquals(4, check);
		
	}
	
	@Test
	public void steveBoredomDecreasesFrom5to4WithPlaying() {
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
		underTest.playWith("Steve");
		int check = underTest.getBoredomLevel("Steve");
		assertEquals(4, check);
	}
	
	@Test
	public void putSteveInAdoptedList() {
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
		underTest.adoptPet("Steve");
		Collection<VirtualPet> allAdoptedPets = underTest.getAllAdpotedPets();
		assertEquals(1, allAdoptedPets.size());
	}
	@Test
	public void checkThatSteveIsntInTheShelterAfterAdoption() {
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
		underTest.adoptPet("Steve");
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(1, allPets.size());
	}
	@Test
	public void hungerShouldIncreaseFrom5To6WithTick() {
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
		underTest.tick();
		int check = underTest.getHungerLevel("Steve");
		assertEquals(6, check);
	}
	
	
	
}
