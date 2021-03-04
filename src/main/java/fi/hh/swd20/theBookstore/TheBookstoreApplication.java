package fi.hh.swd20.theBookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.theBookstore.domain.Book;
import fi.hh.swd20.theBookstore.domain.BookRepository;
import fi.hh.swd20.theBookstore.domain.Category;
import fi.hh.swd20.theBookstore.domain.CategoryRepository;

@SpringBootApplication
public class TheBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheBookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			
			Category cate1 = new Category("Children");
			crepository.save(cate1);
			
			Category cate2 = new Category("Psychedellic");
			crepository.save(cate2);
			
			Category cate3 = new Category("Adventure");
			crepository.save(cate3);
			
			brepository.save(new Book("Goldilocks and the Three Bears", "Robert Southey", "a1234", 1837, 20.00, cate1));
			brepository.save(new Book("Alice Through the Looking-Glass", "Lewis Carroll", "a5678", 1872, 25.00, cate2));
			brepository.save(new Book("Treasure Island", "Robert Louis Stevenson", "a9123", 1883, 18.50, cate3));

		};
	}
	
	

}
