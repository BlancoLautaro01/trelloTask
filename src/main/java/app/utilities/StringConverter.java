package app.utilities;

public class StringConverter {

	static public String urlString(String desc) {
		//Function was made to replase ' ' -> + for urls strings.
		
		String res = "";
		for(char i: desc.toCharArray()) {
			if(i == ' ') {
				res = res + "+";
			} else {
				res = res + i;
			}
		}
		
		return res;
	}
}
