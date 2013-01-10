package sample.lrdev03.mvc.util;

import java.util.List;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {

	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Long.class, new LongNumberPropertyEditor());
		//registry.registerCustomEditor(List.class, new MyCustomCollectionEditor(List.class));
	}

}