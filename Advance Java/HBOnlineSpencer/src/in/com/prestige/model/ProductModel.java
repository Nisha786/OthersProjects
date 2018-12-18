package in.com.prestige.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.HomePageDTO;
import in.com.prestige.dto.ProductsDTO;

public class ProductModel {
	public ProductModel() {
	}

	// for adding products details into database
	public int addProducts(ProductsDTO bean) {
		SessionFactory factory = null;
		Session s = null;
		Transaction txn = null;
		int res = 0;
        ProductsDTO pdto = new ProductsDTO();
		try {
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			pdto.setProductName(bean.getProductName());
			pdto.setCategory(bean.getCategory());
			pdto.setFilename(bean.getFilename());
			pdto.setNumberofproducts(bean.getNumberofproducts());
			pdto.setPath(bean.getPath());
			pdto.setPrice(bean.getPrice());
			pdto.setStatus(bean.getStatus());
			s.evict(pdto);
			res = (int)s.save(pdto);
			txn.commit();

		} catch (HibernateException e) {
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

	// for update products in Database
	public int updateProducts(ProductsDTO bean) throws Exception {
		SessionFactory factory = null;
		Session s = null;
		Transaction txn = null;
		int res = 0;
		ProductsDTO pdto = new ProductsDTO();
		try {
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			pdto.setCategory(bean.getCategory());
			pdto.setFilename(bean.getFilename());
			pdto.setNumberofproducts(bean.getNumberofproducts());
			pdto.setPath(bean.getPath());
			pdto.setPrice(bean.getPrice());
			pdto.setProductID(bean.getProductID());
			pdto.setProductname(bean.getProductname());
			s.update(pdto);
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

	// for add Banner Images
	public int bannerImages(HomePageDTO bean) throws Exception {
		SessionFactory factory = null;
		Session s = null;
		Transaction txn = null;
		int res = 0;
        HomePageDTO hdto = new HomePageDTO();
		try {
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			hdto.setFilename(bean.getFilename());
			hdto.setPath(bean.getPath());
			s.evict(hdto);
            res = (int)s.save(hdto);
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
}
