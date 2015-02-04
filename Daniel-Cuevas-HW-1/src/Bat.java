
public class Bat extends Creature implements Flyer {
	private String name = super.getName();
	public Thing thingName;
	public String ate ="";
	
	public Bat(String n){
		super(n);
	}
	
	public Bat(){
		
	}
	
	public void eat(Thing aThing){
		thingName = aThing;
		ate = thingName.getName();
		String batClass = getClass().getSimpleName();
		String className = thingName.getClass().getSimpleName();
		String superClassName = thingName.getClass().getSuperclass().getSimpleName();
		
		if(className.equals("Thing")){
			System.out.println(name + " " + batClass + " won't eat a " + ate);
		} else if (superClassName.equals("Creature")){
			super.eat(aThing);
		} else System.out.println("The " + name + " is silent and does not eat: " + ate);
	}
	
	public void fly() {
		String className = getClass().getSimpleName();
		System.out.println(name + " " + className + " is swooping through the dark");
	}
	
	public void move(){
		fly();
	}
}
