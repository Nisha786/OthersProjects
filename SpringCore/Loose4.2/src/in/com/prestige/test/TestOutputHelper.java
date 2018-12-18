package in.com.prestige.test;


import org.springframework.context.ApplicationContext;

import in.com.prestige.dto.CSVOutputGenerator;
import in.com.prestige.dto.IOutputGenerator;
import in.com.prestige.dto.JSonOutputGenerator;
import in.com.prestige.dto.OutPutHelper;
import in.com.prestige.util.BeanFactoryUtil;

public class TestOutputHelper {
	private static ApplicationContext context = null;
	public static void getRecords() throws Exception {
		context = BeanFactoryUtil.getFactory();
        OutPutHelper out = (OutPutHelper)context.getBean("OutputHelper");
        OutPutHelper out1 = (OutPutHelper)context.getBean("OutputHelper2");
        out.showOutput();
        out1.showOutput();
        
        
        //Getting Result with getter Object
        System.out.println("---------Getting Result with getter Object---------");
        IOutputGenerator obj = (IOutputGenerator)out.getIOutput();
        obj.generateOutput();
        
        /*//Getting Simple Setter Object
        System.out.println("---------Getting Result with Bean Setter Object---------");
        CSVOutputGenerator csv = (CSVOutputGenerator)context.getBean("CSVOutputGenerator");
        System.out.println(csv.getCsvFileId());
        System.out.println(csv.getCsvFileName());*/
        
        //Getting Simple CSV Setter Object
        System.out.println("---------Getting Result with OuterHelper CSV Setter Object---------");
        CSVOutputGenerator csv2 = (CSVOutputGenerator)out.getCsvOutput();
        System.out.println(csv2.getCsvFileId());
        System.out.println(csv2.getCsvFileName());
        
      //Getting Simple JSON Setter Object
        System.out.println("---------Getting Result with OuterHelper JSON Setter Object---------");
        JSonOutputGenerator json = (JSonOutputGenerator)out.getJsonOutput();
        System.out.println(json.getJsonId());
        System.out.println(json.getJsonFileName());
        
	}

	// Main Method
	public static void main(String[] args)throws Exception {
        getRecords();
	}
}
