package in.com.prestige.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CSVOutputGenerator implements IOutputGenerator {
   private Integer csvFileId;
   private String csvFileName;
	@Override
	public void generateOutput() {
		System.out.println("This Is CSV Output");
	}

}
