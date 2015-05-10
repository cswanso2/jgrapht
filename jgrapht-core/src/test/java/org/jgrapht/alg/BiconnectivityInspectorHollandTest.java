/**
* BiconnectivityInspector Test
*
* Author: Brandon Holland
*
*
*/

package org.jgrapht.alg;

import java.util.*;

import org.jgrapht.*;

import org.jgrapht.util.*;

import org.jgrapht.graph.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class BiconnectivityInspectorHollandTest
{
    @Test
    public void testGetBiconnectedVertexComponents()
    {
        UndirectedGraph<String, Integer> g = new SimpleGraph<String, Integer>(Integer.class);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";

        Integer one = 1;

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);

        g.addEdge(v1,v2,one);

        BiconnectivityInspector inspector = new BiconnectivityInspector(g);

        assertEquals(inspector.getBiconnectedVertexComponents(v1).size(), 1);
    }

    @Test
    public void testisBiconnected()
    {
        UndirectedGraph<String, Integer> g = new SimpleGraph<String, Integer>(Integer.class);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";

        Integer one = 1;

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);

        g.addEdge(v1,v2,one);

        BiconnectivityInspector inspector = new BiconnectivityInspector(g);

        assertEquals(inspector.isBiconnected(), true);
    }
}
