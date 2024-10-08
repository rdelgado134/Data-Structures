/* Richie Delgado
 * Data Structures 16786-FA2024
 * 9/11/2024
 */
import java.util.*;
public class ReverseText 
{
    
    // DO NOT MODIFY main!
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String s = scnr.nextLine();
      System.out.print(reverseText(s));
   
   }

   public static String reverseText(String arg)
   {
	   StringBuilder result = new StringBuilder();  //Create two string builder objects
	   StringBuilder temp = new StringBuilder();
	   char[] argArray = arg.toCharArray();			//Convert the String parameter into as char Array
	   for(int i = 0; i < argArray.length; i++)		// parse the charArray
	   {
		   if (!Character.isWhitespace(argArray[i]))//if not a white space add the char to our temp variable
		   {
			   temp.append(argArray[i]);
		   }
		   else										//else if temp is greater than 0, reverse temp, append to result,
		   {   										//make temp empty, append a space to result
			   if(temp.length() > 0)
			   {
				   temp.reverse();
				   result.append(temp);
	               temp.setLength(0); 
	     		   result.append(" ");
			   }
		   } 
	   }
	   if(temp.length() > 0) 					//Since the for loop ends at length, temp still has a word in the chamber so append to result
	   {
		   result.append(temp.reverse());
	   }
	   return result.toString();
   }

}
