package in.com.prestige.colletionwithwiring;

import java.util.Iterator;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
   private CustomerDTO cust;
   
   public void getResults(){
	  Iterator it = cust.getMap().entrySet().iterator();
	  while(it.hasNext()){
		  Map.Entry<Object, Object> pair = (Map.Entry<Object, Object>)it.next();
		  if(pair.getKey().equals("Address")){
		  System.out.print(pair.getKey()+"----");
		  Address add = (Address)pair.getValue();
		  System.out.println(add.getCity()+" "+add.getState()+" "+add.getZipcode());
		  }else{
			  System.out.println(pair.getKey()+"---"+pair.getValue());
		  }
	  }
   }
}
