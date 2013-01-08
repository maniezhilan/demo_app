package sample.lrdev03.mvc.controller;

import javax.portlet.ActionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import sample.lrdev03.mvc.domain.Book;
import sample.lrdev03.mvc.service.BookManager;
import sample.lrdev03.mvc.util.LongNumberPropertyEditor;

@Controller(value="editBookController")
@RequestMapping(value="VIEW")
@SessionAttributes(value="book")
public class EditBookController {
	@Autowired
	@Qualifier("myBookService")
	private BookManager bookService;
	
	
	@RenderMapping(params="myaction=editBookForm")
	public String showEditBookForm() {
		return "editBookForm";
	}

	@ActionMapping(params="myaction=editBook")
	public void editBook(@ModelAttribute("book") Book book, BindingResult bindingResult, ActionResponse response, SessionStatus sessionStatus)  {
		if (!bindingResult.hasErrors()) {
			bookService.updateBook(book);
			response.setRenderParameter("myaction", "books");
			sessionStatus.setComplete();
		}
		//handle validation here
	}
	
	@InitBinder("book")
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Long.class, new LongNumberPropertyEditor());
		binder.setDisallowedFields(new String[] {"isbnNumber"});
	}
	
	@ModelAttribute("book")
	public Book getBook(@RequestParam Long isbnNumber) {
		return bookService.getBook(isbnNumber);
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}
}