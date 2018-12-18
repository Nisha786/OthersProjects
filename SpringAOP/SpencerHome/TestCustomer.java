import java.io.*;
import java.util.*;
class TestCustomer{ 
	public static void main(String[] args) throws Exception {
		FileInputStream  fout = new FileInputStream("F:/Prestige Java/SpencerHome/CustomerList.txt");
		ObjectInputStream read = new ObjectInputStream(fout);
		ArrayList emplist =  (ArrayList)read.readObject();
		Iterator it = emplist.iterator();
		while(it.hasNext()){
			Customer emp = (Customer)it.next();
			System.out.println(emp.getCustomerID()+"------"+emp.getName()+"-------"+emp.getContactNo());
		
		}
	}
}