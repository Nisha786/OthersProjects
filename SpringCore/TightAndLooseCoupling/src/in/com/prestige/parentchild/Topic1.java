package in.com.prestige.parentchild;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic1 extends Subject {
	private String topicName;

	@Override
	public void method() {
		System.out.println("Hello Topic1");
	}

	public class InnerTest {
		public InnerTest() {
		}

		String innerName;

		public String getInnerName() {
			return innerName;
		}

		public void setInnerName(String innerName) {
			this.innerName = innerName;
		}

		public void show() {
			System.out.println(innerName);
		}
	}
}
