package code.nodes;

public class GListNode<T> {
	public T val;
	public GListNode<T> next;
	public GListNode<T> previous;
	
	public GListNode() {}
	public GListNode(T val) {this.val = val;}
	public GListNode(T val, GListNode<T> next) { this.val = val; this.next = next;}
}
