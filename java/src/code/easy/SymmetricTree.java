package code.easy;
import java.util.*;

class BreeNode {
    int val;
    BreeNode left;
    BreeNode right;
    BreeNode() {}
    BreeNode(int val) { this.val = val; }
    BreeNode(int val, BreeNode left, BreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree {
	public boolean isSymmetric(BreeNode root) {
        Queue<BreeNode> leftQ = new LinkedList<>();
        Queue<BreeNode> rightQ = new LinkedList<>();
        
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        
        leftQ.add(root.left);
        rightQ.add(root.right);
        
        while(!leftQ.isEmpty() && !rightQ.isEmpty())
        {
        	int lSize = leftQ.size();
        	int rSize = rightQ.size();
        	
        	if(lSize != rSize)
        	{
        		return false;
        	}
        	
        	while(lSize > 0)
        	{
        		BreeNode l = leftQ.poll();
        		BreeNode r = rightQ.poll();
        		
        		if(l.left != null)
        		{
        			leftQ.add(l.left);
        			leftList.add(l.left.val);
        		}
        		if(l.right != null)
        		{
        			leftQ.add(l.right);
        			leftList.add(l.right.val);
        		}
        		
        		if(r.right != null)
        		{
        			rightQ.add(r.right);
        			rightList.add(r.right.val);
        		}
        		if(r.left != null)
        		{
        			rightQ.add(r.left);
        			rightList.add(r.left.val);
        		}
        		
        	}
        }
        
        if(leftList.size() != rightList.size())
        {
        	return false;
        }
        
        for(int i = 0; i < rightList.size(); i++)
        {
        	if(leftList.get(i) != rightList.get(i))
        	{
        		return false;
        	}
        }
        
        return true;
    }
}
