package in.com.prestige.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.util.UserDataAttribute;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.com.prestige.dto.CustomerDTO;
import in.com.prestige.dto.OrderListDTO;
import in.com.prestige.dto.ProductsDTO;

public class CustomerModel {
	public CustomerModel() {
	}

	// for add Record In database
	public int addCustomers(CustomerDTO bean) throws Exception {
		SessionFactory factory = null;
		Session s = null;
		Transaction txn = null;
		int res = 0;
		CustomerDTO cdto = new CustomerDTO();
		try {
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			cdto.setName(bean.getName());
			cdto.setEmail(bean.getEmail());
			cdto.setPassword(bean.getPassword());
			cdto.setContactno(bean.getContactno());

			s.evict(cdto);
			res = (int) s.save(cdto);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return res;
	}

	// for user login credentials
	public List checUserLogin(String username, String password) throws Exception {
		SessionFactory factory = null;
		Session s = null;
		Transaction txn = null;
		List list = null;

		try {
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			Criteria crit = s.createCriteria(CustomerDTO.class);
			crit.add(Restrictions.eq("email", username));
			crit.add(Restrictions.eq("password", password));
			list = crit.list();
			txn.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return list;
	}

	// For Delete user Entry from customers list
	public int deleteUserEntry(int cid) throws Exception {
		SessionFactory factory = null;
		Session s = null;
		Transaction txn = null;
		int res = 0;
		CustomerDTO cdto = new CustomerDTO();
		try {
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			cdto.setCustomersID(cid);
			s.delete(cdto);
			res = 1;
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}

		return res;
	}

	// for update customersData
	public int updateUserEntry(CustomerDTO bean) throws Exception {
		SessionFactory factory = null;
		Session s = null;
		Transaction txn = null;
		int res = 0;
		CustomerDTO CDTO = new CustomerDTO();
		try {
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			CDTO.setCustomersID(bean.getCustomersID());
			CDTO.setName(bean.getName());
			CDTO.setContactno(bean.getContactno());
			CDTO.setEmail(bean.getEmail());
			CDTO.setPassword(bean.getPassword());
			s.update(CDTO);
			res = 1;
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	// add Booking Record in orderlist

	public int bookOrder(String pname, String email, double price, int quantity) throws Exception {
		SessionFactory factory = null;
		Session s = null;
		Transaction txn = null;
		OrderListDTO dto = new OrderListDTO();
		int res = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			dto.setCustomersID(email);
	        dto.setProductName(pname);	
	        dto.setPrice(price);
	        dto.setQuantity(quantity);
	        dto.setContactNo(896523);
			s.evict(dto);
			res = (int)s.save(dto);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	// delete record from productlist

	public int deleteBookedItems(int qua, int pid) throws Exception {
		SessionFactory factory = null;
		Session s = null;
		Session s2 = null;
		Transaction txn = null;
		Transaction txn2 = null;
		int res = 0;
		int products = 0;
		int total = 0;
		
		ProductsDTO pdto = new ProductsDTO();
		String pname = null;
		String category = null;
		double price = 0.0;
		String fileName = null;
		String status = null;
		String path = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			Criteria crit = s.createCriteria(ProductsDTO.class);
			crit.add(Restrictions.eq("productID", pid));
			List list = crit.list();
			Iterator it = list.iterator();
			txn.commit();
			if (it.hasNext()) {
				ProductsDTO dto = (ProductsDTO)it.next();
				products = dto.getNumberofproducts();
				pname = dto.getProductname();
				category = dto.getCategory();
				price = dto.getPrice();
				fileName = dto.getFilename();
				status = dto.getStatus();
				path = dto.getPath();
			}
			s2 = factory.openSession();
			txn2 = s2.beginTransaction();
			total = (products - qua);
			pdto.setProductId(pid);
			pdto.setCategory(category);
			pdto.setFilename(fileName);
			pdto.setPrice(price);
			pdto.setPath(path);
			pdto.setProductName(pname);
			pdto.setNumberofproducts(total);
			pdto.setStatus(status);
			s2.update(pdto);
			res = 1;
			txn2.commit();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}

}
