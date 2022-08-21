package code.medium;
import java.util.*;


public class FlattenNestedList {
	public static void main(String args[] ) throws Exception {
		// Take input
		Scanner scanner = new Scanner(System.in);
		
		// How many test cases
		int testCaseCount = Integer.parseInt(scanner.nextLine());
		List<String[]> testCaseList = new ArrayList<>();
		
		// take test case input
		for(int i = 0; i < testCaseCount; i++)
		{
			String giftsToBuy = scanner.nextLine();
			String giftsAvailable = scanner.nextLine();
			String costOfGifts = scanner.nextLine();
			
			testCaseList.add(new String[] {giftsToBuy, giftsAvailable, costOfGifts});
		}
		
		// close scanner
		scanner.close();
		
		// find minimum amount for each test case
		for(String[] testCase : testCaseList)
		{
			long giftsToBuy = Long.parseLong(testCase[0]);
			int giftsAvailable = Integer.parseInt(testCase[1]);
			
			// if gifts to buy are greater or equals gifts available in shop, show amount of
			// all available gifts
			int minimumAmount = 0;
			if(giftsToBuy >= giftsAvailable)
			{
				String[] costOfGifts = testCase[2].split(" ");
				for(int i = 0; i < costOfGifts.length; i++)
				{
					minimumAmount += Integer.parseInt(costOfGifts[i]);
				}
			}
			else
			{
				String[] costOfGifts = testCase[2].split(" ");
				Arrays.sort(costOfGifts, (a, b)->{
					if(Integer.parseInt(a) > Integer.parseInt(b))
						return 1;
					else if(Integer.parseInt(a) < Integer.parseInt(b))
						return -1;
					else
						return 0;
				});
				
				for(int i = 0; i < giftsToBuy; i++)
				{
					minimumAmount += Integer.parseInt(costOfGifts[i]);
				}
			}
			
			System.out.println(minimumAmount);
		}
	}
}
