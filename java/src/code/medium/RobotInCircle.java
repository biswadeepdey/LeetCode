package code.medium;

public class RobotInCircle {
	public static boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        char dir = 'N';
        
        for(int i = 0; i < instructions.length(); i++)
        {
            if(instructions.charAt(i) == 'G')
            {
                if(dir == 'N') y++;
                else if(dir == 'E') x++;
                else if(dir == 'S') y--;
                else if(dir == 'W') x--;
            }
            else if(instructions.charAt(i) == 'L')
            {
                if(dir == 'N') dir = 'W';
                else if(dir == 'E') dir = 'N';
                else if(dir == 'S') dir = 'E';
                else if(dir == 'W') dir = 'S';
            }
            else if(instructions.charAt(i) == 'R')
            {
                if(dir == 'N') dir = 'E';
                else if(dir == 'E') dir = 'S';
                else if(dir == 'S') dir = 'W';
                else if(dir == 'W') dir = 'N';
            }
            
            System.out.println(String.valueOf(dir));
        }
        
        return x == 0 && y == 0 || dir != 'N';
    }
	
	
	public static boolean isRobotBounded2(String instructions){
		int i=0;
        int j=0;
        int dir=1;
        
        for(char c : instructions.toCharArray()){  // Loop through to follow every instruction
            
            if(c == 'G'){
                if(dir == 1) j++;  //if direction is north, move forward
                else if(dir == 2) i++;  //if direction is East, move right
                else if(dir == 3) j--;  //if direction is South, move downward
                else i--;  //if direction is west, move West
            }
            else if(c == 'L'){  // if asked to turn left
                dir = dir == 1 ? 4 : dir-1; // subtract 1 from current direction to turn left, if  dir == 1 i.e. North, we need to turn towards west i.e. 4
            }
            else if(c == 'R'){ // if asked to turn right
                dir = dir == 4 ? 1 : dir+1;  // add 1 from current direction to turn right, if  dir == 4 i.e. West, we need to turn towards North i.e. 1
            }
            System.out.println(dir);
        }
        
        return i == 0 && j == 0 || dir > 1;
	}
}
