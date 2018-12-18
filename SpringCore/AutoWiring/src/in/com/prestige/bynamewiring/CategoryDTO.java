package in.com.prestige.bynamewiring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	private String categoryName;
	private BookDTO book;
	private BookDTO book1;
    
	public void showCategory() {
		book.showBookDetails(categoryName);
		book1.showBookDetails(categoryName);
		System.out.println(book.hashCode());  //Both Objetcs Printing Different hashCodes
		System.out.println(book1.hashCode());
	}

	public CategoryDTO(String categoryName, BookDTO book, BookDTO book1) {
		this.categoryName = categoryName;
		this.book = book;
		this.book1 = book1;
	}
    //If we creating argument constructor then it is compulsory to written default constructor  
	public CategoryDTO() {
		
	}
}
