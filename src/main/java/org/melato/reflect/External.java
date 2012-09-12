package org.melato.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The @External annotation indicates that the name and visibility of
 * a source code element (typically field, or method) is used by reflection.
 * You typically should not rename, remove, or change the visibility of such elements,
 * without being aware of how they are used.
 * For example, the names of @External fields may be used as tags in XML files. 
 * @author Alex Athanasopoulos
 */
@Retention(value=RetentionPolicy.SOURCE)
public @interface External {
}
