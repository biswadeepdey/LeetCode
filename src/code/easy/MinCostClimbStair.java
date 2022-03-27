package code.easy;

public class MinCostClimbStair {
	public int minCostClimbingStairs(int[] cost) {
		int[] jump = new int[cost.length];
        int n = cost.length;
        for(int i = n - 1; i >= 0; i--)
        {
            int costAtIp1 = cost[i] + ((i + 1 < n) ? jump[i + 1] : 0);
            int costAtIp2 = cost[i] + ((i + 2 < n) ? jump[i + 2] : 0);
            jump[i] = Integer.min(costAtIp1,costAtIp2);
        }
        
        return jump[0] < jump[1] ? jump[0] : jump[1];
    }
}
