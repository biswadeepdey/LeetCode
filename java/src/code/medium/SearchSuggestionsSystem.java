package code.medium;
import java.util.*;

public class SearchSuggestionsSystem {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);
		
        List<List<String>> resultList = new ArrayList<>();
        
        List<String> actualList = new ArrayList<>(Arrays.asList(products));
        List<String> lastList = new ArrayList<>();
        
        for(int i = 1; i <= searchWord.length(); i++)
        {
        	String pattern = searchWord.substring(0, i);
        	List<String> currList = new ArrayList<>();
        	for(int j = 0; j < products.length - 1; j++)
        	{
        		List<String> searchList = (i == 0) ? actualList : lastList;
        		if(searchList.get(j).length() >= i && pattern.equals(searchList.get(j).substring(0, i)))
        		{
        			currList.add(searchList.get(j));
        		}
        	}
        	
        	lastList = currList;
        	
        	resultList.add(lastList.size() > 2 ? lastList.subList(0, 3) : lastList);
        }
        
        return resultList;
    }
}
