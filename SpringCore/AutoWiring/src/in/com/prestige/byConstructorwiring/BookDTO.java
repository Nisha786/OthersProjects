package in.com.prestige.byConstructorwiring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
	private Integer bookID;
	private String bookName;
	private String author;
	
	

	public void showBookDetails(String category) {
		System.out.println(category+"---- "+bookID + "----" + bookName + "------" + author);
	}
}
