
public class Tiger extends Creature {
	private String name = super.getName();
	
	public Tiger(String n) {
		super(n);
	}
	public Tiger(){
		
	}

	public void move() {
		String className = getClass().getSimpleName();
		System.out.println(name + " " + className + " has just pounced");
	}
	
}
