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

/**
 * A unit test for directed multigraph.
 *
 * @author Barak Naveh
 * @since Aug 9, 2003
 */
public class DirectedPsuedographTest
{
    //~ Instance fields --------------------------------------------------------

    private String v1 = "v1";
    private String v2 = "v2";
    private String v3 = "v3";

    //~ Methods ----------------------------------------------------------------

    /**
 	* A TestSuite for the directed psuedo constructor
 	*
 	* @author Charles Swanson
 	* @since May 5th, 2015
 	*/
 	
 	@Test
    public void testConstructor()
    {
        DirectedPseudograph<String, DefaultEdge> g = new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);
        g.setEdgeSetFactory(new LinkedHashSetFactory<String, DefaultEdge>());
        assertEquals(0, g.vertexSet().size() );
    }
	
    

    //~ Inner Classes ----------------------------------------------------------

    private static class LinkedHashSetFactory<V, E>
        implements EdgeSetFactory<V, E>
    {
        /**
         * .
         *
         * @param vertex
         *
         * @return an empty list.
         */
        @Override
        public Set<E> createEdgeSet(V vertex)
        {
            return new LinkedHashSet<E>();
        }
    }
}

// End DefaultDirectedGraphTest.java
