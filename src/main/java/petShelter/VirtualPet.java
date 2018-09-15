package petShelter;

public class VirtualPet {
	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int boredom;


	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getBoredom() {
		return boredom;
	}

	public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}
	
	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hunger = 3;
		this.thirst = 2;
		this.boredom = 1;
	}
	public void feed() {
		hunger -= 1;
		thirst += 1;
	}

	public void water() {
		thirst -= 1;

	}

	public void play() {
		boredom -= 1;
		thirst += 1;
	}

}
