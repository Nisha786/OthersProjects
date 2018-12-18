package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.omg.CORBA.OBJ_ADAPTER;

import in.com.prestige.DTO.UserDTO;

public class TestUser {
	// add user into database
	public static void addUser() throws Exception {
		UserDTO user = new UserDTO();

		user.setFirstName("Pankaj");
		user.setLastName("Arya");
		user.setEmail("pankaj@gmail.com");
		user.setPassword("789456");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
        s.evict(user);
        int res = (int)s.save(user);
        if(res > 1){
        	System.out.println("Record Inserted");
        }else{
        	System.out.println("Not Inserted");
        }
		txn.commit();
		s.close();
	}

	// delete user into database
	public static void deleteUser() throws Exception {
		UserDTO user = new UserDTO();
		user.setId(3);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();

		s.delete(user);
		txn.commit();
		s.close();
	}

	// update user into database
	public static void updateUser() throws Exception {
		UserDTO user = new UserDTO();
		user.setId(5);
		user.setLastName("Ravi");
		user.setFirstName("Rishabh");
		user.setEmail("r@gmial.com");
		user.setPassword("ravi");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();

		s.update(user);
		txn.commit();
		s.close();
	}

	// Retrive all the list elements from databse
	public static void getUser() throws Exception {
		UserDTO user;
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		// query for select
		Query query = s.createQuery("from UserDTO");
		List list = query.list();
		Iterator it = list.iterator();
		System.out.print("Id" + " \t");
		System.out.print("FirstName" + " \t");
		System.out.print("LastName" + " \t");
		System.out.print("Email" + " \t");
		System.out.print("Password" + " \t");
		System.out.println("");
		while (it.hasNext()) {
			user = (UserDTO) it.next();
			System.out.print(user.getId() + " \t");
			System.out.print(user.getFirstName() + " \t");
			System.out.print(user.getLastName() + " \t");
			System.out.print(user.getEmail() + " \t");
			System.out.print(user.getPassword() + " \t");
			System.out.println(" ");
		}
		s.close();
	}

	// GET Single values
	public static void getSingleUser() throws Exception {
		UserDTO user;
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		// query for select
		Query query = s.createQuery("from UserDTO where id = ? and firstName = ?");
		query.setInteger(0, 1);
		query.setString(1, "Deependra");

		List list = query.list();
		Iterator it = list.iterator();

		if (it.hasNext()) {
			user = (UserDTO) it.next();
			System.out.print(user.getId() + " \t");
			System.out.print(user.getFirstName() + " \t");
			System.out.print(user.getLastName() + " \t");
			System.out.print(user.getEmail() + " \t");
			System.out.print(user.getPassword() + " \t");
			System.out.println(" ");
		} else {
			System.out.println("Invalide User");
		}
		s.close();
	}
	
	

	public static void getTest() throws Exception {
		UserDTO user;
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		user = (UserDTO) s.load(UserDTO.class, 5);
		System.out.println(user.getId());
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		s.close();
	}

	// Scsaller for nativesql in hibernate
	public static void scallerSql() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		String sql = "Select * from users";
		Query query = s.createSQLQuery(sql).addScalar("ID").addScalar("FIRST_NAME").addScalar("LAST_NAME")
				.addScalar("PASSWORD");
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			System.out.println("Id :" + obj[0]);
			System.out.println("FirstName :" + obj[1]);
			System.out.println("LastName :" + obj[2]);
			System.out.println("PassWord :" + obj[3]);
		}
		txn.commit();
		s.close();
	}

	// Select Native SQL Query IN HIbernate using addEntity method
	public static void entitySql() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		String sql = "Select * from users";
		Query query = s.createSQLQuery(sql).addEntity(UserDTO.class);
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserDTO users = (UserDTO) it.next();
			System.out.println("Id : " + users.getId());
			System.out.println("FirstName : " + users.getFirstName());
			System.out.println("LastName: " + users.getLastName());
			System.out.println("Password : " + users.getPassword());
			System.out.println("Email : " + users.getEmail());

		}
		txn.commit();
		s.close();
	}

	// Getting Some Propertiesa Of User DTO
	public static void gettingSomeInfo() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		String hql = "select u.id,u.firstName from UserDTO as u ";// order by
																	// u.firstName
																	// desc";
		Query query = s.createQuery(hql);
		// query.setInteger(0,2);
		List list = query.list();

		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			System.out.println(obj[0] + "....." + obj[1]);
		}

		txn.commit();
		s.close();
	}

	// gettingsome Records By sqlQuery
	public static void gettingSomInfoSQL() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		String sql = "select ID,FIRST_NAME from users";
		Query query = s.createSQLQuery(sql);
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			System.out.println("ID :" + obj[0]);
			System.out.println("FirstName :" + obj[1]);
		}
	}

	// Aggregate in HQL
	public static void aggregate() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		String hql = "select count(u),u.id ,u.firstName from UserDTO u group by u.firstName having u.firstName = ?";// where
																													// u.firstName
																													// =
																													// ?";//group
																													// by
																													// u.firstName
		Query query = s.createQuery(hql);
		query.setString(0, "Rishabh");
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			System.out.println(obj[0] + "..." + obj[1] + "......." + obj[2]);
		}
	}

	// Aggregate in sql
	public static void aggregateSQL() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		String sql = "select u.ID ,u.first_name from users u  having u.first_name = ?";// where
																						// u.firstName
																						// =
																						// ?";//group
																						// by
																						// u.firstName
		Query query = s.createSQLQuery(sql);
		query.setString(0, "Rishabh");
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			System.out.println(obj[0] + "..." + obj[1] + ".......");
		}
	}

	//Aggregate for like
	public static void aggregateLike() throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		String hql = "from UserDTO as u where u.lastName like '%i' order by u.firstName desc";
		Query query = s.createQuery(hql);
		List list = query.list();
		Iterator it = list.iterator();
		while(it.hasNext()){
			UserDTO users = (UserDTO)it.next();
			System.out.println(users.getId()+"..."+users.getFirstName()+"..."+users.getLastName());
		}
		txn.commit();
		s.close();
	}
	
	//Aggregate for likeSQL
		public static void aggregateLikeSQL() throws Exception{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session s = factory.openSession();
			Transaction txn = s.beginTransaction();
			String sql = "select * from users as u where u.last_name like '%i' order by u.first_name desc";
			Query query = s.createSQLQuery(sql);
			List list = query.list();
			Iterator it = list.iterator();
			while(it.hasNext()){
				Object[] users = (Object[])it.next();
				System.out.println(users[0]+"..."+users[2]+"..."+users[1]);
			}
			txn.commit();
			s.close();
		}
		
	
	// main method

	public static void main(String[] args) throws Exception {
		// addUser();
		// deleteUser();
		// updateUser();
		// getTest();
		// getUser();
		// getSingleUser();
		// scallerSql();
		// entitySql();
		// gettingSomeInfo();
		// gettingSomInfoSQL();
		// aggregate();
		//aggregateSQL();
		//aggregateLike();
		//aggregateLikeSQL();
		
	}
}
