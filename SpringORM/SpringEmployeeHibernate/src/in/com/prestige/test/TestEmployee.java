package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import in.com.prestige.dao.EmployeeDAO;
import in.com.prestige.dto.EmployeeDTO;

public class TestEmployee {
	// Add Records
	public static void addRecords() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO e = new EmployeeDTO();
		e.setEmpID(104);
		e.setEmpName("Naman");
		e.setAddress("Bhopal");
		int i = dao.addRecords(e);
		if (i >= 1) {
			System.out.println("Record Inserted");
		}
	}

	// GetAll Results
	public static void getAllResults() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		List list = dao.getAllResults();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			EmployeeDTO emp = (EmployeeDTO) it.next();
			System.out.println(emp.getEmpID() + "--" + emp.getEmpName() + "---" + emp.getAddress());
		}
	}

	// GetRecordbyid
	public static void getRecordById() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmpID(101);
		EmployeeDTO emp1 = (EmployeeDTO) dao.getResultById(emp);
		System.out.println(emp1.getEmpID() + "---" + emp1.getEmpName() + "---" + emp1.getAddress());
	}

	// update Record
	public static void updateRecord() throws Exception {
       EmployeeDAO dao = new EmployeeDAO();
       EmployeeDTO dto = new EmployeeDTO();
       dto.setEmpID(101);
       dto.setEmpName("Ram");
       dao.updateRecordsById(dto);
       
	}
	
	//Delete Records
	public static void deleteRecord()throws Exception{
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeDAO dao = new EmployeeDAO();
		dto.setEmpID(101);
		dao.deleteRecord(dto);
	}

	public static void main(String[] args) throws Exception {
		//addRecords();
		getAllResults();
		// getRecordById();
		//updateRecord();
		//deleteRecord();
	}
}
