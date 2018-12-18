package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.byConstructorwiring.CategoryDTO;
import in.com.prestige.colletionwithwiring.PersonDTO;
import in.com.prestige.util.BeanFactoryUticollectionWiring;
import in.com.prestige.util.BeanFactoryUtilByConstructorWiring;


public class TestCollection {
    //Show Results
	public static void getResults() throws Exception{
		BeanFactory factory = null;
		try{
			factory = BeanFactoryUticollectionWiring.getFactory();
		    PersonDTO person = (PersonDTO)factory.getBean("personId");
		    person.getResults();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		getResults();
	}
}
