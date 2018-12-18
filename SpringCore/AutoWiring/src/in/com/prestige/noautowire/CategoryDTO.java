package in.com.prestige.noautowire;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	private String categoryName;
	private BookDTO book;

	public void showCategory() {
		book.showBookDetails(categoryName);
	}
}
