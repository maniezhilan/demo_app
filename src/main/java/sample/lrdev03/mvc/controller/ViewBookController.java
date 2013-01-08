package sample.lrdev03.mvc.controller;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import sample.lrdev03.mvc.domain.Book;
import sample.lrdev03.mvc.service.BookManager;




@Controller
@RequestMapping(value="VIEW")
@SessionAttributes(value="book")
public class ViewBookController {
	
	static Logger log = Logger.getLogger(ViewBookController.class.getName());
	
	@Autowired
	@Qualifier("myBookService")
	private BookManager bookService;
	
	@RenderMapping(params="myaction=viewBook")
	public String viewBook(@ModelAttribute(value="book")
    Book book,SessionStatus sessionStatus) {
		log.info("book "+book);
		sessionStatus.setComplete();
		return "bookDetails";
	}
	

	@EventMapping(value ="{http://liferay.com/events}ipc.bookSearch")
	public void receiveEvent(EventRequest eventRequest, ModelMap map, EventResponse response,SessionStatus sessionStatus)
    {
            Event event = eventRequest.getEvent();
            String isbnNumber = (String)event.getValue();
            Book book = bookService.getBook(Long.parseLong(isbnNumber));
            map.put("book",book);
            response.setRenderParameter("myaction","viewBook");
    }
	
	

}
