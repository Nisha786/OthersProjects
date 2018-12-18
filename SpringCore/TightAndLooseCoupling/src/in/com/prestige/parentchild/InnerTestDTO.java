package in.com.prestige.parentchild;

public class InnerTestDTO {
	public class InnerTest1 {
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
        public void show(){
        	System.out.println(name);
        }
	}
}
