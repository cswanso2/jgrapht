/**
* AsUndirectedGraph Test
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


public class AsUndirectedGraphHollandTest
{ 
    @Test (expected = UnsupportedOperationException.class)
    public void testAddEdge()
    {
         DirectedGraph<String, Integer> directed = new SimpleDirectedGraph<String, Integer>(Integer.class);

         String v1 = "v1";
         String v2 = "v2";
         String v3 = "v3";

         Integer one = 1;

         directed.addVertex(v1);
         directed.addVertex(v2);
         directed.addEdge(v1,v2,one);

         AsUndirectedGraph g = new AsUndirectedGraph(directed);

         g.addEdge(v2,v3,one);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testInDegreeOf()
    {
         DirectedGraph<String, Integer> directed = new SimpleDirectedGraph<String, Integer>(Integer.class);

         String v1 = "v1";
         String v2 = "v2";
         String v3 = "v3";

         Integer one = 1;

         directed.addVertex(v1);
         directed.addVertex(v2);
         directed.addEdge(v1,v2,one);

         AsUndirectedGraph g = new AsUndirectedGraph(directed);

         g.inDegreeOf(v2);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testIncomingEdgesOf()
    {
         DirectedGraph<String, Integer> directed = new SimpleDirectedGraph<String, Integer>(Integer.class);

         String v1 = "v1";
         String v2 = "v2";
         String v3 = "v3";

         Integer one = 1;

         directed.addVertex(v1);
         directed.addVertex(v2);
         directed.addEdge(v1,v2,one);

         AsUndirectedGraph g = new AsUndirectedGraph(directed);

         g.incomingEdgesOf(v2);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testOutDegreeOf()
    {
         DirectedGraph<String, Integer> directed = new SimpleDirectedGraph<String, Integer>(Integer.class);

         String v1 = "v1";
         String v2 = "v2";
         String v3 = "v3";

         Integer one = 1;

         directed.addVertex(v1);
         directed.addVertex(v2);
         directed.addEdge(v1,v2,one);

         AsUndirectedGraph g = new AsUndirectedGraph(directed);

         g.outDegreeOf(v2);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testOutgoingEdgesOf()
    {
         DirectedGraph<String, Integer> directed = new SimpleDirectedGraph<String, Integer>(Integer.class);

         String v1 = "v1";
         String v2 = "v2";
         String v3 = "v3";

         Integer one = 1;

         directed.addVertex(v1);
         directed.addVertex(v2);
         directed.addEdge(v1,v2,one);

         AsUndirectedGraph g = new AsUndirectedGraph(directed);

         g.outgoingEdgesOf(v2);
    }
}