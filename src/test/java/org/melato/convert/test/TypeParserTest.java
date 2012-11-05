/*-------------------------------------------------------------------------
 * Copyright (c) 2012, Alex Athanasopoulos.  All Rights Reserved.
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
package org.melato.convert.test;

import org.junit.Assert;
import org.junit.Test;
import org.melato.convert.ParserManager;

public class TypeParserTest {
  public @Test void parseBaseTypes() {
    ParserManager parserManager = new ParserManager();
    Assert.assertEquals( "ok", parserManager.getParser(String.class).parse("ok"));
    Assert.assertEquals( new Float(3.14f), (Float) parserManager.getParser(Float.class).parse("3.14"), 1e-5f);
    Assert.assertEquals( new Float(3.14f), (Float) parserManager.getParser(float.class).parse("3.14"), 1e-5f);
    Assert.assertEquals( new Integer(7), parserManager.getParser(Integer.class).parse("7"));
    Assert.assertEquals( new Integer(7), parserManager.getParser(int.class).parse("7"));
    Assert.assertEquals( new Character('b'), parserManager.getParser(char.class).parse("b"));
    Assert.assertEquals( new Character('b'), parserManager.getParser(Character.class).parse("b"));
    Assert.assertEquals( new Short((short)7), parserManager.getParser(short.class).parse("7"));
    Assert.assertEquals( new Short((short)7), parserManager.getParser(Short.class).parse("7"));
    Assert.assertEquals( new Long(1234567890123456789L), parserManager.getParser(long.class).parse("1234567890123456789"));
    Assert.assertEquals( new Long(1234567890123456789L), parserManager.getParser(Long.class).parse("1234567890123456789"));
    Assert.assertEquals( Boolean.TRUE, parserManager.getParser(boolean.class).parse("true"));
    Assert.assertEquals( Boolean.FALSE, parserManager.getParser(Boolean.class).parse("false"));
    Assert.assertEquals( new Byte((byte)17), parserManager.getParser(byte.class).parse("11"));
    Assert.assertEquals( new Byte((byte)17), parserManager.getParser(Byte.class).parse("11"));
  }
}
