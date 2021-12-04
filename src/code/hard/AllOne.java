package code.hard;

import java.util.*;

public class AllOne {
	HashMap<String, Integer> map;
	TreeMap<Integer, Set<String>> treeMap;
	
	public AllOne()
	{
		map = new HashMap<String, Integer>();
		treeMap = new TreeMap<Integer, Set<String>>();
	}
	
	public void inc(String key)
	{
		int value;
		boolean presentAlready = false;
		if(map.containsKey(key))
		{
			presentAlready = true;
			value = map.get(key);
			value++;
		}
		else
		{
			value = 1;
		}
		
		map.put(key, value);
		
		if(presentAlready)
		{
			treeMap.get(value - 1).remove(key);
			if(treeMap.get(value - 1).size() == 0)
			{
				treeMap.remove(value - 1);
			}
		}
		
		if(treeMap.containsKey(value))
		{
			treeMap.get(value).add(key);
		}
		else
		{
			Set<String> s = new HashSet<String>();
			s.add(key);
			treeMap.put(new Integer(value), s);
		}
	}
	
	public void dec(String key)
	{
		int value;
		value = map.get(key);
		value--;
		
		if(value == 0)
		{
			map.remove(key);
			treeMap.get(value + 1).remove(key);
			if(treeMap.get(value + 1).size() == 0)
			{
				treeMap.remove(value + 1);
			}
			return;
		}
		else
		{
			map.put(key, value);	
		}
		
		treeMap.get(value + 1).remove(key);
		if(treeMap.get(value + 1).size() == 0)
		{
			treeMap.remove(value + 1);
		}
		
		if(treeMap.containsKey(value))
		{
			treeMap.get(value).add(key);
		}
		else
		{
			Set<String> s = new HashSet<String>();
			s.add(key);
			treeMap.put(new Integer(value), s);
		}
	}
	
	public String getMaxKey()
	{
		
		return map.size() == 0 ? "" : (String)treeMap.lastEntry().getValue().toArray()[0];
	}
	
	public String getMinKey()
	{
		return map.size() == 0 ? "" : (String)treeMap.firstEntry().getValue().toArray()[0];
	}
}
