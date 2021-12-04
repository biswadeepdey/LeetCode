package code.nodes;

import java.util.*;

public class DirectedGraph<T> {
	private int vertices;
	private int edges;
	private Map<T, GListNode<T>> adjList;
	private T headNode;
	private Set<T> visited;
	private Map<T, Integer> inbound;
	private Map<T, Integer> outbound;
	
	Queue<String> l;
	
	public DirectedGraph(int v)
	{
		vertices = v;
		adjList = new HashMap<T, GListNode<T>>();
		headNode = null;
		visited = new HashSet<T>();
		inbound = new HashMap<T, Integer>();
		outbound = new HashMap<T, Integer>();
	}
	
	public void addEdge(T start, T end)
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
		
		if(outbound.containsKey(start))
		{
			outbound.put(start, outbound.get(start)+ 1);
		}
		else
		{
			outbound.put(start, 1);
		}
		
		if(!inbound.containsKey(start))
		{
			inbound.put(start, 0);
		}
		
		if(inbound.containsKey(end))
		{
			inbound.put(end, inbound.get(end)+ 1);
		}
		else
		{
			inbound.put(end, 1);
		}
		
		if(!outbound.containsKey(end))
		{
			outbound.put(end, 0);
		}
		
		edges++;
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
	
	public void topologicalSort()
	{
		Map<T, Integer> inboundMap = inbound;
		T start = null;
		for(Map.Entry<T, Integer> entry: inboundMap.entrySet())
		{
			if(entry.getValue() == 0)
			{
				start = entry.getKey();
				break;
			}
		}
		
		Queue<T> queue = new ArrayDeque<T>();
		queue.add(start);
		
		while(!queue.isEmpty())
		{
			T point = queue.poll();
			System.out.println(point);
			
			GListNode<T> head = adjList.get(point);
			while(head != null)
			{
				T newPoint = head.val;
				int value = inboundMap.get(head.val);
				value--;
				if(value == 0)
				{
					queue.add(newPoint);
				}
				else
					inboundMap.put(newPoint, value);
				
				head = head.next;
			}
		}
		
	}
}
