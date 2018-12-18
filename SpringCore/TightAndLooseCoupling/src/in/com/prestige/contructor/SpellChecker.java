package in.com.prestige.contructor;

import lombok.Getter;
import lombok.Setter;

@Getter

public class SpellChecker {
   private String name;
   private String address;
   private Integer age;
   public SpellChecker(String name,String address,Integer age){
	   this.name = name;
	   this.address = address;
	   this.age = age;
	   System.out.println("SpellChecker Constructor");
   }
   public void checkSpelling(){
	   System.out.println("SpellChecker Check Spelling : "+name +" ------ "+address+" -------- "+age);
   }
}
