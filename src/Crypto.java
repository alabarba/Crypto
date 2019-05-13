public class Crypto {
	
	public static void main (String args[]) {
		String prova= "Z.zz?ZZZ";
		int shift=1;
				
		System.out.println(prova + " is normalized into: " + normalizeText(prova) + " and is encrypted into: " + caesarify(normalizeText(prova), shift));
		
		//for input "I. like apples.." and shift -1 expected output "HKHJDZOOKDR"
		// for input ILIKEZOOS and shift 1 expected output JMJLFAPPT
		
	}
	
	public static String normalizeText(String s) {
		// remove all spaces
		s=s.replace(" ", "");
		// remove any of following chars . , : ; ’ ” ! ? ( ) 
		s=s.replace(".", "");
		s=s.replace(",", "");
		s=s.replace(":", "");
		s=s.replace(";", "");
		s=s.replace("’", "");
		s=s.replace("'", "");
		s=s.replace("\"", "");
		s=s.replace("”", "");
		s=s.replace("!", "");
		s=s.replace("?", "");
		s=s.replace(")", "");
		s=s.replace("(", "");
		
		// turn all lower case into upper case 
		s=s.toUpperCase();
		// System.out.println(s);
		return s;
	}

	
	public static String caesarify(String s, int n) {
		// System.out.println(shiftAlphabet(0));
		// System.out.println(shiftAlphabet(n));
		String r="";
		for(int i =0; i< s.length(); i++) {
			// System.out.print(s.charAt(i) + " to be replaced with: " + shiftAlphabet(n).charAt(shiftAlphabet(0).indexOf(s.charAt(i))));
			if (i==0){r=s.replace(s.charAt(0), shiftAlphabet(n).charAt(shiftAlphabet(0).indexOf(s.charAt(0))));}
			else {r=r.substring(0,i) + s.substring(i).replace(s.charAt(i), shiftAlphabet(n).charAt(shiftAlphabet(0).indexOf(s.charAt(i))));}
			//r=r.substring(0, i+1) + s.substring(i+1);
			// System.out.println(" => r.substring(0, i+1) is: " + r.substring(0, i+1)  + " s.substring(i+1) is:  " + s.substring(i+1) + "  =>  " + r);
			
			//for input "ILIKEAPPLES" and shift -1 expected output "HKHJDZOOKDR"
			// for input ILIKEZOOS and shift 1 expected output JMJLFAPPT
		}
	
		return r;
	}
	
	
	
	
	public static String shiftAlphabet(int shift) {
	    int start = 0;
	    if (shift < 0) {
	        start = (int) 'Z' + shift + 1;
	    } else {
	        start = 'A' + shift;
	    }
	    String result = "";
	    char currChar = (char) start;
	    for(; currChar <= 'Z'; ++currChar) {
	        result = result + currChar;
	    }
	    if(result.length() < 26) {
	        for(currChar = 'A'; result.length() < 26; ++currChar) {
	            result = result + currChar;
	        }
	    }
	    return result;
	}
}
