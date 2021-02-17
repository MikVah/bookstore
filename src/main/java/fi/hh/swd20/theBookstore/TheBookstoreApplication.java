package fi.hh.swd20.theBookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.theBookstore.domain.Book;
import fi.hh.swd20.theBookstore.domain.BookRepository;

@SpringBootApplication
public class TheBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheBookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("Goldilocks and the Three Bears", "Robert Southey", "a1234", 1837, 20.00);
			Book book2 = new Book("Alice Through the Looking-Glass", "Lewis Carroll", "a5678", 1872, 25.00);
			Book book3 = new Book("Treasure Island", "Robert Louis Stevenson", "a9123", 1883, 18.50);
			
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);

		};
	}

}
