package in.com.prestige.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutPutHelper {
   private IOutputGenerator iOutput;
   
   public void showOutput(){
	   iOutput.generateOutput();
   } 
}
