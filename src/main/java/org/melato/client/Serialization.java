/*-------------------------------------------------------------------------
 * Copyright (c) 2012,2013,2014, Alex Athanasopoulos.  All Rights Reserved.
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
package org.melato.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Serialization {
  public static Object read(Class<?> clazz, InputStream stream) {
    try {
      ObjectInputStream in = new ObjectInputStream(stream);
      try {
        Object obj = in.readObject();
        if ( ! clazz.isInstance(obj)) {
          obj = null;
        }
        return obj;
      } finally {
        in.close();
      }
    } catch( Exception e ) {
      System.out.println(e);
      return null;
    }
  }
  
  public static void write(Object object, OutputStream stream) throws IOException {
    ObjectOutputStream out = new ObjectOutputStream(stream);
    try {
      out.writeObject(object);
    } finally {
      out.close();
    }
  }

  public static Object read(Class<?> clazz, File file) {
    System.out.println( "read " + file);
    try {
      return read(clazz, new FileInputStream(file));
    } catch (FileNotFoundException e) {
      System.out.println(e);
      return null;
    }
  }
  public static void write(Object object, File file) throws IOException {
    write(object, new FileOutputStream(file));
  }
  public static Object read(Class<?> clazz, byte[] data) {
    return read(clazz, new ByteArrayInputStream(data));
  }
  public static byte[] toByteArray(Object object) throws IOException {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    write(object, stream);
    return stream.toByteArray();
  }
  public static <T> T cast(Object obj, Class<T> clazz) {
    if ( obj != null && clazz.isAssignableFrom(obj.getClass())) {
      return (T) obj;
    }
    return null;
  }
}
