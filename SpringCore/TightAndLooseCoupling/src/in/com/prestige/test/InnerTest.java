package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.parentchild.InnerTestDTO;
import in.com.prestige.parentchild.InnerTestDTO.InnerTest1;
import in.com.prestige.util.innerTestUtil;

public class InnerTest {
private static BeanFactory factory = null;
	
	public static void getResults() throws Exception {
           factory = innerTestUtil.getFactory();
           InnerTestDTO.InnerTest1 dto = (InnerTestDTO.InnerTest1)factory.getBean("inner");
           dto.show();
           
	}
       	public static void main(String[] args) throws Exception {
                   getResults();
                   
       	}
}
