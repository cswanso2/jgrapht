/**
* UnmodifiableUndirectedGraph Test
*
* Author: Brandon Holland
*
*
*/

package org.jgrapht.graph;

import java.util.*;

import org.jgrapht.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class UnmodifiableUndirectedGraphTest
{

        @Test (expected = UnsupportedOperationException.class)
        public void testUndirectedGraphBuilder()
        {
		UndirectedGraph<String, DefaultEdge> test = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);                

		UndirectedGraph<String, DefaultEdge> g = new UnmodifiableUndirectedGraph(test);

                String vertex1 = "1";

		g.addVertex(vertex1);
        }
    
}