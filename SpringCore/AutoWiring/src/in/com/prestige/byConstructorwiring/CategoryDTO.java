package in.com.prestige.byConstructorwiring;

import lombok.Getter;
import lombok.Setter;


public class CategoryDTO {
	private String categoryName;
	private BookDTO book;
    
	public void showCategory() {
		book.showBookDetails(categoryName);
		System.out.println(book.hashCode());  //Both Objetcs Printing Different hashCodes
	}

	public CategoryDTO(String categoryName, BookDTO book) {
		this.categoryName = categoryName;
		this.book = book;
	}
	

	
}
