class LongestPalindrome
{
	public static void main(String[] args)
	{
		LongestPalindrome lp = new LongestPalindrome("racecar");
		lp = new LongestPalindrome("racecar driver");
		lp = new LongestPalindrome("refeeeefer");
		lp = new LongestPalindrome("hello,palindromemordnilap find the longest palindrome");
		lp = new LongestPalindrome(".");
		lp = new LongestPalindrome("");
		lp = new LongestPalindrome("racecar+suparacecarapus-platypus");
	}
	
	public LongestPalindrome(String line)
	{
		if(line.isEmpty()) return;
		
		char[] chars = line.toCharArray();
		String longest = "";
		
		for(int i = 1; i < chars.length-1; i++)
		{
			int offset = detectCluster(chars, i);
			StringBuilder canindate = new StringBuilder("");
			int min = 0;
			int max = 0;
			
			if(offset > 0)
			{
				max = i + offset;
			}
			
			for(int j = 0; j < chars.length/2 + 1; j++)
			{
				if(i-j < 0 || i+offset+j > chars.length-1)
					break;

				if(chars[i-j] == chars[i+offset+j])
				{
					min = i - j;
					max = i + offset + j;
				}
				else
					break;
			}
			
			for(int j = min; j <= max; j++)
				canindate.append(chars[j]);
			
			if(canindate.length() > longest.length())
				longest = canindate.toString();
		}
		
		if(longest.isEmpty())
			System.out.println(chars[0]);
		else
			System.out.println(longest);
	}
	
	private int detectCluster(char[] chars, int start)
	{
		int result = 0;
		for(int i = start; i < chars.length; i++)
			if(chars[start] != chars[i])
			{
				result = i-start-1;
				break;
			}
		return result;
	}
}
