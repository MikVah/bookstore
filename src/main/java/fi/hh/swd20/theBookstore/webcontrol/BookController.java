package fi.hh.swd20.theBookstore.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fi.hh.swd20.theBookstore.domain.Book;
import fi.hh.swd20.theBookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(value="/booklist")
	public String getAllBooks(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		return "bookstore";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable(value="id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	
}
