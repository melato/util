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

public interface HelpStorage {
  /** Load a help item by name.
   * @param name
   * @param lang The language code (e.g. "el", "en").
   * @return The help item for the specific language, or for the default language.
   */
  HelpItem loadHelpByName(String name, String lang);
  /** Load a help item by internal node code.
   * @param node The node code.
   */
  HelpItem loadHelpByNode(String node);
}
