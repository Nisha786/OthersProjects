package in.com.prestige.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
	private Integer studentID;
	private String studentName;
	private String address;

	public void showInfo() {
		System.out.println("StudentId  : " + studentID);
		System.out.println("StudentName :" + studentName);
		System.out.println("Address :" + address);
	}

	public StudentDTO() {
		System.out.println("Obeject Constructed");
	}
}
