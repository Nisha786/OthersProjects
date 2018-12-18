package in.com.prestige.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutPutHelper {
   private IOutputGenerator iOutput;
   private CSVOutputGenerator csvOutput;
   private JSonOutputGenerator jsonOutput;
   public void showOutput(){
	   iOutput.generateOutput();
   } 
}
