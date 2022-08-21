package code.exercise;

import java.util.Collections;
import java.util.PriorityQueue;

class TrieNode
{
	boolean endOfWord;
	TrieNode[] children;
	
	public TrieNode()
	{
		endOfWord = false;
		children = new TrieNode[26];
		
	}
}

class Trie {
	TrieNode root;
	public Trie()
	{
		root = new TrieNode();
	}
	
	public void insert(String word)
	{
		TrieNode node = root;
		for(char c : word.toCharArray())
		{
			if(node.children[c - 'a'] == null)
			{
				node.children[c - 'a'] = new TrieNode();
			}
			
			node = node.children[c - 'a'];
		}
		
		node.endOfWord = true;
	}
	
	public boolean search(String word)
	{
		if(root == null)
			return false;
		
		TrieNode node = root;
		for(char c : word.toCharArray())
		{
			node = node.children[c - 'a'];
			if(node == null)
			{
				break;
			}
		}
		return node == null ? false : node.endOfWord;
	}
}

public class TrieTutorial {
	public static void main(String[] args)
	{
		Trie t = new Trie();
		t.insert("biswadeep");
		t.insert("biswas");
		t.insert("cat");
		t.insert("bidirectional");
		t.insert("bidirected");
		t.insert("alcohol");
		System.out.println(t.search("bidirect"));
		System.out.println(t.search("green"));
		System.out.println(t.search("alcohol"));
		System.out.println(t.search("biswas"));
	}
}
