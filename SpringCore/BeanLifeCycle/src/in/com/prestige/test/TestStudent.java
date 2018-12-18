package in.com.prestige.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.com.prestige.cyclemethods.StudentBean;
import in.com.prestige.util.ApplicatioContextUtil;

public class TestStudent {
	// getting Results
	public static void getResults() throws Exception {
        ApplicationContext context = null;
        try{
        	context = ApplicatioContextUtil.getFactory();
           ((AbstractApplicationContext)context).registerShutdownHook();
        	/*((AbstractApplicationContext)context).close();
        	((AbstractApplicationContext)context).refresh();*/
        	StudentBean bean1 = (StudentBean)context.getBean("studentId");
        	System.out.println("Hello : "+bean1.getStudentId()+".."+bean1.getStudentName()+"---"+bean1.getAddress());
        	StudentBean bean2 = (StudentBean)context.getBean("studentId1");
            System.out.println("Hello : "+bean2.getStudentId()+".."+bean2.getStudentName()+"---"+bean2.getAddress());
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

	// Main Method
	public static void main(String[] args) throws Exception {
		getResults();
	}

}
