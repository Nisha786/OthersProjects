package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.contructor.TextEditor;
import in.com.prestige.util.BeanFactoryCons;

public class TestSpellChecker {
	//Bean factory Object
	private static BeanFactory factory = null;
	
	public static void getResults() throws Exception {
           factory = BeanFactoryCons.getFactory();
           TextEditor text = (TextEditor)factory.getBean("textEditor");
           text.show();
	}

	// Main Method
	public static void main(String[] args) throws Exception {
            getResults();
	}
}
