package petShelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class PetShelterTest {
	PetShelter underTest = new PetShelter();
	
//	@Test
//	public void shouldAddAPet() {
//		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
//		Collection<VirtualPet> allPets = underTest.getAllPets();
//		assertEquals(1, allPets.size());
//	}
	@Before
	public void setUp() {
		underTest.put("Boris", new VirtualPet("Boris", "A mean-looking character",5, 5, 5));
		underTest.put("Steve", new VirtualPet("Steve", "A little lumpy", 5, 5, 5));
	}
	
	@Test
	public void shouldAddTwoPets() {
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(2, allPets.size());
	}
	
	@Test 
	public void shouldDeleteAPet() {
		underTest.removePet("Boris");
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(1, allPets.size());
	}
	
	@Test
	public void steveHungerShouldBe5() {
		int check = underTest.getHungerLevel("Steve");
		assertEquals(5, check);
	}
	
	@Test
	public void getSteveDescription() {
		String check = underTest.getDescription("Steve");
		assertThat(check, is("A little lumpy"));
	}
	@Test
	public void aPetsHungerDecreasesFrom5To4WithFeeding() {
		underTest.feedAllPets();
		int check = underTest.getHungerLevel("Steve");
		assertEquals(4, check);	
	}
	
	@Test
	public void aPetsThirstDecreasesWithWatering() {
		underTest.waterAllPets();
		int check = underTest.getThirstLevel("Boris");
		assertEquals(4, check);	
	}
	
	@Test
	public void steveBoredomDecreasesFrom5to4WithPlaying() {
		underTest.playWith("Steve");
		int check = underTest.getBoredomLevel("Steve");
		assertEquals(4, check);
	}
	
	@Test
	public void putSteveInAdoptedList() {
		underTest.adoptPet("Steve");
		Collection<VirtualPet> allAdoptedPets = underTest.getAllAdpotedPets();
		assertEquals(1, allAdoptedPets.size());
	}
	@Test
	public void checkThatPetCountIsOneAfterAdoption() {
		underTest.adoptPet("Steve");
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(1, allPets.size());
	}
	@Test
	public void hungerShouldIncreaseFrom5To6WithTick() {
		underTest.tick();
		int check = underTest.getHungerLevel("Steve");
		assertEquals(6, check);
	}
	@Test
	public void shouldReturnTrueIfSteveIsInShelter() {
		boolean check = underTest.checkDupe("Steve");
		assertTrue(check);
	}
	@Test
	public void shouldReturnFalseAfterSteveIsAdopted() {
		underTest.adoptPet("Steve");
		boolean check = underTest.checkDupe("Steve");
		assertFalse(check);
	}
	@Test
	public void adoptedPetsListShouldHaveSteve1AfterTwoStevesAdopted() {
		underTest.adoptPet("Steve");
		underTest.put("Steve", new VirtualPet("Steve", "a little less lumpy"));
		underTest.adoptPet("Steve");
		boolean check = underTest.adoptedPets.containsKey("Steve1");
		assertTrue(check);
	}
	
	
}
