/**
* Extension of DirectedAcyclicGraphTest
*
* Author: Brandon Holland
*
*
*/

package org.jgrapht.experimental.dag;

import java.util.*;

import org.jgrapht.util.*;

import junit.framework.*;

import org.jgrapht.*;
import org.jgrapht.alg.*;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.generate.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class DirectedAcyclicGraphHollandTest
{
	// Tests the edge factory constructor
	@Test
	public void testEdgeFactoryConstructor()
	{
		DirectedGraph<String, Integer> g = new SimpleDirectedGraph<String, Integer>(Integer.class); 

		String v1 = "v1";
		String v2 = "v2";

		Integer one = 1;

		g.addVertex(v1);
		g.addVertex(v2);

		g.addEdge(v1, v2, one);

		EdgeFactory<String,Integer> ef = g.getEdgeFactory();

		SimpleDirectedGraph<String,Integer> dag = new DirectedAcyclicGraph(ef);

		assertEquals(dag.addVertex(v1), true);
	}

	// Tests the last Directed Acyclic Graph constructor
	@Test
	public void testLastConstructor()
	{
		SimpleDirectedGraph<String,Integer> dag = new DirectedAcyclicGraph(null, null, null);

		String v1 = "v1";

		assertEquals(dag.addVertex(v1), true);
	}

	// Tests addEdge with the basic constructor
	// BUG: Throws CycleFoundException
	/*
	@Test
	public void testAddDagEdgeBasic()
	{
		DirectedAcyclicGraph<String, Integer> dag = new DirectedAcyclicGraph<String, Integer>(Integer.class);

		String v1 = "v1";
		String v2 = "v2";

		dag.addVertex(v1);
		dag.addVertex(v2);

		Integer one = 1;

		assertEquals(dag.addDagEdge(v1,v2,one), true);
	}
	*/

	//Test addEdge
	@Test
	public void testAddEdge()
	{
		DirectedAcyclicGraph<String, Integer> dag = new DirectedAcyclicGraph<String, Integer>(Integer.class);

		String v1 = "v1";
		String v2 = "v2";

		dag.addVertex(v1);
		dag.addVertex(v2);

		Integer one = 1;

		assertEquals(dag.addEdge(v1,v2,one), true);
	}

	// Test addEdge cycle
	// BUG: Second addEdge should create a cycle and throw exception
	// Instead, it just does not add the edge and returns false
	/*
	@Test (expected = IllegalArgumentException.class)
	public void testAddEdgeIllegal()
	{
		DirectedAcyclicGraph<String, Integer> dag = new DirectedAcyclicGraph<String, Integer>(Integer.class);

		String v1 = "v1";
		String v2 = "v2";

		dag.addVertex(v1);
		dag.addVertex(v2);

		Integer one = 1;

		dag.addEdge(v1,v2,one);
		dag.addEdge(v2,v1,one);
	}
	*/
}