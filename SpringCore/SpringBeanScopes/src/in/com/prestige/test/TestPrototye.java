package in.com.prestige.test;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.singleton.StudentBean;
import in.com.prestige.util.BeanFactoryUtil2;

public class TestPrototye {
	// Getting Results
	public static void getResults() throws Exception {
		BeanFactory factory = null;
		try {
			factory = BeanFactoryUtil2.getFactory();
			StudentBean bean = (StudentBean) factory.getBean("studentId");
			StudentBean bean1 = (StudentBean) factory.getBean("studentId");
			StudentBean bean2 = (StudentBean) factory.getBean("studentId");
			StudentBean bean3 = (StudentBean) factory.getBean("studentId1");
			System.out.println(bean.getStudentId() + "---" + bean.getStudentName());
			System.out.println(bean1.hashCode());
			System.out.println(bean2.hashCode());
			System.out.println(bean3.hashCode());
			System.out.println(bean.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		getResults();
	}
}
