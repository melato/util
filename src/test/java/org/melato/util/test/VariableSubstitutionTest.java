/*-------------------------------------------------------------------------
 * Copyright (c) 2012,2013, Alex Athanasopoulos.  All Rights Reserved.
 * alex@melato.org
 *-------------------------------------------------------------------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *-------------------------------------------------------------------------
 */
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
