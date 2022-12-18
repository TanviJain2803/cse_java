# animal simulation
Several classes in the starter code implement a graphical simulation of a 2D world with many animals moving around in it. You will write a set of classes that define the behavior of these animals. For each class, you are defining the unique behaviors for each animal.

The Critter World is divided into cells with integer coordinates. The world is 60 cells wide and 50 cells tall by default. The upper-left cell has x-coordinates and y-coordinates (0, 0). The x-coordinate increases to the right. The y-coordinate increases downwards.



NOTE: the following mechanics are already implemented in the Critter simulator, e.g. when two critters fight, the simulator decides who wins based on what the attack each critter uses. Your task for this assignment is to define behaviors for each critter. i.e. you just need to write the methods but don't need to call them.

You can run the simulator to test your critter implementations.

Movement
When it’s Critter A’s turn to move, the simulator will call A.getMove() to get a direction.

Each round, each Critter can move one square north, south, east, west, OR stay at its current location (i.e. center). The world has a finite size, but it wraps around in all four directions (for example, moving east from the right edge brings you back to the left edge).

Fighting
As the simulation runs, animals may collide by moving onto the same location. When two animals collide and they are from different species, they fight. The simulator will call getAttack() so that the critter fighting can select which attack to use.

The winning animal survives and the losing animal is removed from the game. Each animal chooses one of Attack.ROAR, Attack.POUNCE, Attack.SCRATCH, or Attack.FORFEIT as their attack mode. Each attack will have some other attack that it is stronger against (e.g. Roar beats Scratch). If an animal decides to Attack.FORFEIT, it will automatically lose the fight.

The following table summarizes the choices and which animal will survive in each case. To remember which beats which, notice that the starting letters of "Roar, Pounce, Scratch" match those of "Rock, Paper, Scissors." If the animals make the same choice, the winner is chosen with a coin flip.



The cases above are based on the following rules:

Critter #1 scratches and Critter #2 roars. Critter #2 survives.
Critter #1 roars and Critter #2 pounces. Critter #2 survives.
Critter #1 pounces and Critter #2 scratches. Critter #2 survives.
Critter #1 and Critter #2 use a same attack in [roar, pounce, scratch, forfeit]. One of them survives, chosen randomly.
Critter #1 uses an attack in [roar, pounce, scratch] while Critter #2 forfeits, Critter 1 survives.
Mating
If two animals of the same species collide, they "mate" to produce a baby. Animals are vulnerable to being attacked while mating, so any other animal that collides with them will defeat them both. An animal can mate only once during its lifetime. A “baby” will be spawned as a full adult next to its parents once they are finished mating.

The mating behavior is enforced by the simulator. However, when two critters mate, mate() will be called so that your critter knows it starts mating.

Eating and Sleep
The simulation world also contains food (represented by the period character ".") for the animals to eat. There are pieces of food on the world initially, and new food slowly grows into the world over time. As an animal moves, it may encounter food, in which case the simulator will ask your animal whether it wants to eat it. Different kinds of animals have different eating behavior: some always eat, and others only eat under certain conditions. Once an animal has eaten a few pieces of food, that animal will be put to "sleep" by the simulator for a small amount of time. During the sleeping period, the animal will automatically forfeit all fights, meaning it will lose to all other critters that attack it.

When a critter encounters food, the simulator will call eat() to ask whether the critter wants to eat or not.

The sleep behavior is enforced by the simulator. However, when a critter sleeps, sleep() will be called so that your critter knows it starts sleeping. Similarly, wakeup() will be called when your critter finishes its nap.

Scoring
The simulator keeps a score for each class of animal, shown on the right side of the screen. A class's score is based on how many animals of that class are alive, how much food they have eaten, and how many other animals they have defeated. Detailed formula below:

Score = 3 x Survivor + 3 x Killed_Opponents + 1 x Food_Eaten
