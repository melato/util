package org.melato.client;

public class NameAlreadyExistsException extends Exception {
  private static final long serialVersionUID = 1L;
  private String name;    

  public String getName() {
    return name;
  }


  public NameAlreadyExistsException(String name) {
    this.name = name;
  }
  
}
