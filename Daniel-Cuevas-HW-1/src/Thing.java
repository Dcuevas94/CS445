
public class Thing {
	private String name;
	
	public Thing(String n){
		name = n;
	}
	
	public Thing() {
		name = "Thing";
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		String className = getClass().getSimpleName();
		if (className.equals("Thing")) {
			return name;
		} else {
			return name + " " + className;
		}
	}
}
