package in.com.prestige.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import in.com.prestige.dto.EmployeeDTO;
import in.com.prestige.util.BeanFactoryUtil;
import in.com.prestige.util.HibernateTemplateUtil;

public class EmployeeDAO {
    //Insert Data
	public int addRecords(EmployeeDTO e) throws Exception{
		BeanFactory factory = BeanFactoryUtil.getFactory();
		HibernateTemplateUtil template = (HibernateTemplateUtil)factory.getBean("EmployeeId");
	    int i = (int)template.getHibernatTemplate().save(e);
	    return i;
	}
	
	//gettAllRecords
	public List getAllResults() throws Exception{
		List list = null;
		try{
		BeanFactory factory = BeanFactoryUtil.getFactory();
		HibernateTemplateUtil template = (HibernateTemplateUtil)factory.getBean("EmployeeId");
		list = template.getHibernatTemplate().loadAll(EmployeeDTO.class);
		}catch (Exception e) {
		}
		return list;
	}
	//GetSingle Result
	public EmployeeDTO getResultById(EmployeeDTO dto)throws Exception{
		BeanFactory factory = BeanFactoryUtil.getFactory();
		HibernateTemplateUtil template = (HibernateTemplateUtil)factory.getBean("EmployeeId");
		EmployeeDTO emp = (EmployeeDTO)template.getHibernatTemplate().get(EmployeeDTO.class,dto.getEmpID() );
		return emp;
	}
	//Update Records
	public void updateRecordsById(EmployeeDTO emp)throws Exception{
		BeanFactory factory = BeanFactoryUtil.getFactory();
		HibernateTemplateUtil template = (HibernateTemplateUtil)factory.getBean("EmployeeId");
		EmployeeDTO dto = (EmployeeDTO)template.getHibernatTemplate().get(EmployeeDTO.class, emp.getEmpID());
		dto.setEmpName(emp.getEmpName());
		template.getHibernatTemplate().update(dto);
		System.out.println("Record Updated");
	}
	public void deleteRecord(EmployeeDTO emp)throws Exception{
		BeanFactory factory = BeanFactoryUtil.getFactory();
		HibernateTemplateUtil template = (HibernateTemplateUtil)factory.getBean("EmployeeId");
		template.getHibernatTemplate().delete(emp);
		System.out.println("Record Deleted");
	}
}
