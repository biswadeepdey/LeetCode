package code.medium;
import java.util.*;

public class SumSubarrayMins {
	public int sumSubarrayMins(int[] arr) {
		Vector<Integer> vPrev = new Vector<>();
		Vector<Integer> vNext = new Vector<>();
        
        Stack<Integer> sPrev = new Stack<>();
		Stack<Integer> sNext = new Stack<>();
        
        int n = arr.length;
        
        vPrev.setSize(n);
        vNext.setSize(n);
        
		
        for(int i = 0; i < n; i++)
        {
            int j = n - i - 1;
            
            while(!sPrev.isEmpty() && arr[sPrev.peek()] >= arr[i]) sPrev.pop();
            if(sPrev.isEmpty())
                vPrev.set(i, -1);
            else
                vPrev.set(i, sPrev.peek());
            sPrev.push(i);
            
            while(!sNext.isEmpty() && arr[sNext.peek()] >= arr[j]) sNext.pop();
            if(sNext.isEmpty())
                vNext.set(j, -1);
            else
                vNext.set(j, sNext.peek());
            sNext.push(j);
        }
        
		
		int result = 0;
		int mod = (int)Math.pow(10, 9) + 7;
		
		for(int i = 0; i < n; i++)
		{
			int prev = vPrev.get(i);
			int next = vNext.get(i);
			
			if(prev == -1)
			{
				prev = i + 1;
			}
            else
            {
                prev = i - prev;
            }
			
			if(next == -1)
			{
				next = n - i;
			}
            else
            {
                next = next - i;
            }
			
			int contri = arr[i] * prev * next;
			result = (result + contri) % mod;
		}
		
		return result;
    }
	
	public int sumSubarrayMins2(int[] A) {
        int len = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i = 0; i < A.length; i++) {
            left[i] = i + 1;
            right[i] = len - i;
        }
        // previous less element
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        //next less element
        stack = new Stack<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) {
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        int ans = 0;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < len; i++) {
            ans = (ans + A[i] * left[i] * right[i]) % mod;
        }
        return ans;
    }
	
	public int sumSubarrayMins3(int[] arr) {
		Vector<Integer> vPrev = new Vector<>();
		Vector<Integer> vNext = new Vector<>();
        
        Stack<Integer> sPrev = new Stack<>();
		Stack<Integer> sNext = new Stack<>();
        
        int n = arr.length;
        
        vPrev.setSize(n);
        vNext.setSize(n);
        
		
        for(int i = 0; i < n; i++)
        {
            int j = n - i - 1;
            
            while(!sPrev.isEmpty() && arr[sPrev.peek()] >= arr[i]) sPrev.pop();
            if(sPrev.isEmpty())
                vPrev.set(i, -1);
            else
                vPrev.set(i, sPrev.peek());
            sPrev.push(i);
            
            while(!sNext.isEmpty() && arr[sNext.peek()] > arr[j]) sNext.pop();
            if(sNext.isEmpty())
                vNext.set(j, -1);
            else
                vNext.set(j, sNext.peek());
            sNext.push(j);
        }
        
		int result = 0;
		int mod = (int)Math.pow(10, 9) + 7;
		
		for(int i = 0; i < n; i++)
		{
			int prev = vPrev.get(i);
			int next = vNext.get(i);
			
			if(prev == -1)
			{
				prev = i + 1;
			}
            else
            {
                prev = i - prev;
            }
			
			if(next == -1)
			{
				next = n - i;
			}
            else
            {
                next = next - i;
            }
			
			result = (int)((result + ((long)arr[i] * prev * next)) % mod);
		}
		
		return result;
	}
}
