package com.example;

public class Greeting {

  public Greeting() {
  }

  public String greet(String someone) {
    return String.format("Hello, %s!", someone);
  }

  public static void main(String[] args) {
	Greeting greeter = new Greeting();
	
	String result = greeter.greet("world");
	
    System.out.print(result);	
  }


};