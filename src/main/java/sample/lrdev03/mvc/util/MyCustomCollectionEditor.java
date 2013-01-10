package sample.lrdev03.mvc.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import sample.lrdev03.mvc.service.AuthorManager;

public class MyCustomCollectionEditor extends CustomCollectionEditor {

	@Autowired
	@Qualifier("myAuthorService")
	private AuthorManager authorService;
	
	public void setAuthorService(AuthorManager authorService){
		this.authorService = authorService;
	}
	
	static Logger log = Logger.getLogger(MyCustomCollectionEditor.class.getName());
	
	public MyCustomCollectionEditor(Class collection){
		super(collection);
		log.info("MyCustomCollectionEditor");
	}
	
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
        if(id != null){
        	log.info(" authorService "+authorService);
        	try{
        	log.info(" authorService "+authorService.getAuthor(id));
        	}catch(NullPointerException ne){
        		log.info(" NullPointerException ");
        		ne.printStackTrace();
        	}
        }
        return id != null ? authorService.getAuthor(id) : null;
    }
  

}
