package code.easy;


public class ImplementstrStrClass {

	public static int[] getKMPPiTable(String str)
	{
		int[] piTable = new int[str.length() + 1];
		
		int lastMatchedIndex = 1;
		
		for(int i = 2; i <= str.length(); i++)
		{
			if(str.charAt(i-1) == str.charAt(lastMatchedIndex - 1) )
			{
				piTable[i] = lastMatchedIndex;
				lastMatchedIndex++;
			}
			else if(str.charAt(i - 1) != str.charAt(lastMatchedIndex - 1))
			{
				lastMatchedIndex = 1;
				while(str.charAt(i - 1) == str.charAt(lastMatchedIndex - 1))
				{
					lastMatchedIndex++;
				}

				piTable[i] = lastMatchedIndex - 1;
			}
		}
		
		return piTable;
	}
	
	public static int ImplementstrStr(String haystack, String needle)
	{
		if(needle.length() == 0)
		{
			return 0;
		}
		
		int[] piTable = getKMPPiTable(needle);
		int j = 0;
		
		needle = " " + needle;

		for(int i = 0; i < haystack.length(); i++)
		{
			if(haystack.charAt(i) == needle.charAt((j + 1)))
			{
				j++;
				if(j + 1 == needle.length())
				{
					return i - j + 1;
				}
			}
			else
			{
				while(true)
				{
					if(haystack.charAt(i) != needle.charAt(j + 1))
					{
						if(j != 0)
						{
							j = piTable[j];
						}
						else
						{
							break;
						}
					}
					else
					{
						j++;
						break;
					}
				}
			}
		}
		
		return -1;
	}
}
