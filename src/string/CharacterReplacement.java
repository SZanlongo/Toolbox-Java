package string;

public class CharacterReplacement {

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println(replace("asylum", 'a', 'X'));
    }
    
    //replace characters in string with a new char
    public static String replace(String str, char ch, char rep) {
	String temp = str;										//temp string that will be manipulated
	String newString = str;										//string that will be returned
	for (int i = 0; i < temp.length(); i++) {							//iterate through string
	    if (temp.charAt(i) == ch) {									//check if character matches
		newString = newString.substring(0, i) + rep + temp.substring(i + 1, temp.length());	//generate new string with replacement char
	    }
	}
	return newString;
    }

}
