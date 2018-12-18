package in.com.prestige.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JSonOutputGenerator implements IOutputGenerator {
     private Integer jsonId;
     private String JsonFileName;
	@Override
	public void generateOutput() {
		System.out.println("This is JSON Output");
	}

}
