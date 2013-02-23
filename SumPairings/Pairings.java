import java.util.*;
import java.io.*;

public class Pairings
{
	private int target;

	public Pairings()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			System.out.print("Enter int array(space-separated): ");
			String[] raw = br.readLine().split(" ");
			System.out.print("Enter target sum: ");
			target = Integer.parseInt(br.readLine());

			HashSet<Integer> intSet = new HashSet<Integer>();
			for(int i = 0; i < raw.length; i++)
			{
				Integer toAdd = new Integer(Integer.parseInt(raw[i]));
				if(intSet.contains(target - toAdd))
					System.out.println(target-toAdd + " " + toAdd);
				intSet.add(toAdd);
			}
		}
			catch(IOException e)
		{
			System.err.println("IO Exception: " + e);
		}
	}

	public static void main(String[] args)
	{
		Pairings instance = new Pairings();
	}
}
