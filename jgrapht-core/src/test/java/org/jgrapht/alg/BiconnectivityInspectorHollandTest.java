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

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class BiconnectivityInspectorHollandTest
{
    @Test
    public void test()
    {
        UndirectedGraph<String, DefaultEdge> g = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";

        Integer one = 1;

        g.addVertex(v1);
        g.addVertex(v2);
        g.addvertex(v3);

        g.addEdge(v1,v2,one);

        BiconnectivityInspector inspector = new BiconnectivityInspector(g);

        assertEquals(inspector.getBiconnectedVertexComponents(v1).size(), 1);
    }
}
