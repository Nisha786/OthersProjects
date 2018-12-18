package in.com.prestige.basic;

class Subject {
	Topic t = new Topic();

	public void startReading() {
		t.underStand();
	}
}

class Topic {
	public void underStand() {
		System.out.println("Tightly Coupled");
	}
}

public class TightCoupling {
	public static void main(String[] args) {
      new Subject().startReading();
	}
}
