
public class Fly extends Creature implements Flyer {
	private String name = super.getName();
	public Thing thingName;
	public String ate ="";
	
	public Fly(String n){
		super(n);
	}
	
	public Fly(){
		
	}
	
	public void eat(Thing aThing){
		thingName = aThing;
		ate = thingName.getName();
		
		String className = thingName.getClass().getSimpleName();
		String superClassName = thingName.getClass().getSuperclass().getSimpleName();
		
		if(superClassName.equals("Creature")){
			System.out.println(name + " " + superClassName + " won't eat a " + ate);
		} else if (className.equals("Thing")){
			super.eat(aThing);
		} else System.out.println("......");
	}
	
	public void fly() {
		String className = getClass().getSimpleName();
		System.out.println(name + " " + className + " is buzzing around in flight");
	}
	
	public void move() {
		fly();
	}

}
