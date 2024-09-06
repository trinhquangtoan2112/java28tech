package ultil;

public class NumberUntil {
       public static Boolean isNumber(String Value) {
    	   try {
			Long number = Long.parseLong(Value);
			
		} catch (NumberFormatException e) {
			return false;
		}
    	   return true;
       }
}
