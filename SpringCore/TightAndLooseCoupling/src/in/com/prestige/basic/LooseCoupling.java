package in.com.prestige.basic;

interface Topics {
	public void underStand();
}

class Topic1 implements Topics {
	@Override
	public void underStand() {
		System.out.println("This id Topic 1");
	}
}

class Topic2 implements Topics {
	@Override
	public void underStand() {
		System.out.println("This id Topic 2");
	}
}


//OutPut Helper Class
class OutputHelper{
	Topics topic;
	public OutputHelper(){
		topic = new Topic1();
	}
	public void generateOutPut(){
		topic.underStand();
	}
}
public class LooseCoupling {
	public static void main(String[] args){
      Topics t = new Topic1();
      System.out.println("-----By Interface-------");
      t.underStand();
      t = new Topic2();
      t.underStand();
      System.out.println("------By Helper class------");
      OutputHelper helper = new OutputHelper();
      helper.generateOutPut();
	}
}
