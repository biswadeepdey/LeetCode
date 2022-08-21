package code.medium;

import java.util.*;

public class LetterCombinationsClass {
	
	Map<String, Set<String>> alphaMap;
	public LetterCombinationsClass()
	{
		alphaMap = new HashMap<String, Set<String>>();
		Set<String> aBets = new HashSet<String>();
		
		aBets.add("a");aBets.add("b");aBets.add("c");
		alphaMap.put("2", new HashSet<String>(aBets));
		aBets.clear();
		
		aBets.add("d");aBets.add("e");aBets.add("f");
		alphaMap.put("3", new HashSet<String>(aBets));
		aBets.clear();
		
		aBets.add("g");aBets.add("h");aBets.add("i");
		alphaMap.put("4", new HashSet<String>(aBets));
		aBets.clear();
		
		aBets.add("j");aBets.add("k");aBets.add("l");
		alphaMap.put("5", new HashSet<String>(aBets));
		aBets.clear();
		
		aBets.add("m");aBets.add("n");aBets.add("o");
		alphaMap.put("6", new HashSet<String>(aBets));
		aBets.clear();
		
		aBets.add("p");aBets.add("q");aBets.add("r");aBets.add("s");
		alphaMap.put("7", new HashSet<String>(aBets));
		aBets.clear();
		
		aBets.add("t");aBets.add("u");aBets.add("v");
		alphaMap.put("8", new HashSet<String>(aBets));
		aBets.clear();
		
		aBets.add("w");aBets.add("x");aBets.add("y");aBets.add("z");
		alphaMap.put("9", new HashSet<String>(aBets));
		aBets.clear();
	}
	
	public List<String> letterCombinations(String digits)
	{
		
		boolean isFirst = true;
		String[] digiArray = digits.split("");
		List<String> resultList = new LinkedList<String>();
		for(String digit : digiArray)
		{
			Set<String> aBets = alphaMap.get(digit);
			if(isFirst)
			{
				for(String ab : aBets)
				{
					resultList.add(ab);
				}
				
				isFirst = false;
			}
			else
			{
				List<String> newList = new LinkedList<String>();
				for(String combo : resultList)
				{
					for(String ab : aBets)
					{
						newList.add(combo + ab);
					}
				}
				
				resultList = newList;
			}
		}
		
		return resultList;
	}
	
	public static void main(String[] args)
	{
		LetterCombinationsClass lcc = new LetterCombinationsClass();
		for(String a : lcc.letterCombinations("234"))
		{
			System.out.print(a+" ");
		}
	}
}
