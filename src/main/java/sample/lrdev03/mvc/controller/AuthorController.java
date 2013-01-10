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

import sample.lrdev03.mvc.domain.Author;
import sample.lrdev03.mvc.service.AuthorManager;

/*@Controller(value="authorController")
@RequestMapping(value = "VIEW")*/
public class AuthorController {
	/*static Logger log = Logger.getLogger(AuthorController.class.getName());

	// -- auto-wiring of service dependency
	@Autowired
	@Qualifier("myAuthorService")
	private AuthorManager authorService;

	public void setAuthorService(AuthorManager authorService) {
		log.info("authorService constructor");
		this.authorService = authorService;
	}

	// --maps the incoming portlet request to this method
	@RenderMapping
	public String showAuthors(RenderResponse response) {
		log.info("showAuthors");
		return "home_author";
	}
	
	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}
	
	// -- @ModelAttribute here works as the referenceData method
	@ModelAttribute(value="authors")
	public List<Author> getAuthors() {
		return authorService.getAuthors();
	}*/
	
}
