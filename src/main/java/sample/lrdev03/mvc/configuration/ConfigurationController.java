package sample.lrdev03.mvc.configuration;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


@Controller
@RequestMapping("edit")
public class ConfigurationController {
	
	static Logger log = Logger.getLogger(ConfigurationController.class.getName());
	
	@RenderMapping
	public String renderPrefs(Model model, PortletPreferences prefs) {
		log.info("inside render");
		model.addAttribute("attribute", prefs.getValue("welcome_message",
				"Personalizable welcome message"));
		return "preferences";
	}

	@ActionMapping(params = "myaction=save_prefs")
	public void saveConfAction(@RequestParam("welcome_message") String myparam,
		PortletPreferences prefs, ActionRequest request, ActionResponse response)
			throws ReadOnlyException, ValidatorException, IOException,
			PortletModeException {
		if (myparam != null && !myparam.equals("")) {
			prefs.reset("welcome_message");
			prefs.setValue("welcome_message", myparam);
		}
		prefs.store();
	}
}
