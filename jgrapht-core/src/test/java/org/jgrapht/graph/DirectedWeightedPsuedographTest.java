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
import org.jgrapht.graph.builder.*;

/**
 * A unit test for directed multigraph.
 *
 * @author Barak Naveh
 * @since Aug 9, 2003
 */
public class DirectedWeightedPsuedographTest
{

    //~ Methods ----------------------------------------------------------------

    /**
 	* A TestSuite for the directed weighted psuedo constructor
 	*
 	* @author Charles Swanson
 	* @since May 5th, 2015
 	*/
 	
 	@Test
    public void testConstructors()
    {
        DirectedWeightedPseudograph<String, Integer> g = new DirectedWeightedPseudograph<String, Integer>(Integer.class);
        assertEquals(0, g.vertexSet().size() );
    }
	

}

// End DefaultDirectedGraphTest.java
