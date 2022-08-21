package code.easy;

public class BuySellStock {
	public int maxProfit(int[] prices) {
        int[] prevLow = new int[prices.length];
        int[] nextHi = new int[prices.length];
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for(int i = 0; i < prices.length; i++)
        {
            int j = prices.length - i - 1;
            if(prices[i] > low)
            {
                prevLow[i] = low;
            }
            else
            {
                prevLow[i] = prices[i];
                low = prices[i];
            }
            
            if(prices[j] < high)
            {
                nextHi[j] = high;
            }
            else
            {
                nextHi[j] = prices[j];
                high = prices[j];
            }
        }
        
        int result = 0;
        for(int i = 0; i < prices.length; i++)
        {
            if(prevLow[i] != -1 && nextHi[i] != -1)
            {
                result = Integer.max(result, nextHi[i] - prevLow[i]);
            }
        }
        
        return result;
    }
	
	public static void main(String[] args)
	{
		BuySellStock obj = new BuySellStock();
		System.out.println(obj.maxProfit(new int[] {2,4,1}));
	}
}
