import java.util.StringTokenizer;

public class ImprovedStringTokenizer extends StringTokenizer {

	public ImprovedStringTokenizer(String str) {
		super(str);
	}
	
	public ImprovedStringTokenizer(String s, String d){
		super(s,d);
	}
	public ImprovedStringTokenizer(String s, String d, boolean l){
		super(s,d,l);
	}
	public String[] TArray(){
		int n =0;
		String[] arr1 = new String[countTokens()];
		while(hasMoreTokens()){
			arr1[n]=nextToken();
			
		}
		return arr1;
	}

}
