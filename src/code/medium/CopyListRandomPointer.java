package code.medium;

class Tode
{
	int val;
    Tode next;
    Tode random;

    public Tode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListRandomPointer {
	public Tode copyRandomList(Tode head) {
        Tode pointer = head;
        
        while(pointer != null)
        {
            Tode copy = new Tode(pointer.val);
            Tode temp = pointer.next;
            pointer.next = copy;
            copy.next = temp;
            pointer = temp;
        }
        
        Tode newHead = head.next;
        
        pointer = head;
        while(pointer != null)
        {
            Tode copy = pointer.next;
            if(pointer.random != null)
            {
            	copy.random = pointer.random.next;
            }
            
            pointer = copy.next;
        }
        
        pointer = head;
        while(pointer != null)
        {
        	Tode copy = pointer.next;
        	Tode temp = copy.next;
        	copy.next = copy.next.next;
        }
        
        return newHead;
    }
	
	public static void main(String[] args)
	{
		Tode seven = new Tode(7);
		Tode thirteen = new Tode(13);
		Tode eleven = new Tode(11);
		Tode ten = new Tode(10);
		Tode one = new Tode(1);
		
		seven.next = thirteen;
		thirteen.next = eleven;
		eleven.next = ten;
		ten.next = one;
		
		thirteen.random = seven;
		eleven.random = one;
		ten.random = eleven;
		one.random = seven;
		
		CopyListRandomPointer obj = new CopyListRandomPointer();
		System.out.println(obj.copyRandomList(seven));
	}
}
