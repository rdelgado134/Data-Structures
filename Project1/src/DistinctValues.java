/* Richie Delgado
 * Data Structures 16786-FA2024
 * 9/11/2024
 */
import java.util.*;

public class DistinctValues 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		DistinctValues test1 = new DistinctValues(); //make an instance of our class
		int[] result = test1.distinctValues(scanner);//pass the Scanner input to distinctValues, return them to result
        System.out.println("Result: ");				 //placeholder for our result
        for (int value : result) 					 //for each element in result, if the value is not a 0 print 
        {
                System.out.print(value + " ");
        }
		scanner.close();
	}
	
	public int[] distinctValues(Scanner args) 
	{
		/*This method will take in an UNKNOWN number of integers from the user, but at most 10 will be distinct.
		 * The scanner stops reading when given -1.
		 * Will return an array sorted in ascending order.
		 */
		int[] result = new int[10]; //declare array of size 10
		int resultSize = 0;  		//size of our return array
		System.out.println("Please enter your desired integers, enter -1 to exit: ");	//prompt the user to enter the integers for their array
		
		while(resultSize < 10)
		{
			//check if its an integer
			int input = args.nextInt();	//assign the contents of args to input
			if(input == -1){break;}		//if user enters -1 break the loop and return result
			
			boolean duplicate = false; //flag for determining if input is a duplicate
			for(int j = 0; j < resultSize; j++) //parse through result array
			{
				if(result[j] ==input)			//if its a duplicate, flip the flag, exit the loop
				{
					duplicate = true;
					break;
				}
			}
			
			if(!duplicate && input != -1)	//if input is not a duplicate or -1 add it to result[], increment resultSize
			{
				result[resultSize] = input;
				resultSize++;
			}
			
		}
		//need to make a new array in case the array length is less than 10
		int[] exactResult = new int[resultSize];
		System.arraycopy(result, 0, exactResult,0, resultSize); //copy the elements of results starting at pos0 into exactResults starting at pos0, with resultSize being the length
		Arrays.sort(exactResult); //method from Arrays class that sorts the array in ascending order
		
		return exactResult;
	}	
}