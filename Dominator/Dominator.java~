import java.util.Arrays;

/**
* Given an array, try to find if a single number dominates the others in the array.
* For example: [12, 85, 12, 92, 12, 12, 92] returns 12 because the number of 12s takes more than
* half of the array length.
*/

public class Dominator
{
	public static void main(String[] args)
	{
		Dominator dm = new Dominator();
		System.out.println(dm.find(new int[] {12, 85, 39, 12, 12, 12}));
		System.out.println(dm.find(new int[] {12, 85, 39, 5, 12, 12}));
		System.out.println(dm.find(new int[] {}));
		System.out.println(dm.find(new int[] {0, 1, 0, 0, 1}));
		System.out.println(dm.find(new int[] {0, 1, 0, 1, 0, 1, 1}));
		System.out.println(dm.find(new int[] {2, 3, 2, 2, 3, 3, 3}));
	}

	public int find(int[] list)
	{
		if(list.length == 0) return -1;

		Arrays.sort(list);
		// if a dominate number exists, it will be the median
		int medianIndex = list.length / 2;
		int count = 1;
		//count left from median
		for(int i = medianIndex-1; i >= 0; i--)
		{
			if(list[medianIndex] == list[i])
				count++;
			else
				break;
		}
		//count right from median
		for(int i = medianIndex+1; i < list.length; i++)
		{
			if(list[medianIndex] == list[i])
				count++;
			else
				break;
		}

		return count > medianIndex ? list[medianIndex] : -1;
	}
}
