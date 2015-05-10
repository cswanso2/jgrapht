/**
* DirectedSubgraph Test
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


public class DirectedSubgraphTest
{
	@Test
	public void testInDegreeOf()
	{
		String v1 = "v1";
    	String v2 = "v2";
   		String v3 = "v3";
    	String v4 = "v4";
        String v5 = "v5";

    	Integer one = 1;
    	Integer three = 3;

    	DirectedGraph<String, Integer> init = new SimpleDirectedGraph<String, Integer>(Integer.class);

        init.addVertex(v1);
        init.addVertex(v2);
    	init.addVertex(v3);
    	init.addVertex(v4);
        init.addVertex(v5);

    	init.addEdge(v1, v2, one);
    	init.addEdge(v3, v4, one);
    	init.addEdge(v4, v5, three);

    	Set<String> vertexSet;
    	vertexSet = init.vertexSet();

    	Set<Integer> edgeSet;
    	edgeSet = init.edgeSet();

    	DirectedGraph<String, Integer> base = new SimpleDirectedGraph<String, Integer>(Integer.class);

    	base.addVertex(v2);
    	base.addVertex(v3);

        base.addEdge(v3,v2,one);

    	DirectedSubgraph<String, Integer> ds = new DirectedSubgraph<String, Integer>(base, vertexSet, edgeSet);

    	ds.addVertex(v2);
    	ds.addVertex(v3);

    	ds.addEdge(v3,v2,one);

    	assertEquals(ds.inDegreeOf(v2),1);
	}

    @Test
    public void testOutDegreeOf()
    {
        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";
        String v5 = "v5";

        Integer one = 1;
        Integer three = 3;

        DirectedGraph<String, Integer> init = new SimpleDirectedGraph<String, Integer>(Integer.class);

        init.addVertex(v1);
        init.addVertex(v2);
        init.addVertex(v3);
        init.addVertex(v4);
        init.addVertex(v5);

        init.addEdge(v1, v2, one);
        init.addEdge(v3, v4, one);
        init.addEdge(v4, v5, three);

        Set<String> vertexSet;
        vertexSet = init.vertexSet();

        Set<Integer> edgeSet;
        edgeSet = init.edgeSet();

        DirectedGraph<String, Integer> base = new SimpleDirectedGraph<String, Integer>(Integer.class);

        base.addVertex(v2);
        base.addVertex(v3);

        base.addEdge(v3,v2,one);

        DirectedSubgraph<String, Integer> ds = new DirectedSubgraph<String, Integer>(base, vertexSet, edgeSet);

        ds.addVertex(v2);
        ds.addVertex(v3);

        ds.addEdge(v3,v2,one);

        assertEquals(ds.outDegreeOf(v3),1);
    }
}