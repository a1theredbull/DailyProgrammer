import java.io.*;
import java.util.*;

public class NonRepeatYearsScanner
{
	private int start, end, count;
	private HashSet<Integer> range;

	public NonRepeatYearsScanner(int start, int end)
	{
		count = 0;
		this.start = start;
		this.end = end;
		range = new HashSet<Integer>();

		//populate range of years
		for(int i = 0; i <= (end - start); i++)
			range.add(start+i);
		for(int year: range)
			if(isRepeat(year))
			{
				System.out.println(year);
				count++;
			}
		System.out.println("\nResult is: " + count);
	}

	private boolean isRepeat(int year)
	{
		String strYear = Integer.toString(year);
		char[] yearInChars = strYear.toCharArray();

		HashSet<Character> temp = new HashSet<Character>();
		for(char digit: yearInChars)
			if(!temp.add(digit)) return false;
		return true;
	}

	public static void main(String args[])
	{
		System.out.println("This program takes a range of years and finds the count of years" +
			" that do not have repeat digits (i.e. 2013 is counted but 2012 is not)");
		int start = 0, end = 0;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.println("Enter start year: ");
			start = Integer.parseInt(inFromUser.readLine());
			System.out.println("Enter end year: ");
			end = Integer.parseInt(inFromUser.readLine());
			if(start > end)
			{
				System.err.println("Invalid range. Start year must be less than end year.");
				System.exit(1);
			}
			inFromUser.close();
		}
		catch(NumberFormatException ex)
		{
			System.err.println("Invalid input.  Must be a valid year.");
			System.exit(1);
		}
		catch(IOException ex)
		{
			System.err.println("Failed to close reader.");
			System.exit(1);
		}

		NonRepeatYearsScanner NPYS = new NonRepeatYearsScanner(start, end);
	}
}