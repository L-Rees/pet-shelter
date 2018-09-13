package petShelter;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

public class PetShelterTest {

	@Test
	public void shouldAddAPet() {
		PetShelter underTest = new PetShelter();
		underTest.addPet(new VirtualPet("Boris", "A mean-looking character"));
		Collection <VirtualPet> pets = underTest.getAllPets();
		assertEquals(1, pets.size());
	}
	
	
	
	
	
	
	
	
}
