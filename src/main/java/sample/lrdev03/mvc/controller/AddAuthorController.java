package sample.lrdev03.mvc.controller;

import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;

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

import sample.lrdev03.mvc.domain.Author;
import sample.lrdev03.mvc.service.AuthorManager;
import sample.lrdev03.mvc.util.LongNumberPropertyEditor;

@Controller(value = "addAuthorController")
@RequestMapping(value = "VIEW")
public class AddAuthorController {
	@Autowired
	@Qualifier("myAuthorService")
	private AuthorManager authorService;
	
	public void setAuthorService(AuthorManager authorService){
		this.authorService = authorService;
	}

	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}

	@ActionMapping(params = "myaction=addAuthor")
	public void addBook(@ModelAttribute(value = "author") Author author,
			BindingResult bindingResult, ActionResponse response,
			SessionStatus sessionStatus) {
		if (!bindingResult.hasErrors()) {
			authorService.addAuthor(author);
			response.setRenderParameter("myaction", "books");
			// --set the session status as complete to cleanup the model
			// attributes
			// --stored using @SessionAttributes, otherwise when you click
			// --'Add Book' button you'll see the book information pre-populated
			// -- because the getCommandObject method of the controller is not
			// --invoked
			sessionStatus.setComplete();
		} else {
			response.setRenderParameter("myaction", "addAuthorForm");
		}
	}

	

}
