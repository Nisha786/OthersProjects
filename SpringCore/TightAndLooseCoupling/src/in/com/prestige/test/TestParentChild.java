package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.parentchild.Topic1;
import in.com.prestige.parentchild.TopicHelper;
import in.com.prestige.util.ParentchildBeanUtil;

public class TestParentChild {
	//Bean factory Object
	private static BeanFactory factory = null;
	
	public static void getResults() throws Exception {
           factory = ParentchildBeanUtil.getFactory();
           TopicHelper helper = (TopicHelper)factory.getBean("topicHelper"); 
           helper.shoeRecords();
           
	}

	// Main Method
	public static void main(String[] args) throws Exception {
            getResults();
            
	}
}
