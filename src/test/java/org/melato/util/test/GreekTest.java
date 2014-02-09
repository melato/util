package org.melato.util.test;

import org.junit.Assert;
import org.junit.Test;
import org.melato.util.Strings;

public class GreekTest {
  public @Test void normalize() {
    String name = "Αθηναίων";
    String normal = "ΑΘΗΝΑΙΩΝ";
    
    Assert.assertEquals(normal, Strings.toUpperCaseNoAccents(name));
  }
}
