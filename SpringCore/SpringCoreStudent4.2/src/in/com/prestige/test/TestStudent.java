package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import in.com.prestige.dto.StudentDTO;

public class TestStudent {
    //Getting ApplicationContext object
	public static  ApplicationContext getContext() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		return context;
	}
	//Getting Bean factory object
		public static BeanFactory getFactory() throws Exception{
			Resource resource = new ClassPathResource("applicationContext.xml");
			BeanFactory factory = new XmlBeanFactory(resource);
			return factory;
		}
	
	//Show Info
	public static void showInfo() throws Exception{
		ApplicationContext context = null;
		BeanFactory factory = null;
		try{
			factory  = getFactory();
			context = getContext();
			StudentDTO student = (StudentDTO)context.getBean("studentbean");
			//StudentDTO student2 = (StudentDTO)context.getBean("studentbean");
			StudentDTO student3 = (StudentDTO)factory.getBean("studentbean");
			StudentDTO student4 = (StudentDTO)factory.getBean("studentbean2");
			student.showInfo();
			System.out.println(student.hashCode());
			//System.out.println(student2.hashCode());
			//System.out.println(student3.hashCode());
			//System.out.println(student4.hashCode());
			//StudentDTO st1 = new StudentDTO();
			//StudentDTO st2 = new StudentDTO();
			//System.out.println(st1.hashCode());
			//System.out.println(st2.hashCode());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
       showInfo();
	}
}
