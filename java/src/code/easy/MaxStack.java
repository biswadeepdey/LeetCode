package code.easy;

import java.util.*;

class Node implements Comparable<Node> {
	int value;
	Node next;
	Node pre;
	
	public Node(int value, Node pre, Node next)
	{
		this.value = value;
		this.pre = pre;
		this.next = next;
	}
	
	@Override
	public int compareTo(Node o)
	{
		return o.value > this.value ? 1 : -1;
	}
}

public class MaxStack {
	Node head;
	PriorityQueue<Node> pq;
	
	public MaxStack() {
        this.head = null;
        pq = new PriorityQueue<>();
    }
    
    public void push(int x) {
		Node n = new Node(x, null, null);
    	if(head == null)
    	{
        	this.head = n;
    	}
    	else
    	{
    		head.pre = n;
    		n.next = head;
    		head = n;
    	}
    	pq.add(n);
    }
    
    public int pop() {
    	Node currHead = head;
    	if(head.next != null)
    	{
    		this.head.next.pre = head.pre;
    	}
    	Node temp = this.head.next;
		this.head.next = null;
		this.head = temp;
		
		pq.remove(currHead);
		return currHead.value;
    }
    
    public int top() {
        return this.head.value;
    }
    
    public int peekMax() {
        return pq.peek().value;
    }
    
    public int popMax() {
        Node n = pq.poll();
        
        Node pre = n.pre;
        Node next = n.next;
        
        if(pre != null) pre.next = next;
        if(next != null) next.pre = pre;
        
        if(head == n)
        {
        	head = next;
        }
        
        return n.value;
    }
}
