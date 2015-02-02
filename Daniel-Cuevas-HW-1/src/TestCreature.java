
public class TestCreature {
	public static final int CREATURE_COUNT = 6;
	public static final int THING_COUNT = 10;
	
	public static void main(String[] args) {
		Creature creatureArray[] = new Creature[CREATURE_COUNT];
		creatureArray[0] = new Bat("Batty");
		creatureArray[1] = new Bat("Vamp");
		creatureArray[2] = new Ant("Antty");
		creatureArray[3] = new Fly("Wasp");
		creatureArray[4] = new Fly("Flyzzz");
		creatureArray[5] = new Tiger("Tiggggger");
		
		Thing thingArray[] = new Thing[THING_COUNT];
		thingArray[0] = new Thing("Thing 1");
		thingArray[1] = new Thing("Thing 2");
		thingArray[2] = new Thing("Thing 3");
		thingArray[3] = new Thing("Thing 4");
		thingArray[4] = creatureArray[0];
		thingArray[5] = creatureArray[1];
		thingArray[6] = creatureArray[2];
		thingArray[7] = creatureArray[3];
		thingArray[8] = creatureArray[4];
		thingArray[9] = creatureArray[5];
		
		System.out.println("Things:\n");
		
		for(int i = 0; i < THING_COUNT-6; i++){
			System.out.println(thingArray[i].toString());
		}
		
		System.out.println("\n");
		System.out.println("Creatures:\n");
		
		for(int j = 4; j < THING_COUNT; j++){
			System.out.println(thingArray[j].toString());
		}
		
		System.out.println("\n");
		
		System.out.println("Daniel Cuevas - CS 445\n\n");
		
		for(int m=4; m <THING_COUNT; m++){
			for(int n = THING_COUNT-1; n >= 4; n--){
				((Creature) thingArray[m]).eat(thingArray[n]);
			}
			((Creature) thingArray[m]).move();
			System.out.println("\n");
		}
		for(int k = 0; k < THING_COUNT; k++){
			((Creature) thingArray[7]).eat(thingArray[k]);
			((Creature) thingArray[7]).whatDidYouEat();
			((Creature) thingArray[8]).eat(thingArray[k]);
			((Creature) thingArray[8]).whatDidYouEat();
		}
	}
}
