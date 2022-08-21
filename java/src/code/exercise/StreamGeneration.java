package code.exercise;
import java.util.*;

class FamilyNode {
	List<FamilyNode> children;
	int generation;
	String name;
	
	public FamilyNode(String s, int i) {
		name = s;
		generation = i;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o)
		{
			return true;
		}
		
		FamilyNode fn = (FamilyNode)o;
		return this.name == fn.name;
	}
}

public class StreamGeneration {
	FamilyNode topOne;
	HashMap<String, FamilyNode> reportedMembers;
	
	public StreamGeneration()
	{
		topOne = null;
		reportedMembers = new HashMap<>();
	}
	
	public void updateGeneration(FamilyNode node, int generation)
	{
		node.generation = generation;
		reportedMembers.put(node.name, node);
		
		if(node.children != null)
		{
			for(FamilyNode child : node.children)
			{
				updateGeneration(child, generation + 1);
			}
		}
	}
	
	public void addRelation(String parent, String child)
	{
		// for the first time
		if(topOne == null)
		{
			FamilyNode parentNode = new FamilyNode(parent, 1);
			FamilyNode childNode = new FamilyNode(child, 2);
			parentNode.children = new LinkedList<>();
			parentNode.children.add(childNode);
			
			// report new members
			reportedMembers.put(parentNode.name, parentNode);
			reportedMembers.put(childNode.name, childNode);
			
			topOne = parentNode;
		}
		// if already reported parent
		else if(reportedMembers.get(parent) != null)
		{
			FamilyNode parentNode = reportedMembers.get(parent);
			FamilyNode childNode = new FamilyNode(child, parentNode.generation + 1);
			parentNode.children.add(childNode);
			
			// put the updated parent
			reportedMembers.put(parentNode.name, parentNode);
			
			// add child to reportedMembers
			reportedMembers.put(childNode.name, childNode);
		}
		// if newly reported parent
		else
		{
			FamilyNode childNode = reportedMembers.get(child);
			FamilyNode parentNode = new FamilyNode(parent, childNode.generation);
			parentNode.children = new LinkedList<>();
			parentNode.children.add(childNode);
			
			updateGeneration(childNode, parentNode.generation + 1);
			
			reportedMembers.put(parentNode.name, parentNode);
			
			if(topOne.equals(childNode))
			{
				topOne = parentNode;
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		StreamGeneration sg = new StreamGeneration();
		sg.addRelation("tom", "jerry");
		sg.addRelation("tom", "philip");
		sg.addRelation("alice", "tom");
		sg.addRelation("alice", "bob");
		sg.addRelation("papa", "bob");
		System.out.println(sg.topOne.name);
	}
}
