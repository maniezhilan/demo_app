<%@ include file="/init.jsp"%>
<portlet:actionURL var="addAuthorActionUrl">
	<portlet:param name="myaction" value="addAuthor" />
</portlet:actionURL>


<form:form name="addAuthorForm" commandName="author" method="post"
	action="${addAuthorActionUrl}">
	<table>
		<tr align="left">
			<td><a href="${homeUrl}">Home</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>Author:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="name" /></td>
			<td><font style="color: #C11B17;"><form:errors
				path="name" /></font></td>
		</tr>
		
	</table>
	<table align="right">
		<tr>
			<td><input type="submit" value="Add Author" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</form:form>
<br></br>