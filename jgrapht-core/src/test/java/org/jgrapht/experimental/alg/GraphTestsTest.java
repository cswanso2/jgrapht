/* ==========================================
 * JGraphT : a free Java graph-theory library
 * ==========================================
 *
 * Project Info:  http://jgrapht.sourceforge.net/
 * Project Creator:  Barak Naveh (http://sourceforge.net/users/barak_naveh)
 *
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */
/* -----------------------------
 * DefaultDirectedGraphTest.java
 * -----------------------------
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * Original Author:  Barak Naveh
 * Contributor(s):   -
 *
 * $Id$
 *
 * Changes
 * -------
 * 09-Aug-2003 : Initial revision (BN);
 *
 */
package org.jgrapht.graph;

import java.util.*;

import org.jgrapht.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.jgrapht.event.*;
import org.jgrapht.graph.builder.*;
import org.jgrapht.experimental.*;
import org.jgrapht.alg.*;

/**
 * A unit test for directed multigraph.
 *
 * @author Barak Naveh
 * @since Aug 9, 2003
 */
public class GraphTestsTest
{

    //~ Methods ----------------------------------------------------------------

    /**
 	* A TestSuite for the graph Tests
 	*
 	* @author Charles Swanson
 	* @since May 5th, 2015
 	*/

 	@Test
    public void testIsEmpty()
    {
    	
        UndirectedGraph<Integer, DefaultEdge> g = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        assertEquals(true, GraphTests.isEmpty(g) );
        int first = 1;
        g.addVertex(first);
        assertEquals(false, GraphTests.isEmpty(g) );
    }
    
    @Test
    public void testIsConnected()
    {
    	
        UndirectedGraph<Integer, DefaultEdge> g = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        int first = 1;
        int second = 2;
        int third = 3;
        g.addVertex(first);
        g.addVertex(second);
        g.addEdge(first, second);
        assertEquals(true, GraphTests.isComplete(g) );
        g.addVertex(third);
        assertEquals(false, GraphTests.isComplete(g) );
        g.addEdge(third, second);
        g.addEdge(first, third);
        assertEquals(true, GraphTests.isComplete(g) );
    }
    
    @Test
    public void isBipartite()
    {
    	//generate graph using PartiteGraph Generator than test if bipartite
        UndirectedGraph<Integer, DefaultEdge> g = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        int leftVertices = 4;
        int rightVertices = 5;
        int edges = 6;
		PartiteRandomGraphGenerator<Integer, DefaultEdge> gen = new PartiteRandomGraphGenerator<Integer, DefaultEdge>(leftVertices, rightVertices, edges);
		gen.generateGraph(g, new IntegerVertexFactory(), null);
		assertEquals(true, GraphTests.isBipartite(g) );
		//make non bipartite graph
		UndirectedGraph<Integer, DefaultEdge> h = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        int first = 1;
        int second = 2;
        int third = 3;
        h.addVertex(first);
        h.addVertex(second);
        h.addVertex(third);
        h.addEdge(first, second);
        h.addEdge(third, second);
        h.addEdge(first, third);
        assertEquals(false, GraphTests.isBipartite(h) );
    }

	@Test
    public void isComplete()
    {
		UndirectedGraph<Integer, DefaultEdge> g = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        int first = 1;
        int second = 2;
        int third = 3;
        g.addVertex(first);
        assertEquals(true, GraphTests.isComplete(g) );
        g.addVertex(second);
        assertEquals(false, GraphTests.isComplete(g) );
      	g.addEdge(first, second);
      	assertEquals(true, GraphTests.isComplete(g) );
        g.addVertex(third);
        g.addEdge(third, second);
        g.addEdge(first, third);
        int fourth = 4;
        g.addVertex(fourth);
        g.addEdge(third, fourth);
        assertEquals(false, GraphTests.isComplete(g) );
    }
    
    @Test
    public void isConnected()
    {
		UndirectedGraph<Integer, DefaultEdge> g = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        int first = 1;
        int second = 2;
        int third = 3;
        g.addVertex(first);
        assertEquals(true, GraphTests.isConnected(g) );
        g.addVertex(second);
        assertEquals(false, GraphTests.isConnected(g) );
      	g.addEdge(first, second);
      	assertEquals(true, GraphTests.isConnected(g) );
        g.addVertex(third);
        g.addEdge(third, second);
        assertEquals(true, GraphTests.isConnected(g) );
        g.addEdge(first, third);
        int fourth = 4;
        g.addVertex(fourth);
        assertEquals(false, GraphTests.isConnected(g) );
        g.addEdge(third, fourth);
        assertEquals(true, GraphTests.isConnected(g) );
    }
    

	private static class IntegerVertexFactory
        implements VertexFactory<Integer>
    {
        private int nextVertex = 0;

        @Override
        public Integer createVertex()
        {
            return nextVertex++;
        }
    }
    
    
}

// End DefaultDirectedGraphTest.java
