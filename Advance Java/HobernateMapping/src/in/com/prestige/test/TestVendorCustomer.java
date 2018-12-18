package in.com.prestige.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.CustomerDTO;
import in.com.prestige.dto.VendorDTO;

public class TestVendorCustomer {
	public static void insertRecord() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			// Parent Object
			VendorDTO vendor = new VendorDTO();
			vendor.setVendorID(102);
			vendor.setVendorName("IDEA");
			// Creating multipleChild Object
			CustomerDTO c1 = new CustomerDTO();
			c1.setCustomerId(504);
			c1.setCustomerName("Nishant");
			CustomerDTO c2 = new CustomerDTO();
			c2.setCustomerId(505);
			c2.setCustomerName("Pankaj");
			CustomerDTO c3 = new CustomerDTO();
			c3.setCustomerId(506);
			c3.setCustomerName("Gaurav");

			Set s = new HashSet();
			s.add(c1);
			s.add(c2);
			s.add(c3);

			vendor.setChildren(s);
			// save the record
			session.save(vendor);
			txn.commit();

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
	}

	// GetRecordS
	public static void getRecord() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			Criteria crit = session.createCriteria(VendorDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				VendorDTO dto = (VendorDTO) it.next();
				System.out.print("VendorId : " + dto.getVendorID());
				System.out.println("  VendorName : " + dto.getVendorName());
				Set s = dto.getChildren();
				Iterator it2 = s.iterator();
				while (it2.hasNext()) {
					CustomerDTO customer = (CustomerDTO) it2.next();
					System.out.print("  CustomerId : " + customer.getCustomerId());
					System.out.print("  CustomerName : " + customer.getCustomerName());
					System.out.println("  VendorID : " + customer.getForVendoreId());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Update Records
	public static void updateRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			VendorDTO vendor = (VendorDTO) session.get(VendorDTO.class, 101);
			vendor.setVendorName("JIO");
			session.update(vendor);
			txn.commit();

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//update child table data
	public static void updateChildRecords() throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try{
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			
			
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//delete Records
	public static void deleteRecord()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try{
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			VendorDTO vendor = (VendorDTO)session.get(VendorDTO.class, 101);
			session.delete(vendor);
			txn.commit();
			
			
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
				e.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// main method
	public static void main(String[] args) throws Exception {
		// insertRecord();
		// getRecord();
		// updateRecords();
		//deleteRecord();
	}
}
