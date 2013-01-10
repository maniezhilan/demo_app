package sample.lrdev03.mvc.controller;

import java.util.List;

import javax.portlet.ActionResponse;

import org.apache.log4j.Logger;
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
import sample.lrdev03.mvc.service.AuthorManager;
import sample.lrdev03.mvc.service.BookManager;
import sample.lrdev03.mvc.util.LongNumberPropertyEditor;
import sample.lrdev03.mvc.util.MyCustomCollectionEditor;

@Controller(value="editBookController")
@RequestMapping(value="VIEW")
@SessionAttributes(value="book")
public class EditBookController {
	
	static Logger log = Logger.getLogger(EditBookController.class.getName()); 
	
	@Autowired
	@Qualifier("myBookService")
	private BookManager bookService;
	
	@Autowired
	@Qualifier("myAuthorService")
	private AuthorManager authorService;
	
	
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
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		log.info("inside binder");
		binder.registerCustomEditor(List.class, new MyCustomCollectionEditor(List.class){
			@Override
			protected Object convertElement(Object element)
		    {
				log.info("inside convertElement"+element);
				Long id = null;
		        if(element instanceof String && !((String)element).equals("")){
		            //From the JSP 'element' will be a String
		            try{
		                id = Long.parseLong((String) element);
		            }
		            catch (NumberFormatException e) {
		                log.info("Element was " + ((String) element));
		                e.printStackTrace();
		            }
		        }
		        else if(element instanceof Long) {
		            //From the database 'element' will be a Long
		            id = (Long) element;
		        }
		        return id != null ? authorService.getAuthor(id) : null;
		    }
		  
		});
	}

	
	@ModelAttribute("book")
	public Book getBook(@RequestParam Long isbnNumber) {
		Book book = bookService.getBook(isbnNumber);
		book.setAuthors(authorService.getAuthors());
		return book;
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}
}