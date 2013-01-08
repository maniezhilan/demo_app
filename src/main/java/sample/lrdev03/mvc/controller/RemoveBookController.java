package sample.lrdev03.mvc.controller;

import java.io.IOException;

import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import sample.lrdev03.mvc.service.BookManager;

@Controller
@RequestMapping("VIEW")
public class RemoveBookController {
	@Autowired
	@Qualifier("myBookService")
	private BookManager bookService;

	@RenderMapping(params="myaction=removeBook")
	public String showBooks(RenderResponse response) {
		return "home";
	}
	
	@ResourceMapping(value="deleteBook")
	public void removeBook(@RequestParam Long isbnNumber,ResourceResponse response) throws IOException{
		bookService.deleteBook(isbnNumber);
	    response.setContentType("text");
	    response.resetBuffer();
	    response.getWriter().print(bookService.getBookList().size());
	    response.flushBuffer();
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}
	
}
