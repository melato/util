package org.melato.util.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.melato.util.VariableSubstitution;

public class VariableSubstitutionTest {
  VariableSubstitution sub = new VariableSubstitution( VariableSubstitution.ANT_PATTERN );
	@Test public void testZero() {
		Map<String,String> map = Collections.emptyMap();
		Assert.assertEquals( "abc", sub.substitute( "abc", map));
	}
	@Test public void testOne() {
		Map<String,String> map = Collections.singletonMap("x", "b");
		Assert.assertEquals( "abc", sub.substitute( "a${x}c", map));
	}
	@Test public void testTwo() {
		Map<String,String> map = new HashMap<String,String>();
		map.put( "x", "b");
		map.put( "y", "d");
		Assert.assertEquals( "abcd", sub.substitute( "a${x}c${y}", map));
	}
  @Test public void testAt() {
    Map<String,String> map = Collections.singletonMap("x", "b");
    VariableSubstitution sub = new VariableSubstitution( VariableSubstitution.AT_PATTERN );
    Assert.assertEquals( "abc", sub.substitute( "a@x@c", map));
  }
}
