
public class Ant extends Creature {
	private String name = super.getName();
	
	public Ant(String n){
		super(n);
	}
	
	public Ant(){
		
	}
	
	public void move() {
		String className = getClass().getSimpleName();
		System.out.println(name + " " + className + ", is crawling around");
	}
}
