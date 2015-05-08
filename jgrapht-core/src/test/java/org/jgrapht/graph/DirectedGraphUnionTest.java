/**
* DirectedGraphUnion Test
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


public class DirectedGraphUnionTest
{

        
    //Test functionality of DirectedGraphUnion with WeightCombiner
    @Test
    public void testDirectedGraphUnionWCombiner()
    {
    
    DirectedGraph<String, Integer> one = new SimpleDirectedGraph<String, Integer>(Integer.class);                

    DirectedGraph<String, Integer> two = new SimpleDirectedGraph<String, Integer>(Integer.class);

        String vertex1 = "1";
        String vertex2 = "2";

    one.addVertex(vertex1);
    two.addVertex(vertex2);

    DirectedGraph<String, Integer> test = new DirectedGraphUnion(one, two, WeightCombiner.SUM);

    assertEquals(test.containsVertex(vertex1), true);
    assertEquals(test.containsVertex(vertex2), true);
    }   

    //Test functionality of DirectedGraphUnion
    @Test
    public void testDirectedGraphUnion()
    {
    
    DirectedGraph<String, Integer> one = new SimpleDirectedGraph<String, Integer>(Integer.class);                

    DirectedGraph<String, Integer> two = new SimpleDirectedGraph<String, Integer>(Integer.class);

        String vertex1 = "1";
        String vertex2 = "2";

    one.addVertex(vertex1);
    two.addVertex(vertex2);

    DirectedGraph<String, Integer> test = new DirectedGraphUnion(one, two);

    assertEquals(test.containsVertex(vertex1), true);
    assertEquals(test.containsVertex(vertex2), true);
    }

    //Test inDegreeOf
    @Test
    public void testInDegreeOf()
    {
        DirectedGraph<String, Integer> first = new SimpleDirectedGraph<String, Integer>(Integer.class);                

        DirectedGraph<String, Integer> second = new SimpleDirectedGraph<String, Integer>(Integer.class);

        String vertex1 = "1";
        String vertex2 = "2";
    String vertex3 = "3";
    String vertex4 = "4";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
    first.addVertex(vertex3);
    second.addVertex(vertex4);

    Integer one = 1;
        Integer two = 2;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);

        DirectedGraph<String, Integer> g = new DirectedGraphUnion(first, second);

        assertEquals(g.inDegreeOf(vertex1), 2);
    }

    //Test outDegreeOf
    @Test
    public void testOutDegreeOf()
    {
        DirectedGraph<String, Integer> first = new SimpleDirectedGraph<String, Integer>(Integer.class);                

        DirectedGraph<String, Integer> second = new SimpleDirectedGraph<String, Integer>(Integer.class);

        String vertex1 = "1";
        String vertex2 = "2";
    String vertex3 = "3";
    String vertex4 = "4";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
    first.addVertex(vertex3);
    second.addVertex(vertex4);

    Integer one = 1;
        Integer two = 2;
        
        first.addEdge(vertex1, vertex2, one);
        first.addEdge(vertex1, vertex3, two);

        DirectedGraph<String, Integer> g = new DirectedGraphUnion(first, second);

        assertEquals(g.outDegreeOf(vertex1), 2);
    }

    //Test incomingEdgesOf
    @Test
    public void testIncomingEdgesOf()
    {
        DirectedGraph<String, Integer> first = new SimpleDirectedGraph<String, Integer>(Integer.class);                

        DirectedGraph<String, Integer> second = new SimpleDirectedGraph<String, Integer>(Integer.class);

    Set<Integer> edgeSet;

        String vertex1 = "1";
        String vertex2 = "2";
    String vertex3 = "3";
    String vertex4 = "4";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
    first.addVertex(vertex3);
    second.addVertex(vertex4);

    Integer one = 1;
        Integer two = 2;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);

        DirectedGraph<String, Integer> g = new DirectedGraphUnion(first, second);

        edgeSet = g.incomingEdgesOf(vertex1);

        assertEquals(edgeSet.size(),2);

        edgeSet = g.incomingEdgesOf(vertex4);

        assertEquals(edgeSet.size(),0);
    }

    //Test outgoingEdgesOf
    @Test
    public void testOutgoingEdgesOf()
    {
        DirectedGraph<String, Integer> first = new SimpleDirectedGraph<String, Integer>(Integer.class);                

        DirectedGraph<String, Integer> second = new SimpleDirectedGraph<String, Integer>(Integer.class);

    Set<Integer> edgeSet;

        String vertex1 = "1";
        String vertex2 = "2";
    String vertex3 = "3";
    String vertex4 = "4";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
    first.addVertex(vertex3);
    second.addVertex(vertex4);

    Integer one = 1;
        Integer two = 2;
        
        first.addEdge(vertex1, vertex2, one);
        first.addEdge(vertex1, vertex3, two);

        DirectedGraph<String, Integer> g = new DirectedGraphUnion(first, second);

        edgeSet = g.outgoingEdgesOf(vertex1);

        assertEquals(edgeSet.size(),2);

        edgeSet = g.outgoingEdgesOf(vertex4);

        assertEquals(edgeSet.size(),0);
    }
    
}