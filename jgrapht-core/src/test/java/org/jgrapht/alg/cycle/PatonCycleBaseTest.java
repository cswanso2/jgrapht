/**
* PatonCycleBase Test
*
* Author: Brandon Holland
*
*
*/

package org.jgrapht.alg.cycle;

import java.util.*;

import org.jgrapht.graph.*;

import org.jgrapht.*;

import org.jgrapht.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class PatonCycleBaseTest
{
    @Test
    public void testPatronConstructor()
    {
        UndirectedGraph<String, Integer> g = new SimpleGraph<String, Integer>(Integer.class);

        String v1 = "v1";

        g.addVertex(v1);

        UndirectedGraph<String, Integer> test = new SimpleGraph<String, Integer>(Integer.class);

        PatonCycleBase<String, Integer> patonFinder =  new PatonCycleBase<String, Integer>(g);

        test = patonFinder.getGraph();

        assertEquals(test.containsVertex(v1),true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPatronConstructorIllegal()
    {
        PatonCycleBase<String, Integer> patonFinder =  new PatonCycleBase<String, Integer>(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetGraphIllegal()
    {
        PatonCycleBase<Integer, DefaultEdge> patonFinder = new PatonCycleBase<Integer, DefaultEdge>();

        patonFinder.setGraph(null);
    }
}
