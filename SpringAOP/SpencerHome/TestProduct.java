import java.io.*;
import java.util.*;
class TestProduct{ 
	public static void main(String[] args) throws Exception {
		FileInputStream  fout = new FileInputStream("F:/Prestige Java/SpencerHome/BookedProductList.txt");
		ObjectInputStream read = new ObjectInputStream(fout);
		ArrayList emplist =  (ArrayList)read.readObject();
		Iterator it = emplist.iterator();
		while(it.hasNext()){
			Product emp = (Product)it.next();
			System.out.println(emp.getProductName()+"------"+emp.getProductPrice()+"-------"+emp.getCustmerBookID());
		
		}
	}
}