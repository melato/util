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
package org.melato.client;

public class Bookmark {
  protected int type;
  protected String name;
  protected Object object;
  public Bookmark(int type, String name, Object object) {
    super();
    this.type = type;
    this.name = name;
    this.object = object;
  }
  public Bookmark(Bookmark bookmark, String name) {
    this.type = bookmark.type;
    this.name = name;
    this.object = bookmark.object;
  }
  public int getType() {
    return type;
  }
  public String getName() {
    return name;
  }
  public Object getObject() {
    return object;
  }
  public <T> T getObject(Class<T> cls) {
    return Serialization.cast(getObject(), cls);
  }
  @Override
  public String toString() {
    return getName();
  }
  
}
