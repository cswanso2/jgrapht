/**
* ModifiableInteger Test
*
* Author: Brandon Holland
*
*
*/
package org.jgrapht.util;

import java.util.*;

import org.jgrapht.*;

import org.jgrapht.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import junit.framework.*;


public class ModifiableIntegerTest
{
	// Test setValue
	@Test
	public void testSetValue()
	{
		ModifiableInteger mod = new ModifiableInteger();

		mod.setValue(2);

		assertEquals(mod.intValue(), 2);
	}

	// Test increment
	@Test
	public void testIncrement()
	{
		ModifiableInteger mod = new ModifiableInteger();

		mod.setValue(2);
		mod.increment();

		assertEquals(mod.intValue(), 3);
	}

	// Test compareTo
	@Test
	public void testCompareTo()
	{
		ModifiableInteger mod = new ModifiableInteger(1);
		ModifiableInteger one = new ModifiableInteger(1);
		ModifiableInteger zero = new ModifiableInteger(0);
		ModifiableInteger two = new ModifiableInteger(2);

		assertEquals(mod.compareTo(one), 0);
		assertEquals(mod.compareTo(zero), -1);
		assertEquals(mod.compareTo(two), 1);
	}

	// Test equals
	@Test
	public void testEquals()
	{
		ModifiableInteger mod = new ModifiableInteger(1);
		ModifiableInteger one = new ModifiableInteger(1);

		assertEquals(mod.equals(one), true);
		assertEquals(mod.equals(2), false);
	}

	// Test floatValue
	@Test
	public void testFloatValue()
	{
		ModifiableInteger mod = new ModifiableInteger(1);

		float test = (float)(1);
		float in = mod.floatValue();
	
		Boolean a = false;

		if(test == in)
			a = true;

		assertEquals(a, true);
	}

	// Test longValue
	@Test
	public void testLongValue()
	{
		ModifiableInteger mod = new ModifiableInteger(1);

		assertEquals(mod.longValue(), 1);
	}

	// Test hashCode
	@Test
	public void testHashCode()
	{
		ModifiableInteger mod = new ModifiableInteger(1);

		assertEquals(mod.hashCode(), 1);
	}

	// Test toInteger
	@Test
	public void testToInteger()
	{
		int one = 1;		

		ModifiableInteger mod = new ModifiableInteger(one);

		int test = mod.toInteger();

		assertEquals(test, one);
	}

	// Test toString
	@Test
	public void testToString()
	{
		ModifiableInteger mod = new ModifiableInteger(1);

		assertEquals(mod.toString(), "1");
	}

}