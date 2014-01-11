package org.melato.util.test;

import org.junit.Assert;
import org.junit.Test;
import org.melato.client.Serialization;

public class SerializationTest {
  @Test public void castTest() {
    String s = Serialization.cast("s", String.class);
    Assert.assertEquals("s", s);
  }

}
