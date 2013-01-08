package sample.lrdev03.search.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import com.liferay.portal.kernel.util.ParamUtil;

@Controller()
@RequestMapping(value = "VIEW")
public class SearchBookPortlet {
	
	static Logger log = Logger.getLogger(SearchBookPortlet.class.getName());

	@ActionMapping("bookSearch")
	public void bookSearch(SessionStatus status,ActionRequest request, ActionResponse response){
		String isbnNumber = ParamUtil.getString(request, "isbnNumber");
		log.info("searchBook called --"+isbnNumber);
		QName qname = new QName("http://liferay.com/events","ipc.bookSearch");
		response.setEvent(qname, isbnNumber);
		status.setComplete();
		response.setRenderParameter("myaction","viewBook");
	}
	
	@RenderMapping
	public String searchBooks(RenderResponse response, RenderRequest request, ModelMap model) {
		return "search";
	}
	
	
}