package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.noautowire.CategoryDTO;
import in.com.prestige.util.BeanFactoryUtilNoWiring;

public class TestNoAuroWire {
    //Show Results
	public static void getResults() throws Exception{
		BeanFactory factory = null;
		try{
			factory = BeanFactoryUtilNoWiring.getFactory();
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
