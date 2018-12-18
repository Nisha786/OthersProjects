package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.autodetectcollection.QuetionDTO;
import in.com.prestige.util.BeanFactoryUtilAutoDetectWiring;


public class TestCollectionMapAutodetect {
    //Show Results
	public static void getResults() throws Exception{
		BeanFactory factory = null;
		try{
			factory = BeanFactoryUtilAutoDetectWiring.getFactory();
		    QuetionDTO question = (QuetionDTO)factory.getBean("questionId1");
		    question.showInfo();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		getResults();
	}
}
