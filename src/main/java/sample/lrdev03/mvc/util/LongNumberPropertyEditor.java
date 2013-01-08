package sample.lrdev03.mvc.util;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class LongNumberPropertyEditor extends PropertyEditorSupport {
	
	static Logger log = Logger.getLogger(LongNumberPropertyEditor.class.getName());
	
	@Override
	public String getAsText() {
		String returnVal = "";
		log.info("getValue() "+getValue());
		if(getValue() instanceof Long) {
			returnVal = String.valueOf((Long)getValue());
		}
		if(getValue() != null && getValue() instanceof String[]) {
			returnVal = ((String[]) getValue())[0];
		}
		return returnVal;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		log.info("Text to be converted"+text);
		if(StringUtils.isNumeric(text)){
			setValue(Long.valueOf(text));
		}
	}
}
