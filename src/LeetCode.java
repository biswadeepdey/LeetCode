import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import code.easy.*;
import code.medium.*;
import code.hard.*;
import code.nodes.*;

public class LeetCode {
	@Test
	public static void main(String[] args) {
//		AllOne allOne = new AllOne();
//		allOne.inc("a");
//		allOne.inc("b");
//		allOne.inc("b");
//		allOne.inc("b");
//		allOne.inc("b");
//		allOne.dec("b");
//		allOne.dec("b");
//		System.out.println(allOne.getMaxKey());
//		System.out.println(allOne.getMinKey());
		
		UndirectedGraph<String> ug = new UndirectedGraph<String>(4);
		ug.addEdge("A", "B");
		ug.addEdge("A", "C");
		ug.addEdge("A", "D");
		ug.addEdge("B", "C");
		ug.addEdge("D", "D");
		ug.traverse();
		System.out.println();
	}

}
