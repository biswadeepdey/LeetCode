package code.nodes;

import java.util.*;
import java.lang.*;

class Edge<T>{
	public T start;
	public T end;
	public Integer weight;
	
	public Edge(T start, T end) {this.start = start; this.end = end;}
	public Edge(T start, T end, Integer weight) {this.start = start; this.end = end; this.weight = weight;}
}

class CostVertex<T> implements Comparable<CostVertex<T>>
{
	public T name;
	public int cost;
	
	public CostVertex(T n, int c)
	{
		name = n;
		cost = c;
	}
	
	@Override
	public int compareTo(CostVertex<T> cv)
	{
		if(this.cost > cv.cost)
		{
			return 1;
		}
		
		if(this.cost < cv.cost)
		{
			return -1;
		}
		
		return 0;
	}
}

class CostVertexComparator<T> implements Comparator<CostVertex<T>>
{
	@Override
	public int compare(CostVertex<T> a, CostVertex<T> b)
	{
		if(a.cost > b.cost)
		{
			return 1;
		}
		
		if(a.cost < b.cost)
		{
			return -1;
		}
		
		return 0;
	}
}

public class DirectedGraph<T> {
	private Map<T, GListNode<T>> adjList;
	private T headNode;
	private Set<T> Vertices;
	private Map<T, Integer> inbound;
	private Map<T, Integer> outbound;
	private Map<String, Edge<T>> Edges;
	
	Queue<String> l;
	
	public DirectedGraph()
	{
		adjList = new HashMap<T, GListNode<T>>();
		headNode = null;
		Vertices = new HashSet<T>();
		inbound = new HashMap<T, Integer>();
		outbound = new HashMap<T, Integer>();
		Edges = new HashMap<String, Edge<T>>();
	}
	
	private void add(T start, T end, Integer weight)
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
		
		Vertices.add(start); Vertices.add(end);
		
		String key = start.toString() + "-" + end.toString();
		Edges.put(key, weight != null ? new Edge<T>(start, end, weight) : new Edge<T>(start, end));
	}
	
	public void addEdge(T start, T end)
	{
		add(start, end, null);
	}
	
	public void addEdge(T start, T end, int weight)
	{
		add(start, end, weight);
	}
	
	public int getvertexCount()
	{
		return Vertices.size();
	}
	
	public int getedgeCount()
	{
		return Edges.size();
	}
	
	public void traverse()
	{
		Queue<T> queue = new ArrayDeque<T>();
		GListNode<T> p = adjList.get(headNode);
		Set<T> visited = new HashSet<T>();
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
	
	public void showEdges()
	{
		for(Map.Entry<String, Edge<T>> entry: Edges.entrySet())
		{
			System.out.println(entry.getKey() + ": " + entry.getValue().start + ", " + entry.getValue().end + ", " + entry.getValue().weight);
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
	
	public void djikstra(T sourceName)
	{
		PriorityQueue<CostVertex<T>> pq = new PriorityQueue<CostVertex<T>>();
		Set<T> visited = new HashSet<T>();
		Map<T, Integer> mapDist = new HashMap<T, Integer>();
		
		Vertices.forEach(vertex -> {mapDist.put(vertex, Integer.MAX_VALUE);});
		
		// setting up the source with 0 cost
		pq.add(new CostVertex<T>(sourceName, 0));
		mapDist.put(sourceName, 0);
		
		while(pq.peek() != null)
		{
			CostVertex<T> cv = pq.poll();
			
			if(visited.contains(cv.name))
			{
				continue;
			}
			
			visited.add(cv.name);
			
			GListNode<T> cvAdjListPtr = adjList.get(cv.name);
			while(cvAdjListPtr != null)
			{
				int edgeCost = Edges.get(cv.name+"-"+cvAdjListPtr.val).weight;
				int currCost = mapDist.get(cvAdjListPtr.val);
				
				if(currCost > edgeCost + mapDist.get(cv.name))
				{
					currCost = edgeCost + mapDist.get(cv.name);
					mapDist.put(cvAdjListPtr.val, currCost);
				}
				
				if(!visited.contains(cvAdjListPtr.val))
				{
					pq.add(new CostVertex<T>(cvAdjListPtr.val, currCost));
				}
				
				cvAdjListPtr = cvAdjListPtr.next;
			}
		}
		
		
		for(Map.Entry<T, Integer> entry : mapDist.entrySet())
		{
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	}
	
	public void bellmanFord(T sourceName)
	{
		Map<T, Integer> costMap = new HashMap<T, Integer>();
		Vertices.forEach(v->costMap.put(v, Integer.MAX_VALUE));
		
		costMap.put(sourceName, 0);
		
		Queue<T> q = new LinkedList<T>();
		q.add(sourceName);
		
		while(!q.isEmpty())
		{
			T src = q.poll();
			GListNode<T> adjPtr = adjList.get(src);
			
			while(adjPtr != null)
			{
				T dest = adjPtr.val;
				int edgeCost = Edges.get(src+"-"+dest).weight;
				int srcCost = costMap.get(src);
				int destCost = costMap.get(dest);
				
				if(destCost > srcCost + edgeCost)
				{
					costMap.put(dest, srcCost + edgeCost);
					
					if(!q.contains(dest))
					{
						q.add(dest);
					}
				}
				
				adjPtr = adjPtr.next;
			}
		}
		
		for(Map.Entry<T, Integer> entry : costMap.entrySet())
		{
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	}
}
