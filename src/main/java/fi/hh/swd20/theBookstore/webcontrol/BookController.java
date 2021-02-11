package fi.hh.swd20.theBookstore.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.swd20.theBookstore.domain.Book;

@Controller
public class BookController {

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String getAllBooks() {
		
		return "bookstore";
	}
}
