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

public class Menu {
  public String label;
  public String icon;
  public String type;
  public String target;
  public int startDate;
  public int endDate;
  public String getLabel() {
    return label;
  }
  public void setLabel(String label) {
    this.label = label;
  }
  public String getIcon() {
    return icon;
  }
  public void setIcon(String icon) {
    this.icon = icon;
  }  
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getTarget() {
    return target;
  }
  public void setTarget(String target) {
    this.target = target;
  }
  public int getStartDate() {
    return startDate;
  }
  public void setStartDate(int startDate) {
    this.startDate = startDate;
  }
  public int getEndDate() {
    return endDate;
  }
  public void setEndDate(int endDate) {
    this.endDate = endDate;
  }
  public void setDate(int date) {
    this.startDate = date;
    this.endDate = date;
  }
  public boolean isActive(int dateId) {
    return (startDate == 0 || startDate <= dateId) && (endDate == 0 || dateId <= endDate);
  }
  @Override
  public String toString() {
    return label + " type=" + type + " target=" + target;
  }
}
