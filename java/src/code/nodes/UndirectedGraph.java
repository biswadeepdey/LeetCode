package code.nodes;

import java.util.*;

public class UndirectedGraph<T> {
	private int vertices;
	private int edges;
	private Map<T, GListNode<T>> adjList;
	private T headNode;
	private Set<T> visited;
	
	Queue<String> l;
	
	public UndirectedGraph(int v)
	{
		vertices = v;
		adjList = new HashMap<T, GListNode<T>>();
		headNode = null;
		visited = new HashSet<T>();
	}
	
	private void add(T start, T end, boolean incEdge)
	{
		if(adjList.containsKey(start))
		{
			GListNode<T> p = adjList.get(start);
			GListNode<T> prev = null;
			while(p != null)
			{
				prev = p;
				p = p.next;
			}
			
			p = new GListNode<T>(end);
			prev.next = p;
		}
		else
		{
			GListNode<T> list = new GListNode<T>(end);
			adjList.put(start, list);
			if(headNode == null)
			{
				headNode = start;
			}
		}
		
		if(incEdge)
		{
			edges++;
		}
		else
		{
			return;
		}
		
		if(start != end)
		{
			add(end, start, false);
		}
	}
	
	public void addEdge(T start, T end)
	{
		add(start, end, true);
	}
	
	public int getVertices()
	{
		return vertices;
	}
	
	public int getEdges()
	{
		return edges;
	}
	
	public void traverse()
	{
		Queue<T> queue = new ArrayDeque<T>();
		GListNode<T> p = adjList.get(headNode);
		
		queue.add(p.val);
		visited.add(p.val);
		
		while(!queue.isEmpty())
		{
			T q = queue.poll();
			System.out.println(q);
			
			GListNode<T> pList = adjList.get(q);
			while(pList != null)
			{
				if(!visited.contains(pList.val))
				{
					visited.add(pList.val);
					queue.add(pList.val);
				}
				pList = pList.next;
			}
		}
	}
}
