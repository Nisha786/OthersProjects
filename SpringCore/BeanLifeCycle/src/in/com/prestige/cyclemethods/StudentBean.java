package in.com.prestige.cyclemethods;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;



public class StudentBean implements InitializingBean, DisposableBean {
	private Integer studentId;
	private String studentName;
	private String address;
	
    public StudentBean() throws Exception{
      System.out.println("Constructor called");	
      //afterPropertiesSet();
      //destroy();
    }
	
	public void init() throws Exception {
		//System.out.println("Bean Initilase by XML");
	}

	public void destruct() throws Exception {
		//System.out.println("Bean Desruction by XML");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bean Destroyed");
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
		//System.out.println("Student Name");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean Intialised");
	}

}
