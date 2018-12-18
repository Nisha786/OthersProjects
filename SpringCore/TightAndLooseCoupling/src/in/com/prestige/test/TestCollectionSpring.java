package in.com.prestige.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;

import in.com.prestige.dto.CustomerDTO;
import in.com.prestige.dto.PersonDTO;
import in.com.prestige.util.BeanFactoryUtil2;

public class TestCollectionSpring {
	private static BeanFactory factory = null;

	public static void getResults() throws Exception {
		factory = BeanFactoryUtil2.getFactory();
		CustomerDTO cust = (CustomerDTO) factory.getBean("CustomerBean");
		System.out.println(cust.getSets());
		Set s = cust.getSets();
		Iterator it = s.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("--------Map Class--------");
		System.out.println(cust.getMaps());
		Iterator it2 = cust.getMaps().entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry<Object, Object> entrySet = (Map.Entry<Object, Object>) it2.next();
			if (entrySet.getKey().equals("key3")) {
				PersonDTO p = (PersonDTO) entrySet.getValue();
				System.out.println(p.getName());
			} else {
				System.out.println(entrySet.getKey() + "..." + entrySet.getValue());
			}
		}

		// List Class
		System.out.println("--------List Class--------");
		System.out.println(cust.getList());
		Iterator<Object> it3 = cust.getList().iterator();
		while (it3.hasNext()) {
			// PersonDTO p = (PersonDTO)it3.next();
			// System.out.println(p.getName());
			// System.out.println(p.getAddress());
		}
	}

	public static void main(String[] args) throws Exception {
		getResults();
	}
}
