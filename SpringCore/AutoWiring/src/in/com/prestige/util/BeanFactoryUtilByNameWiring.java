package in.com.prestige.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryUtilByNameWiring {
   //Creating private Instance
	private static BeanFactory factory = null;
	//Private Constructor disallow out Access
	private BeanFactoryUtilByNameWiring(){
		
	}
	//Making BeanFactory Object Singleton
	public static BeanFactory getFactory() throws  Exception{
		if(factory == null){
			Resource resource = new ClassPathResource("in/com/prestige/resources/byNameAutoWiring.xml");
			factory = new XmlBeanFactory(resource);
		}
		return factory;
	}
}
