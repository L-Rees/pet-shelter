# Virtual Pet Shelter


I designed the pet shelter to be a way to track pets and their needs in the console, and not as a game per se, though it does implement the game loop and has some automated features.

The shelter starts by asking the user to admit a pet since there's nothing to do until there's at least one pet. The user must enter a name and a description for the pet, and hunger, thirst, and boredom variables if they wish.

The shelter checks for duplicate pet names to avoid overwriting an existing pet, and for valid hunger, thirst and boredom levels on a scale of 1-10. I chose a scale of 1-10 because there's not much difference between a hunger of 51 and a hunger of 57, for instance. The variables are just a way to gauge the relative needs of the animals. To this end I also created a visual representation of the levels with a scale so the user can tell at a glance which pets' needs are most critical. 

The user can feed and water all pets by selecting the option from the menu. An individual pet can be selected by name for play time.

After each interaction the shelter updates using the tick() method. The shelter will make suggestions for the next action based on the pets' hunger, thirst, and boredom levels. 

Pets can be adopted out of the shelter, removing them from the list of animals in the shelter and moving them to a list of adopted pets.

I tried to make the interface and display of pet names and stats as easy to understand as possible, given the project requirements of an app that runs in the console.