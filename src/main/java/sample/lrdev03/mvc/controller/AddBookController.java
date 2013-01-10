package sample.lrdev03.mvc.controller;

import java.util.List;

import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import sample.lrdev03.mvc.domain.Book;
import sample.lrdev03.mvc.service.AuthorManager;
import sample.lrdev03.mvc.service.BookManager;
import sample.lrdev03.mvc.util.MyCustomCollectionEditor;

@Controller(value = "addBookController")
@RequestMapping(value = "VIEW")
@SessionAttributes(types = Book.class)
public class AddBookController {
	static Logger log = Logger.getLogger(AddBookController.class.getName());

	@Autowired
	@Qualifier("myBookService")
	private BookManager bookService;
	
	@Autowired
	@Qualifier("myAuthorService")
	private AuthorManager authorService;

	public void setBookService(BookManager bookService) {
		this.bookService = bookService;
	}

	@ModelAttribute("book")
	public Book getCommandObject() {
		Book book = new Book();
		book.setAuthors(authorService.getAuthors());
		log.info("Book "+book);
		return book;
	}

	@RenderMapping(params = "myaction=addBookForm")
	public String showAddBookForm(@ModelAttribute(value = "book") Book book,RenderResponse response) {
		return "addBookForm";
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

	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}

	@ActionMapping(params = "myaction=addBook")
	public void addBook(@ModelAttribute(value = "book") Book book,
			BindingResult bindingResult, ActionResponse response,
			SessionStatus sessionStatus) {
		if (!bindingResult.hasErrors()) {
			bookService.addBook(book);
			response.setRenderParameter("myaction", "books");
			// --set the session status as complete to cleanup the model
			// attributes
			// --stored using @SessionAttributes, otherwise when you click
			// --'Add Book' button you'll see the book information pre-populated
			// -- because the getCommandObject method of the controller is not
			// --invoked
			sessionStatus.setComplete();
		} else {
			response.setRenderParameter("myaction", "addBookForm");
		}
	}
}
