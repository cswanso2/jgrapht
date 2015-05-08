/**
* UndirectedGraphUnion Test
*
* Author: Brandon Holland
*
*
*/

package org.jgrapht.graph;

import java.util.*;

import org.jgrapht.*;

import org.jgrapht.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class UndirectedGraphUnionTest
{
    //Test functionality of UndirectedGraphUnion with WeightCombiner
    @Test
    public void testUndirectedGraphUnionWCombiner()
    {
    
        UndirectedGraph<String, DefaultEdge> one = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);                

        UndirectedGraph<String, DefaultEdge> two = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class); 

            String vertex1 = "1";
            String vertex2 = "2";

        one.addVertex(vertex1);
        two.addVertex(vertex2);

        UndirectedGraph<String, Integer> test = new UndirectedGraphUnion(one, two, WeightCombiner.SUM);

        assertEquals(test.containsVertex(vertex1), true);
        assertEquals(test.containsVertex(vertex2), true);
    }   

    //Test functionality of UndirectedGraphUnion
    @Test
    public void testUndirectedGraphUnion()
    {
    
        UndirectedGraph<String, DefaultEdge> one = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);                

        UndirectedGraph<String, DefaultEdge> two = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class); 

            String vertex1 = "1";
            String vertex2 = "2";

        one.addVertex(vertex1);
        two.addVertex(vertex2);

        UndirectedGraph<String, Integer> test = new UndirectedGraphUnion(one, two);

        assertEquals(test.containsVertex(vertex1), true);
        assertEquals(test.containsVertex(vertex2), true);
    }

    //Test functionality of degreeOf
    @Test
    public void testUndirectedGraphUnionDegreeOf()
    {
    
        UndirectedGraph<String, DefaultEdge> one = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);                

        UndirectedGraph<String, DefaultEdge> two = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class); 

            String vertex1 = "1";
            String vertex2 = "2";
            String vertex3 = "3";
        String vertex4 = "4";

        one.addVertex(vertex1);
        one.addVertex(vertex2);
        one.addVertex(vertex3);
        two.addVertex(vertex4);

        one.addEdge(vertex1, vertex2);
            one.addEdge(vertex1, vertex3);

        UndirectedGraph<String, Integer> test = new UndirectedGraphUnion(one, two);

        

        assertEquals(test.degreeOf(vertex1), 2);
    }
} 