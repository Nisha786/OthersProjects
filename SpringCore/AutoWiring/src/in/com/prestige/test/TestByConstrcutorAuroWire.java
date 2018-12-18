package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.byConstructorwiring.CategoryDTO;
import in.com.prestige.util.BeanFactoryUtilByConstructorWiring;


public class TestByConstrcutorAuroWire {
    //Show Results
	public static void getResults() throws Exception{
		BeanFactory factory = null;
		try{
			factory = BeanFactoryUtilByConstructorWiring.getFactory();
		    CategoryDTO category = (CategoryDTO)factory.getBean("categoryId");
			category.showCategory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		getResults();
	}
}
