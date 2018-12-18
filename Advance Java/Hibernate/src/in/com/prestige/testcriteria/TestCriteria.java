package in.com.prestige.testcriteria;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import in.com.prestige.DTO.UserDTO;

public class TestCriteria {
     //test only forLike
	public static void likeRestrictions() throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		Criteria crit = s.createCriteria(UserDTO.class);
		crit.add(Restrictions.like("lastName", "%i"));
		crit.addOrder(Order.desc("firstName"));
		crit.setMaxResults(1);
		List list = crit.list();
		Iterator it = list.iterator();
		while(it.hasNext()){
			UserDTO users = (UserDTO)it.next();
			System.out.println(users.getId()+"....."+users.getFirstName()+"...."+users.getLastName());
		}
		txn.commit();
		s.close();
	}
	//test for equals
	public static List<UserDTO> equalRestrictions() throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		Criteria crit = s.createCriteria(UserDTO.class);
	    crit.add(Restrictions.eq("firstName", "Deependra"));
		List list = crit.list();
		txn.commit();
		s.close();
		return list;
	}
	//get Max id Data
	public static void getMax()throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		Criteria crit = s.createCriteria(UserDTO.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("id"));
		crit.setProjection(proj);
		List list = crit.list();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Integer obj = (Integer)it.next();
			System.out.println(obj);
		}
		System.out.println(list.get(0));
	}
	
	//GetAuthanticate
	public static List authanticateUser(UserDTO dto) throws Exception{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		Criteria crit = s.createCriteria(UserDTO.class);
		crit.add(Restrictions.eq("id", dto.getId()));
		crit.add(Restrictions.eq("firstName", dto.getFirstName()));
		List list = crit.list();
		txn.commit();
		s.close();
		return  list;
	}
     
	//main Method
	public static void main(String[] args)throws Exception{
	  likeRestrictions();
		
	//for Arraylist Using equlas Method	
		/*List list = equalRestrictions();
		Iterator it = list.iterator();
		UserDTO users;
		while(it.hasNext()){
			users = (UserDTO)it.next();
			System.out.println(users.getId()+"...."+users.getFirstName()+"...."+users.getLastName());
		}*/
		
	 //For Authantication	
	/*	UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Deependra");
	   List list = authanticateUser(dto);
	   if(list.size()>=1){
		   Iterator it = list.iterator();
		   while(it.hasNext()){
			   UserDTO user = (UserDTO)it.next();
			   System.out.println(user.getFirstName()+".."+user.getLastName());
		   }
	   }else{
		   System.out.println("No Valid");
	   }*/
	  getMax();
  }
}
