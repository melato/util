package org.melato.log;

/**
 * A class that measures differences in time, for debugging time/performance issues.
 * @author Alex Athanasopoulos
 *
 */
public class Clock {  
  private long time = System.currentTimeMillis();
  private String message = "time";
  
  public Clock() {
  }
  
  public Clock(String message) {
    super();
    this.message = message;
  }

  public String lap(String message) {
    long now = System.currentTimeMillis();
    long diff = now - time;
    time = now;
    return message + ": " + diff + " ms"; 
  }
  public String lap() {
    return lap(message);
  }
  public String toString() {
    return lap( message );
  }
}

