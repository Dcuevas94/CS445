
public abstract class Creature extends Thing {
	public String className = getClass().getSimpleName();
	public Thing thingName;
	public String ate ="";
	String name = super.getName();
	
	public Creature(String n){
		super(n);
	}
	
	public Creature(){
		super.setName("Creature");
	}
	
	public void eat(Thing aThing){
		thingName = aThing;
		ate = thingName.getClass().getSimpleName();
		String name = super.getName();
		System.out.println(name + " has just eaten a " + ate);
	}
	
	public abstract void move();
	
	public void whatDidYouEat(){
		if(ate.equals("")){
			System.out.println(name + " " + className + " has had nothing to eat!");
		} else {
			System.out.println(name + " " + className + " has eaten a " + ate + "!");
		}
	}
}
