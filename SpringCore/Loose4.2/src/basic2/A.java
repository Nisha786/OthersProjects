package basic2;

public class A extends basic.A  {
	public void m1(){
		System.out.println("Method Inherited");
	}
 public static void main(String[] args) {
   A a = new A();	
   a.m1();
 }
}
