package com.domtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
  public static void main(String[] args) {
	  String str = "https://google.com//stringINeed.hello" ;
	  Pattern regex = Pattern.compile("[^/.]+(?=\\.[^.]+$)");
	  Matcher regexMatcher = regex.matcher(str);
	  if (regexMatcher.find()) {
	      System.out.println(regexMatcher.group());
	  } 
	 
 }
}
