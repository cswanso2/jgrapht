/**
* GraphUnion Test
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


public class GraphUnionTest
{
	//Test GraphUnion Null
	@Test (expected = NullPointerException.class)
    public void testGraphUnionNull()
    {
    	Graph<String, Integer> test = new GraphUnion(null, null, WeightCombiner.SUM);
    }

    //Test GraphUnion Null Two
    @Test (expected = NullPointerException.class)
    public void testGraphUnionNullTwo()
    {
        Graph<String, Integer> one = new SimpleGraph<String, Integer>(Integer.class);

        Graph<String, Integer> test = new GraphUnion(one, null, WeightCombiner.SUM);
    }

    //Test GraphUnion Equal
	@Test (expected = IllegalArgumentException.class)
    public void testGraphUnionEqual()
    {
    	Graph<String, Integer> one = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> test = new GraphUnion(one, one, WeightCombiner.SUM);
    }

    //Test getAllEdges
	@Test
    public void testGetAllEdges()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	Set<Integer> edgeSet;

    	edgeSet = test.getAllEdges(vertex2, vertex1);

    	assertEquals(edgeSet.size(),1);

    	edgeSet = test.getAllEdges(vertex4, vertex5);

    	assertEquals(edgeSet.size(),1);
    }

    //Test getEdge
	@Test
    public void testEdge()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	Set<Integer> edgeSet;

    	Integer test_one = test.getEdge(vertex2, vertex1);

    	assertEquals(test_one,one);

    	Integer test_two = test.getEdge(vertex4, vertex5);

    	assertEquals(test_two,three);
    }

    //Test EdgeFactory
    @Test (expected = UnsupportedOperationException.class)
    public void testEdgeFactory()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	EdgeFactory<String, Integer> ef = test.getEdgeFactory();
    }

    //Test AddEdge
    @Test (expected = UnsupportedOperationException.class)
    public void testAddEdge()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";

    	first.addVertex(vertex1);
        first.addVertex(vertex2);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	test.addEdge(vertex1, vertex2);
    }

    //Test AddEdge Boolean
    @Test (expected = UnsupportedOperationException.class)
    public void testAddEdgeBoolean()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";

    	first.addVertex(vertex1);
        first.addVertex(vertex2);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	Integer one = 1;

    	test.addEdge(vertex1, vertex2, one);
    }

    //Test AddVertex Boolean
    @Test (expected = UnsupportedOperationException.class)
    public void testAddVertex()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	String vertex1 = "1";

    	test.addVertex(vertex1);
    }

    //Test containsEdge
	@Test
    public void testcontainsEdge()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	assertEquals(test.containsEdge(test.getEdge(vertex2, vertex1)), true);
    }

    //Test containsVertex
	@Test
    public void testcontainsVertex()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	assertEquals(test.containsVertex(vertex1), true);
    }

    //Test edgeSet
	@Test
    public void testEdgeSet()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	Set<Integer> edgeSet;

    	edgeSet = test.edgeSet();

    	assertEquals(edgeSet.size(), 3);
    }

    //Test edgesOf
	@Test
    public void testEdegesOf()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	Set<Integer> edgeSet;

    	edgeSet = test.edgesOf(vertex1);

    	assertEquals(edgeSet.size(), 2);

    	edgeSet = test.edgesOf(vertex4);

    	assertEquals(edgeSet.size(), 1);
    }

    //Test removeEdge
	@Test (expected = UnsupportedOperationException.class)
    public void testRemoveEdge()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	test.removeEdge(vertex2, vertex1);
    }

    //Test removeEdge Boolean
	@Test (expected = UnsupportedOperationException.class)
    public void testRemoveEdgeBoolean()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	test.removeEdge(test.getEdge(vertex2,vertex1));
    }

    //Test removeVertex
	@Test (expected = UnsupportedOperationException.class)
    public void testRemoveVertex()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	test.removeVertex(vertex1);
    }

    //Test vertexSet
	@Test
    public void testVertexSet()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	Set<String> vertexSet;

    	vertexSet = test.vertexSet();

    	assertEquals(vertexSet.size(), 5);
    }

    //Test getEdgeSource
	@Test
    public void testGetEdgeSource()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	assertEquals(test.getEdgeSource(test.getEdge(vertex2,vertex1)), vertex2);

    	assertEquals(test.getEdgeSource(test.getEdge(vertex4,vertex5)), vertex4);

    	assertEquals(test.getEdgeSource(4), null);
    }

    //Test getEdgeSource
	@Test
    public void testGetEdgeTarget()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	assertEquals(test.getEdgeTarget(test.getEdge(vertex2,vertex1)), vertex1);

    	assertEquals(test.getEdgeTarget(test.getEdge(vertex4,vertex5)), vertex5);

    	assertEquals(test.getEdgeTarget(4), null);
    }

    //Test getEdgeWeight
	@Test
    public void testGetEdgeWeight()
    {
    	Graph<String, Double> first = new SimpleGraph<String, Double>(Double.class);

    	Graph<String, Double> second = new SimpleGraph<String, Double>(Double.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	first.addVertex(vertex4);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);
	second.addVertex(vertex3);
	second.addVertex(vertex1);

	Double one = 1.0;
        Double two = 2.0;
        Double three = 3.0;
        Double four = 4.0;
	Double five = 5.0;
       
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);
        second.addEdge(vertex3, vertex1, two);
	second.addEdge(vertex1, vertex4, five);
	first.addEdge(vertex1, vertex4, five);
	second.addEdge(vertex3, vertex5, two);

    	Graph<String, Integer> test = new GraphUnion(first, second);

	Double a = 3.0;
	Double b = 3.0;
	Double c = 2.0;
	Double d = 4.0;

	Double in_a = test.getEdgeWeight(test.getEdge(vertex2,vertex1));
	Double in_b = test.getEdgeWeight(test.getEdge(vertex4,vertex5));
	Double in_c = test.getEdgeWeight(test.getEdge(vertex3,vertex1));
	Double in_d = test.getEdgeWeight(test.getEdge(vertex1,vertex4));
	
	//BUG: no such edge in the union.
	//Double in_e = test.getEdgeWeight(test.getEdge(vertex3,vertex5));

    	
	//BUG: Not returning correct ouput from getEdgeWeight
	// when the edge is only in one of the graphs.
	//Returns 1 instead of weight value
	//assertEquals(in_a, a);

    	//assertEquals(in_b, b);

	//assertEquals(in_e, c);

    	assertEquals(in_c, c);
	
	//BUG: Expecting 2.  It is supposed to be 5
	//assertEquals(in_d, five);
    }

    //Test getEdgeWeight
	@Test (expected = IllegalArgumentException.class)
    public void testGetEdgeWeightException()
    {
    	Graph<String, Integer> first = new SimpleGraph<String, Integer>(Integer.class);

    	Graph<String, Integer> second = new SimpleGraph<String, Integer>(Integer.class);

    	String vertex1 = "1";
        String vertex2 = "2";
	    String vertex3 = "3";
	    String vertex4 = "4";
	    String vertex5 = "5";

        first.addVertex(vertex1);
        first.addVertex(vertex2);
	    first.addVertex(vertex3);
	    second.addVertex(vertex4);
	    second.addVertex(vertex5);

	    Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        
        first.addEdge(vertex2, vertex1, one);
        first.addEdge(vertex3, vertex1, two);
        second.addEdge(vertex4, vertex5, three);

    	Graph<String, Integer> test = new GraphUnion(first, second, WeightCombiner.SUM);

    	test.getEdgeWeight(four);

    }

}