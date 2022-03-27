package code.medium;

import java.util.*;

class NodeData implements Comparable<NodeData>{
    char value;
    int count;
    
    public NodeData(char c, int i)
    {
        value = c;
        count = i;
    }
    
    public int compareTo(NodeData n)
    {
        return Integer.compare(this.count, n.count);
    }
}

public class ReorganizeString {
	public String reorganizeString(String s) {
        PriorityQueue<NodeData> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> ele : map.entrySet())
        {
            pq.add(new NodeData(ele.getKey(), ele.getValue()));
        }
        
        String output = "";
        while(!pq.isEmpty())
        {
            NodeData masterNodeData = pq.poll();
            if(output.length() == 0 || output.charAt(output.length() -1) != masterNodeData.value)
            {
                output += masterNodeData.value;
                if(--masterNodeData.count > 0)
                {
                    pq.add(masterNodeData);
                }
            }
            else
            {
                NodeData secondNodeData = pq.poll();
                output += secondNodeData.value;
                if(--secondNodeData.count > 0)
                {
                    pq.add(secondNodeData);
                }
                pq.add(masterNodeData);
            }
        }
        
        return output;
    }
	
	public static void main(String[] args)
	{
		ReorganizeString obj = new ReorganizeString();
		System.out.println(obj.reorganizeString("aaaab"));
	}
}
