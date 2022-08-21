package code.easy;

import java.util.*;
public class ValidParenthesesClass {
	public static boolean ValidParentheses(String s)
	{
		if(s.length() == 1 || s.length() % 2 != 0)
		{
			return false;
		}
		
		Stack<String> st = new Stack<String>();
		for(String ch : s.split("") )
		{
			if(!st.empty() && 
					((ch.equals(")") && st.peek().equals("(")) || 
					(ch.equals("}") && st.peek().equals("{")) || 
					(ch.equals("]") && st.peek().equals("[")))
			)
			{
				st.pop();
			}
			else
			{
				st.push(ch);
			}
		}
		
		return st.size() == 0;
	}
}
