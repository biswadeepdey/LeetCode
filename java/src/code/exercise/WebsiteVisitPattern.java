package code.exercise;
import java.util.*;
class UserData implements Comparable<UserData>{
	String name;
	int time;
	String website;
	
	public UserData(String name, int time, String website)
	{
		this.name = name;
		this.time = time;
		this.website = website;
	}
	
	public int compareTo(UserData obj)
	{
		return Integer.compare(this.time, obj.time);
	}
}
public class WebsiteVisitPattern {
	
	Vector<Vector<String>> getCombination(Vector<String> websites)
	{
		Vector<Vector<String>> result = new Vector<>();
		if(websites.size() == 3)
		{
			result.add(websites);
			return result;
		}
		
		for(int i = 0; i < websites.size() - 2; i++)
		{
			for(int j = i + 1; j < websites.size() - 1; j++)
			{
				for(int k = j + 1; k < websites.size(); k++)
				{
					Vector<String> v = new Vector<>();
					v.add(websites.get(i));
					v.add(websites.get(j));
					v.add(websites.get(k));
					result.add(v);
				}
			}
		}
		
		return result;
	}
	
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Vector<UserData> dataList = new Vector<>();
        for(int i = 0; i < username.length; i++)
        {
        	UserData obj = new UserData(username[i], timestamp[i], website[i]);
        	dataList.add(obj);
        }
        
        Collections.sort(dataList);
        
        HashMap<String, Vector<String>> userWebMap = new HashMap<>();
        for(UserData user : dataList)
        {
        	Vector<String> webList = userWebMap.get(user.name);
        	if(webList == null)
        	{
        		Vector<String> newList = new Vector<String>();
        		newList.add(user.website);
        		userWebMap.put(user.name, newList);
        	}
        	else
        	{
        		webList.add(user.website);
        		userWebMap.put(user.name, webList);
        	}
        }
        
        HashMap<String, Vector<Vector<String>>> userComboMap = new HashMap<String, Vector<Vector<String>>>();
        for(Map.Entry<String, Vector<String>> userWeb : userWebMap.entrySet())
        {
        	Vector<Vector<String>> v = getCombination(userWeb.getValue());
        	userComboMap.put(userWeb.getKey(), v);
        }
        
        HashMap<String, Set<String>> comboCount = new HashMap<>();
        for(Map.Entry<String, Vector<Vector<String>>> data : userComboMap.entrySet())
        {
        	for(Vector<String> entry : data.getValue()) 
        	{
        		var list = entry.subList(0, entry.size());
        		String key = String.join("-", list);
        		Set<String> s =  comboCount.get(key) == null ? new HashSet<String>() : comboCount.get(key);
        		s.add(data.getKey());
        		comboCount.put(key, s);
        	}
        }
        
        int maxSize = Integer.MIN_VALUE;
        String output = "";
        for(Map.Entry<String, Set<String>> entry : comboCount.entrySet())
        {
        	if(entry.getValue().size() > maxSize)
        	{
        		maxSize = entry.getValue().size();
        		output = entry.getKey();
        	}
        	else if(entry.getValue().size() == maxSize)
        	{
        		output = output.compareTo(entry.getKey()) > 0 ? entry.getKey() : output;
        	}
        }
        
       return Arrays.asList(output.split("-"));
    }
	
	
	public static void main(String[] args)
	{
		WebsiteVisitPattern obj = new WebsiteVisitPattern();
		String[] username = new String[] {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
		int[] timestamp = new int[] {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
		String[] website = new String[] {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
		System.out.println(obj.mostVisitedPattern(username, timestamp, website));
	}
}
