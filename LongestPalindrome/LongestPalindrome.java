/* O(N^2) */
class LongestPalindrome
{
	public static void main(String[] args)
	{
		LongestPalindrome lp = new LongestPalindrome();
		
		lp.parse("racecar");
		lp.parse("racecar driver");
		lp.parse("refeeeefer");
		lp.parse("hello,palindromemordnilap find the longest palindrome");
		lp.parse(".");
		lp.parse("");
		lp.parse("a.");
		lp.parse("racecar+suparacecarapus-platypus");
		lp.parse("aa");
		lp.parse("aaa");
		lp.parse("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaad");
		lp.parse("baaaaaob");
		lp.parse("banana");
		lp.parse("a thisisapalindrome.....emordnilapasisiht");
	}
	
	public void parse(String line)
	{
		if(line.isEmpty())
		{
			System.out.println("");
			return;
		}
		
		char[] chars = line.toCharArray();
		String longest = "";
		
		for(int i = 0; i < chars.length-1; i++)
		{
			int clusterSize = detectCluster(chars, i);
			StringBuilder canindate = new StringBuilder("");
			int min = 0;
			int max = 0;
			
			if(clusterSize > 0)
				max = i + clusterSize;
			
			for(int j = 0; j < chars.length/2 + 1; j++)
			{
				if(i-j < 0 || i+clusterSize+j > chars.length-1)
					break;

				if(chars[i-j] == chars[i+clusterSize+j])
				{
					min = i - j;
					max = i + clusterSize + j;
				}
				else
					break;
			}
			
			if(max-min > longest.length())
			{
				for(int j = min; j <= max; j++)
					canindate.append(chars[j]);
				longest = canindate.toString();
			}

			//don't have to check other letters in same cluster
			i += clusterSize;
		}
		
		if(longest.isEmpty())
			System.out.println(chars[0]);
		else
			System.out.println(longest);
	}
	
	/* returns the number of sequential same chars from index start */
	private int detectCluster(char[] chars, int start)
	{
		int result = 0;
		for(int i = start+1; i < chars.length; i++)
		{	
			if(chars[start] != chars[i])
			{
				result = i-start-1;
				break;
			}
			else if(i == chars.length-1) //last case
				result = i-start;
		}
		return result;
	}
}
