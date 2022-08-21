package code.medium;

import java.util.*;
import code.nodes.*;

//abstract class BNode {
//    public abstract int evaluate();
//    // define your fields here
//    BNode left;
//    BNode right;
//    String value;
//};

class ENode extends BNode {
	public int evaluate()
	{
		return evaluateExp(this);
	}
	
	private int evaluateExp(BNode root)
	{
		if(root.left == null && root.right == null)
		{
			return Integer.parseInt(root.value);
		}
		
		int left = evaluateExp(root.left);
		String operator = root.value;
		int right = evaluateExp(root.right);
		int result = 0;
		switch(operator)
		{
			case "+":
				result = left + right;
				break;
			case "-":
				result = left - right;
				break;
			case "*":
				result = left * right;
				break;
			case "/":
				result = left / right;
				break;
		}
		
		return result;
	}
	
	public ENode(String value)
	{
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public ENode(String value, ENode left, ENode right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class ExpressionTree {
	ENode root;
	Set<String> operatorSet;
	
	public ExpressionTree()
	{
		operatorSet = new HashSet<>();
		setupOperators();
	}
	
	private void setupOperators()
	{
		String[] operator = new String[] {"+", "-", "*", "/", "%"};
		for(String s : operator)
		{
			operatorSet.add(s);
		}
	}
	
	public BNode buildTree(String[] postfix) {
        Stack<ENode> stack = new Stack<>();
        
        for(int i = 0; i < postfix.length; i++)
        {
        	if(operatorSet.contains(postfix[i]))
        	{
        		ENode right = stack.pop();
        		ENode left = stack.pop();
        		
        		ENode exp = new ENode(postfix[i], left, right);
        		stack.push(exp);
        	}
        	else
        	{
        		stack.push(new ENode(postfix[i]));
        	}
        }
        
        root = stack.pop();
        return root;
    }
}
