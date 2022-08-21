package code.medium;
import java.util.*;

public class CourseScheduleII {
	private static boolean hasCycle(int node, Vector<List<Integer>> adjList)
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty())
		{
			Integer i = stack.pop();
			List<Integer> entries = adjList.get(i);
			if(entries != null)
			{
				for(Integer iEntry : entries)
				{
					if(stack.contains(iEntry))
					{
						return true;
					}
					stack.push(iEntry);
				}
			}
		}
		
		return false;
	}
	
	public static boolean findOrder(int numCourses, int[][] prerequisites) {
        Vector<List<Integer>> adjList = new Vector<>();
        int[] inboundCount = new int[numCourses];
        
        int firstNode = -1;
        
        adjList.setSize(numCourses);
        
        for(int i = 0; i < prerequisites.length; i++)
        {
        	// prerequisites[i][1] => from node
        	int index = prerequisites[i][1];
        	List<Integer> adjEntry = adjList.get(index);
        	if(adjEntry == null)
        	{
        		ArrayList<Integer> entry = new ArrayList<>();
        		entry.add(prerequisites[i][0]);
        		adjList.set(prerequisites[i][1], entry);
        		if(firstNode == -1)
        		{
        			firstNode = prerequisites[i][1];
        		}
        	}
        	else
        	{
        		adjEntry.add(prerequisites[i][0]);
        		adjList.set(prerequisites[i][1], adjEntry);
        	}
        	
        	inboundCount[prerequisites[i][0]]++;
        }
        
        if(hasCycle(firstNode, adjList))
        {
        	return true;
        }
        
        return false;
    }
}
