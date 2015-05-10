/**
* UniformRandomGraphGenerator Test
*
* Author: Brandon Holland
*
*
*/

package org.jgrapht.experimental;

import java.util.*;

import org.jgrapht.*;

import org.jgrapht.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class UniformRandomGraphGeneratorTest
{
	private UniformRandomGraphGenerator one = new UniformRandomGraphGenerator(3,2);

	//Test UniformRandomGraphGenerator constructor with illegal Vertex input
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorIllegalVertex()
	{
		UniformRandomGraphGenerator one = new UniformRandomGraphGenerator(-2,2);
	}

	//Test UniformRandomGraphGenerator constructor with illegal Edge input
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorIllegalEdge()
	{
		UniformRandomGraphGenerator one = new UniformRandomGraphGenerator(2,-2);
	}

	//Test UniformRandomGraphGenerator constructor with illegal Edges
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorIllegalEdgeNoVertex()
	{
		UniformRandomGraphGenerator one = new UniformRandomGraphGenerator(0,3);
	}
}