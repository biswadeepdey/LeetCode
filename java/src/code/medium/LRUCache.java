package code.medium;
import java.util.*;

class Node implements Comparable<Node>{
	public int key;
	public long weight;
	
	public Node(int k, long w)
	{
		key = k;
		weight = w;
	}
	
	public int compareTo(Node n)
	{
		return Long.compare(weight, n.weight);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o == this)
			return true;
		
		Node n = (Node)o;
		return this.key == n.key;
	}
	
}

public class LRUCache {
	
//	HashMap<Integer, Integer> cache;
//	PriorityQueue<Node> lru;
//	int size;
//	
//	static long weightCounter = 0;
//	
//	public LRUCache(int capacity) {
//        size = capacity;
//        cache = new HashMap<>();
//        lru = new PriorityQueue<>();
//    }
//    
//    public int getOld(int key) {
//        Integer value = cache.get(key);
//        
//        if(value != null)
//        {
//        	lru.remove(new Node(key, weightCounter));
//            lru.add(new Node(key, ++weightCounter));
//        }
//        
//        return value == null ? -1 : value;
//    }
//    
//    public void putOld(int key, int value) {
//    	// already full
//        if(lru.size() == size)
//        {
//        	// if map already has key
//        	if(cache.get(key) != null)
//        	{
//        		lru.remove(new Node(key, weightCounter));
//        		lru.add(new Node(key, ++weightCounter));
//        		cache.put(key, value);
//        	}
//        	else
//        	{
//        		Node n = lru.poll();
//            	cache.remove(n.key);
//            	cache.put(key, value);
//            	lru.add(new Node(key, ++weightCounter));
//        	}
//        }
//        else
//        {
//        	// if map already has key
//        	if(cache.get(key) != null)
//        	{
//        		// means lru also has key, remove it
//        		lru.remove(new Node(key, weightCounter));
//        		cache.put(key, value);
//        		lru.add(new Node(key, ++weightCounter));
//        	}
//        	else
//        	{
//        		cache.put(key, value);
//        		lru.add(new Node(key, ++weightCounter));
//        	}
//        }
//    }
    HashMap<Integer, DoubleLinkedListNode> map;
    int capacity;
    Cache cache;
    
    public LRUCache(int capacity)
    {
    	map = new HashMap<>();
    	this.capacity = capacity;
    	cache = new Cache();
    }
    
    public int get(int key)
    {
    	DoubleLinkedListNode node = map.get(key);
    	if(node == null)
    	{
    		return -1;
    	}
    	cache.updateCache(node);
    	return node.value;
    }
    
    public void put(int key, int value)
    {
    	DoubleLinkedListNode node = map.get(key);
    	if(node == null)
    	{
    		// new element, if already full
    		if(capacity == map.size())
    		{
    			node = cache.removeFromTail();
    			map.remove(node.key);
    		}
    		
    		node = new DoubleLinkedListNode(key, value);
			cache.putAtFirst(node);
			map.put(key, node);
    	}
    	else
    	{
    		node.value = value;
    		cache.updateCache(node);
    	}
    }
    
    public static void main(String[] args)
    {
    	LRUCache lRUCache = new LRUCache(2);
    	lRUCache.put(1, 1); // cache is {1=1}
    	lRUCache.put(2, 2); // cache is {1=1, 2=2}
    	System.out.println(lRUCache.get(1));    // return 1
    	lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    	System.out.println(lRUCache.get(2));    // returns -1 (not found)
    	lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    	System.out.println(lRUCache.get(1));    // return 4
    	System.out.println(lRUCache.get(3));    // return 4
    	System.out.println(lRUCache.get(4));    // return 4
    }
}

class DoubleLinkedListNode
{
	Integer key;
	Integer value;
	DoubleLinkedListNode previous;
	DoubleLinkedListNode next;
	
	public DoubleLinkedListNode(Integer key, Integer value)
	{
		this.key = key;
		this.value = value;
		previous = null;
		next = null;
	}
}

class Cache
{
	DoubleLinkedListNode head;
	DoubleLinkedListNode tail;
	int size;
	
	public Cache()
	{
		head = new DoubleLinkedListNode(0, 0);
		tail = new DoubleLinkedListNode(0, 0);
		head.next = tail;
		tail.previous = head;
	}
	
	public void putAtFirst(DoubleLinkedListNode node)
	{
		DoubleLinkedListNode temp = head.next;
		head.next = node;
		node.previous = head;
		temp.previous = node;
		node.next = temp;
	}
	
	public DoubleLinkedListNode removeFromTail()
	{
		DoubleLinkedListNode node = tail.previous;
		node.previous.next = node.next;
		node.next.previous = node.previous;
		return node;
	}
	
	public void updateCache(DoubleLinkedListNode node)
	{
		node.previous.next = node.next;
		node.next.previous = node.previous;
		putAtFirst(node);
	}
}
