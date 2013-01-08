package sample.lrdev03.mvc.controller;

import java.util.List;
import javax.portlet.RenderResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import sample.lrdev03.mvc.domain.Book;
import sample.lrdev03.mvc.service.BookManager;

@Controller(value="bookController")
@RequestMapping(value = "VIEW")
public class BookController {
	static Logger log = Logger.getLogger(BookController.class.getName());

	// -- auto-wiring of service dependency
	@Autowired
	@Qualifier("myBookService")
	private BookManager bookService;

	public void setBookService(BookManager bookService) {
		log.info("bookService constructor");
		this.bookService = bookService;
	}

	// --maps the incoming portlet request to this method
	@RenderMapping
	public String showBooks(RenderResponse response) {
		log.info("showBooks");
		return "home";
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}
	
	// -- @ModelAttribute here works as the referenceData method
	@ModelAttribute(value="books")
	public List<Book> getBooks() {
		return bookService.getBookList();
	}
	
}
