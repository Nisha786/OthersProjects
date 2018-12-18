package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.dto.IOutputGenerator;
import in.com.prestige.dto.OutPutHelper;
import in.com.prestige.util.BeanFactoryUtil;

public class TestOutputHelper {
	private static BeanFactory factory = null;
	public static void getRecords() throws Exception {
        factory = BeanFactoryUtil.getFactory();
        OutPutHelper out = (OutPutHelper)factory.getBean("OutputHelper");
        OutPutHelper out1 = (OutPutHelper)factory.getBean("OutputHelper2");
        out.showOutput();
        out1.showOutput();
        
        //Getting Result with getter Object
        System.out.println("---------Getting Result with getter Object---------");
        IOutputGenerator o = (IOutputGenerator)out.getIOutput();
        o.generateOutput();
	}

	// Main Method
	public static void main(String[] args)throws Exception {
        getRecords();
	}
}
