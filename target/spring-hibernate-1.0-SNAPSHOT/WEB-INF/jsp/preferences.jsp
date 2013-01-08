<%@ include file="/init.jsp"%>

<portlet:defineObjects />

<%
	PortletPreferences pref = renderRequest.getPreferences();
	String portletRes = ParamUtil.getString(request, "portletResource");
	if (Validator.isNotNull(portletRes)) {
   		pref = PortletPreferencesFactoryUtil.getPortletSetup(request, portletRes);
	}
 	String welcome_message = (String)pref.getValue("welcome_message", "Personalizable welcome message");
%>
	
<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm">    
    Welcome message: <input size="50" type="text" value="" name="<portlet:namespace />welcome_message"><br/><br/>    
    
    <input type="hidden" name="myaction" value="save_prefs">
    <input type="button" value="Save" onClick="submitForm(document.<portlet:namespace />fm);" /><br/><br/>             
</form>