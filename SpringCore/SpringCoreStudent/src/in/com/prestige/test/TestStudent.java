package in.com.prestige.test;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import in.com.prestige.dto.StudentDTO;

public class TestStudent {
    //Getting Bean factory object
	public static BeanFactory getFactory() throws Exception{
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		return factory;
	}
	
	//Show Info
	public static void showInfo() throws Exception{
		BeanFactory factory = null;
		try{
			factory = getFactory();
			StudentDTO student = (StudentDTO)factory.getBean("studentbean");
			student.showInfo();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
       showInfo();
	}
}
