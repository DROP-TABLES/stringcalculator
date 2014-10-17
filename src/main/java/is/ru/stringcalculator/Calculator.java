package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text){
		String delimeter = ",";
		//are we adding a new delimeter
		if(text.startsWith("//")){
			// set delimeter to the third char in string
			delimeter = GetDelimeter(text);
			text = text.substring(text.indexOf('\n')+1);
		}
		
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(delimeter)
			|| text.contains("\n")){
			return sum(splitNumbers(text, delimeter));
		}
		else
			return 1;
	}
	
	private static String GetDelimeter(String text){
		if(text.charAt(2) == '['){
			return text.substring(3, text.indexOf(']', 3));
		}else{
			return String.valueOf(text.charAt(2));
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimeter){
	    return numbers.split("\\Q" + delimeter + "\\E"  + "|\\n");
	}
      
    private static int sum(String[] numbers){
	int total = 0;
	int index = 0;
	int curr;
	boolean haveException = false;
	// if all numbers are > 0
	String[] exceptionNums = new String[numbers.length];
        for(String number : numbers){
		    curr = toInt(number);
		    if(curr < 0){
			exceptionNums[index] = number;	
			index++;
			haveException = true;
		    }
		    if(curr <= 1000){
			total += toInt(number);
		    }
	}
	if(haveException){
		String message = "Negatives not allowed: " + exceptionNums[0];
		for(int i = 1; i < index; i++){
			message = message + "," + exceptionNums[i];
		}
	}
	return total;
    }
}
