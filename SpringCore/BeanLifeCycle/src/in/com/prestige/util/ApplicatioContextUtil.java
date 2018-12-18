package in.com.prestige.util;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ApplicatioContextUtil {
   //Creating private Instance
	private static ApplicationContext context = null;
	//Private Constructor disallow out Access
	private ApplicatioContextUtil(){
		
	}
	//Making BeanFactory Object Singleton
	public static ApplicationContext getFactory() throws  Exception{
		if(context == null){
			//Resource resource = new ClassPathResource("applicationContext.xml");
			//factory = new XmlBeanFactory(resource);
			 context = new ClassPathXmlApplicationContext("in/com/prestige/resources/applicationContext.xml");
		}
		return context;
	}
}
