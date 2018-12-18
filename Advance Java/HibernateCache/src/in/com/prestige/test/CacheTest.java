package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.DTO.UserDTO;

public class CacheTest {
	public static void addUsers() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		UserDTO user = new UserDTO();
		user.setFirstName("Deependra");
		user.setLastName("Chauhdari");
		user.setEmail("c.deep@gmail.com");
		user.setPassword("123456");
		s.save(user);
		System.out.println("Succefully Saved");
		txn.commit();
		s.close();
	}

	// update data only specific field
	public static void updateUsersspecific() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		UserDTO user = (UserDTO) s.get(UserDTO.class, 1);
		user.setId(user.getId());
		user.setFirstName("Rishabh");

		s.update(user);
		System.out.println("Updated");
		s.close();
	}

	// method for check firsLevel Cache
	public static void firstLevelCache() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		UserDTO user = (UserDTO) s.load(UserDTO.class, 1);
		System.out.println(user.getId() + "...." + user.getFirstName() + "..." + user.getLastName());

		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(s.contains(user));
		s.evict(user); // Remove the Object from firstLevel Cache
		System.out.println(s.contains(user));
		UserDTO user1 = (UserDTO) s.load(UserDTO.class, 1); // getting Data for
															// same user from
															// firstLevel cache
		System.out.println(user1.getId() + "...." + user1.getFirstName() + "..." + user1.getLastName());
		s.close();
		// System.out.println(s.contains(user));
	}

	// Method for getting gData from Second level Cache
	public static void seconfLevelCatch() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		UserDTO user1 = (UserDTO) s.load(UserDTO.class, 1);
		System.out.println(user1.getFirstName() + "......" + user1.getLastName());
		s.close();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Session s1 = factory.openSession();
		UserDTO user2 = (UserDTO) s1.load(UserDTO.class, 1);
		System.out.println(user2.getFirstName() + "...." + user2.getLastName());
		s1.close();

	}

	// getting data under loop
	public static void secondLevelCacheLoop() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		for (int i = 0; i < 10; i++) {
			Session s = factory.openSession();
			UserDTO user1 = (UserDTO) s.load(UserDTO.class, 1);
			System.out.println(user1.getFirstName() + "......" + user1.getLastName());

			try {
				Thread.sleep(6000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			s.close();
		}

	}

	// Query Catch
	public static void querycCatch() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Query query = s.createQuery("from UserDTO");
		query.setCacheable(true);
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
			System.out.println(dto.getFirstName() + "...." + dto.getLastName());
		}
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List list2 = query.list();
		Iterator it2 = list2.iterator();
		while (it2.hasNext()) {
			UserDTO dto = (UserDTO) it2.next();
			System.out.println(dto.getFirstName() + "...." + dto.getLastName());
		}
		s.close();
	}

	// Query Catch with criteria
	public static void queryCriteriaCatch() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Criteria crit = s.createCriteria(UserDTO.class);
		crit.setCacheable(true);
		List list = crit.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserDTO user = (UserDTO) it.next();
			System.out.println(user.getFirstName() + "...." + user.getLastName());
		}
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Query Level Catch Works with only with Second level catch
		Session s2 = factory.openSession();
		Criteria crit2 = s2.createCriteria(UserDTO.class);
		List list2 = crit.list();
		Iterator it2 = list2.iterator();
		while (it2.hasNext()) {
			UserDTO user = (UserDTO) it2.next();
			System.out.println(user.getFirstName() + "...." + user.getLastName());
		}

	}

	// SQLQuery Cache
	public static void querySQLCatch() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Query query = s.createSQLQuery("select * from userscache").addEntity(UserDTO.class);
		query.setCacheable(true);
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserDTO users = (UserDTO) it.next();
			System.out.println("Id : " + users.getId());
			System.out.println("FirstName : " + users.getFirstName());
		}
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Session s2 = factory.openSession(); // Query level cache is not working
											// with Native SQL Query in
											// Hibernate
		Query query2 = s2.createSQLQuery("select * from userscache").addEntity(UserDTO.class);
		List list2 = query2.list();
		Iterator it2 = list2.iterator();
		while (it2.hasNext()) {
			UserDTO users = (UserDTO) it2.next();
			System.out.println("Id : " + users.getId());
			System.out.println("FirstName : " + users.getFirstName());
		}
		s.close();
	}
	
	//Test Named Query
	public static void namedQueryTest()throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Query query = s.getNamedQuery("HQL_GET_USER");
		query.setInteger("id", 1);
		List list = query.list();
		Iterator it = list.iterator();
		while(it.hasNext()){
			UserDTO dto = (UserDTO)it.next();
			System.out.println(dto.getFirstName()+"..."+dto.getLastName());
		}
		s.close();
	}

	public static void main(String[] args) throws Exception {
		// addUsers();
		// updateUsersspecific();
		// firstLevelCache();
		// seconfLevelCatch();
		// secondLevelCacheLoop();
		// querycCatch();
		// queryCriteriaCatch();
		//querySQLCatch();
		namedQueryTest();
	}
}
