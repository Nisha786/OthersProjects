package in.com.prestige.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryUtil2 {
   //Creating private Instance
	private static BeanFactory factory = null;
	//Private Constructor disallow out Access
	private BeanFactoryUtil2(){
		
	}
	//Making BeanFactory Object Singleton
	public static BeanFactory getFactory() throws  Exception{
		if(factory == null){
			Resource resource = new ClassPathResource("in/com/prestige/resources/prototypecontext.xml");
			factory = new XmlBeanFactory(resource);
		}
		return factory;
	}
}
