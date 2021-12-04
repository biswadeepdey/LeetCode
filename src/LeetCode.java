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
		
		DirectedGraph<String> dg = new DirectedGraph<String>(5);
		dg.addEdge("A", "C");
		dg.addEdge("B", "A");
		dg.addEdge("B", "C");
		dg.addEdge("B", "E");
		dg.addEdge("C", "D");
		dg.addEdge("E", "C");
		
		dg.topologicalSort();
		System.out.println();
	}

}
