package in.com.prestige.bytypewiring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	private String categoryName;
	private BookDTO book;
     
	public CategoryDTO(){
		System.out.println("Category 0-arg");
	}
	// We can't written argument constructor in byType only works when default constructor is written 
	  public CategoryDTO(BookDTO book,String categoryName){
		this.book = book;
		this.categoryName = categoryName;
	}
	
	public void showCategory() {
		book.showBookDetails(categoryName);
		System.out.println(book.hashCode()); 
	}
}
