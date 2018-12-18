package in.com.prestige.parentchild;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic2 extends Subject {
	private String topicName;

	@Override
	public void method() {
		System.out.println("Hello Topic2");

	}
}
